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
      selectedGreen: null,
      error: null
    };

    this.getAllGreens = this.getAllGreens.bind(this);
    this.handleAddGreen = this.handleAddGreen.bind(this);
    this.handleError = this.handleError.bind(this);
    this.handleDismiss = this.handleDismiss.bind(this);
    this.handleSelectGreen = this.handleSelectGreen.bind(this);
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

  handleSelectGreen(green) {
    if(this.state.selectedGreen && green.id === this.state.selectedGreen.id) {
      this.setState({ selectedGreen: null });
    } else {
      this.setState({ selectedGreen: green });
    }
  }

  render() {
    const { greens, error, selectedGreen } = this.state;
    return (
      <div>
        <ErrorAlert message={error} onDismiss={this.handleDismiss}/>
        <div className="container App">
              <AddGreen onNewGreen={this.handleAddGreen} onError={this.handleError}></AddGreen>
              <ListGreens greens={greens} onClick={this.handleSelectGreen} selectedGreen={selectedGreen}></ListGreens>
        </div>
      </div>
    );
  }
}

export default App;
