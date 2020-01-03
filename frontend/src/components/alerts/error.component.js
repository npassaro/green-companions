import React from 'react';

export class ErrorAlert extends React.Component {
  componentDidUpdate(prevProps) {
    if(prevProps.message !== this.props.message) {
      this.intervalID = setInterval(
        () => this.props.onDismiss(),
        5000
      );
    }
  }

  componentWillUnmount() {
    clearInterval(this.intervalID);
  }

  render() {
    const { message } = this.props;
    console.log(message);
    if(message) {
      return(
        <div className="alert alert-danger" role="alert">
          {message}
        </div>
      );
    } else {
      return null;
    }
  }
}
