import React, { Component } from "react";
class Weather extends Component {
  state = {};
  render() {
    const { city, date, icon, temp, weatherDescription } = this.props.data;
    const imgurl = `http://openweathermap.org/img/w/${icon}.png`;
    return (
      <div className="weather__info">
        {icon && <img id="wicon" src={imgurl} alt="Weather icon" />}
        {weatherDescription && (
          <span className="weather__value">{weatherDescription}</span>
        )}
        {temp && (
          <p className="weather__key">
            Temperature: <span className="weather__value">{temp}&#8451;</span>
          </p>
        )}
        {city && (
          <p className="weather__key">
            Location:
            <span className="weather__value">{city}</span>
          </p>
        )}
      </div>
    );
  }
}

export default Weather;
