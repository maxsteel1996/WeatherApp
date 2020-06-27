import React, { Component } from "react";
class Form extends Component {
  state = {};
  render() {
    const cities = ["Delhi", "Mumbai", "Lucknow", "Raipur"];
    const type = ["current", "Historical"];
    return (
      <form onSubmit={this.props.getWeather}>
        <select name="city" className="input_select">
          <option value="" disabled selected>
            Select City
          </option>
          {cities.map((city) => (
            <option value={city}>{city}</option>
          ))}
        </select>
        <select name="type" className="input_select">
          <option value="" disabled selected>
            Select Type
          </option>
          <option value="current">Current</option>
          <option value="historical">Historical</option>
        </select>
        <button>Get Weather</button>
      </form>
    );
  }
}

export default Form;
