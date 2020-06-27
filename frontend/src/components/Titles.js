import React, { Component } from "react";
class Titles extends Component {
  state = {};
  render() {
    return (
      <div>
        <h1 className="title-container__title">Weather Finder</h1>
        <h3 className="title-container__subtitle">
          Find out temperature condition or more ...
        </h3>
      </div>
    );
  }
}

export default Titles;
