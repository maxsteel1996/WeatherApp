import React, { Component } from "react";
class Weather extends Component {
  state = {};
  render() {
    const imgurl = `http://openweathermap.org/img/w/${this.props.icon}.png`;
    return (
      <div className="weather__info">
        {this.props.icon && <img id="wicon" src={imgurl} alt="Weather icon" />}
        {this.props.description && (
          <span className="weather__value">{this.props.description}</span>
        )}
        {this.props.temperature && (
          <p className="weather__key">
            Temperature:{" "}
            <span className="weather__value">
              {this.props.temperature} degree Celsius
            </span>
          </p>
        )}
        {this.props.city && (
          <p className="weather__key">
            Location:
            <span className="weather__value">{this.props.city}</span>
          </p>
        )}

        {this.props.error && <p>{this.props.error}</p>}
      </div>
    );
  }
}

export default Weather;
