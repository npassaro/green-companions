import React from 'react';
import PropTypes from 'prop-types';
import './add-green.scss';

import { Period } from '../period/period.component';

export class AddGreen extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      description: '',
      sowPeriod: [],
      growPeriod: [],
      harvestPeriod: []
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handlePeriodChange = this.handlePeriodChange.bind(this);
  }

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  handlePeriodChange(checkedMonths) {
    this.setState({
      ...checkedMonths
    });
  }

  handleSubmit(event) {
    event.preventDefault();
    fetch('http://localhost:8080/api/1/green-companions', {
      method: 'post',
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'

      },
      body: JSON.stringify(this.state)
    })
    .then(response => {
      if (response.ok) {
        return response.json();
      }
      throw response;
    })
    .then(green => this.props.onNewGreen(green))
    .catch(() => this.props.onError('Failed to add a new green. Make sure the name is unique and all mandatory fields are set?'))
  }

  render() {
    return (
      <form
        onSubmit={this.handleSubmit}
        className="container AddGreen_form"
      >
        <div className="form-group">
          <label className="AddGreen_label" htmlFor="name">Name</label>
          <input
            type="text"
            name="name"
            className="form-control"
            value={this.state.name}
            onChange={this.handleChange}
          />
        </div>
        <div className="form-group">
          <label className="AddGreen_label" htmlFor="description">Description</label>
          <textarea
            type="text"
            name="description"
            className="form-control"
            value={this.state.description}
            onChange={this.handleChange}
          />
        </div>
        <div className="row">
          <div className="form-group col">
            <fieldset className="AddGreen_fieldset">
              <legend className="h5">Sow Period</legend>
              <Period
                name="sowPeriod"
                className="form-control"
                checkedMonths={this.state.sowPeriod}
                onChange={this.handlePeriodChange}
              />
            </fieldset>
          </div>
          <div className="form-group col">
            <fieldset className="AddGreen_fieldset">
              <legend className="h5">Grow Period</legend>
              <Period
                name="growPeriod"
                className="form-control"
                checkedMonths={this.state.growPeriod}
                onChange={this.handlePeriodChange}
              />
            </fieldset>
          </div>
          <div className="form-group col">
            <fieldset className="AddGreen_fieldset">
              <legend className="h5">Harvest Period</legend>
              <Period
                name="harvestPeriod"
                className="form-control"
                checkedMonths={this.state.harvestPeriod}
                onChange={this.handlePeriodChange}
              />
            </fieldset>
          </div>
        </div>
        <input className="btn btn-success AddGreen_button" type="submit" value="Submit" />
      </form>
    );
  }
}

AddGreen.propTypes = {
  onNewGreen: PropTypes.object.isRequired,
  onError: PropTypes.object.isRequired
};
