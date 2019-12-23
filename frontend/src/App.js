import React from 'react';
import './App.scss';
import { AddGreen } from './add-green/';
import { ListGreens } from './list-greens/';
import { ErrorAlert } from './alerts';
import { COMPANION_TYPE, getCompanionType } from './constants';



class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      greens: [],
      selectedGreen: {},
      error: null
    };

    this.getAllGreens = this.getAllGreens.bind(this);
    this.handleAddGreen = this.handleAddGreen.bind(this);
    this.handleError = this.handleError.bind(this);
    this.handleDismiss = this.handleDismiss.bind(this);
    this.handleSelectGreen = this.handleSelectGreen.bind(this);
    this.handleCompanionClick = this.handleCompanionClick.bind(this);
    this.requestCompanion = this.requestCompanion.bind(this);
    this.addCompanion = this.addCompanion.bind(this);
    this.removeCompanion = this.removeCompanion.bind(this);
  }

  componentDidMount() {
    this.getAllGreens();
  }

  requestCompanion(method, type, id, companion) {
    fetch(`http://localhost:8080/api/1/green-companions/${id}/${type}-companions`, {
      method: method,
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'

      },
      body: JSON.stringify(companion)
    })
    .then(response => {
      if (response.ok) {
        return response.json();
      }
      throw response;
    })
    .then(selectedGreen => this.setState({
      selectedGreen,
      greens: this.state.greens.map(green => green.id === selectedGreen.id ? selectedGreen : green),
    } ))
    .catch((e) => this.handleError(`Failed request on companion id(${companion.id}) to green with id(${id})`));
  }

  addCompanion(type, id, companion) {
    this.requestCompanion('post', type, id, companion);
  }

  removeCompanion(type, id, companion) {
    this.requestCompanion('delete', type, id, companion);
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

  handleCompanionClick(companion, clickedCompanionType) {
    const { id } = this.state.selectedGreen;
    console.log('handleCompanionClick#selected', this.state.selectedGreen)
    console.log('handleCompanionClick#companion', companion)
    const companionType = getCompanionType(companion, this.state.selectedGreen);

    switch (companionType) {
      case COMPANION_TYPE.good:
        this.removeCompanion('good', id, companion);
        break;
      case COMPANION_TYPE.bad:
        this.removeCompanion('bad', id, companion);
        break;
      default:
        Object
          .entries(COMPANION_TYPE)
          .filter(([, id]) => id === clickedCompanionType)
          .map(([type, ]) => this.addCompanion(type, id, companion));
    }
  }



  handleError(error) {
    this.setState({ error: error});
  }

  handleDismiss() {
    this.setState({ error: null});
  }

  handleSelectGreen(green) {
    if(this.state.selectedGreen && green.id === this.state.selectedGreen.id) {
      this.setState({ selectedGreen: {} });
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
              <AddGreen
                onNewGreen={this.handleAddGreen}
                onError={this.handleError}
              ></AddGreen>
              <ListGreens
                greens={greens}
                onClick={this.handleSelectGreen}
                selectedGreen={selectedGreen}
                onCompanionClick={this.handleCompanionClick}
              ></ListGreens>
        </div>
      </div>
    );
  }
}

export default App;
