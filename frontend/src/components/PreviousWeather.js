import React, { Component } from "react";

const PreviousWeather = (props) => (
  <div className="weather__history">
    <div class="row">
      <p className="col-xs-4"> 28 Jun 2020</p>
      <p className="col-xs-4"> 36 Degree Celcius</p>
      <div style={{ float: "right", marginRight: "50px" }}>
        <img
          id="wicon"
          src="http://openweathermap.org/img/w/50n.png"
          alt="Weather icon"
        />
        <p style={{ marginBottom: "0px" }}> hazzzzzy</p>
      </div>
    </div>
  </div>
);

export default PreviousWeather;
