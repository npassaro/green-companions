import React from 'react';
import './App.scss';
import { AddGreen } from './add-green/';
import { ListGreens } from './list-greens/';
import { ErrorAlert } from './alerts';
import { COMPANION_TYPE, getCompanionType, backendUrl } from './constants';
import { getAllGreens, requestCompanion } from './services';

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
    this.handleDismissError = this.handleDismissError.bind(this);
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
    requestCompanion(method, type, id, companion)
      .then(selectedGreen => this.setState({
        selectedGreen,
        greens: this.state.greens.map(green => green.id === selectedGreen.id ? selectedGreen : green),
      }))
      .catch((e) => this.handleError(`Failed request on companion id(${companion.id}) to green with id(${id})`));
  }

  addCompanion(type, id, companion) {
    this.requestCompanion('post', type, id, companion);
  }

  removeCompanion(type, id, companion) {
    this.requestCompanion('delete', type, id, companion);
  }

  getAllGreens() {
    getAllGreens()
      .then(greens => this.setState({ greens }))
      .catch(error => this.handleError('Could not fetch greens. Server unavailable.'));
  }

  handleAddGreen(green) {
    const greens = this.state.greens.concat(green).sort((a, b)=> a.id - b.id);
    this.setState({ greens, error: null });
  }

  handleCompanionClick(companion, clickedCompanionType) {
    const { id } = this.state.selectedGreen;
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
          .filter(([, typeId]) => typeId === clickedCompanionType)
          .map(([type, ]) => this.addCompanion(type, id, companion));
    }
  }



  handleError(error) {
    this.setState({ error: error});
  }

  handleDismissError() {
    this.setState({ error: null});
  }

  handleSelectGreen(green) {
    if(green.id === this.state.selectedGreen.id) {
      this.setState({ selectedGreen: {} });
    } else {
      this.setState({ selectedGreen: green });
    }
  }

  render() {
    const { greens, error, selectedGreen } = this.state;
    return (
      <div>
        <ErrorAlert message={error} onDismiss={this.handleDismissError}/>
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
