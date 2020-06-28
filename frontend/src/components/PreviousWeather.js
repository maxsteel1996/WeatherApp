import React, { Component } from "react";

const PreviousWeather = (props) => {
  console.log("prvious weather ---->{}", props);
  const { date, icon, temp, weatherDescription } = props.data;
  return (
    <tr className="weather__history">
      <td>
        <p> {date}</p>
      </td>
      <td>
        <p> {temp}&#8451;</p>
      </td>
      <td>
        <div style={{ float: "left" }}>
          <img
            id="wicon"
            src={`http://openweathermap.org/img/w/${icon}.png`}
            alt="Weather icon"
          />
          <p>{weatherDescription}</p>
        </div>
      </td>
    </tr>
  );
};

export default PreviousWeather;
