import React, { Component } from "react";

class Titles extends Component {
  state = {};
  render() {
    return (
      <div>
        <h1 className="title-container__title">Weather Forcast</h1>
        <h3 className="title-container__subtitle">
          Find out current and Historical Weather Forcast ...
        </h3>
        <button onClick={this.props.switchWeatherFinder}>Find Weather</button>
        <button onClick={this.props.switchAnalytics}>Analytics</button>
      </div>
    );
  }
}

export default Titles;
