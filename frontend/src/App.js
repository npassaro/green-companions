import React from 'react';
import './App.scss';
import { AddGreen } from './add-green/';
import { ListGreens } from './list-greens/';
import { ErrorAlert } from './alerts';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      greens: [],
      error: null
    };

    this.getAllGreens = this.getAllGreens.bind(this);
    this.handleAddGreen = this.handleAddGreen.bind(this);
    this.handleError = this.handleError.bind(this);
    this.handleDismiss = this.handleDismiss.bind(this);
  }

  componentDidMount() {
    this.getAllGreens();
  }

  getAllGreens() {
    fetch('http://localhost:8080/api/1/green-companions', {
      headers: {
        'Accept': 'application/json'
      }
    })
    .then(response => {
      if(response.ok) {
        return response.json()
      }
      throw response;
    })
    .then(greens => this.setState({ greens }))
    .catch(error => this.handleError('Could not fetch greens. Server unavailable.'));
  }

  handleAddGreen(green) {
    const greens = this.state.greens.concat(green).sort((a, b)=> a.id - b.id);
    this.setState({ greens, error: null });
  }

  handleError(error) {
    this.setState({ error: error});
  }

  handleDismiss() {
    this.setState({ error: null});
  }

  render() {
    const { greens, error } = this.state;
    return (
      <div>
        <ErrorAlert message={error} onDismiss={this.handleDismiss}/>
        <div className="container App">
              <AddGreen onNewGreen={this.handleAddGreen} onError={this.handleError}></AddGreen>
              <ListGreens greens={greens}></ListGreens>
        </div>
      </div>
    );
  }
}

export default App;
