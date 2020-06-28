import React, { Component } from "react";

class Analytics extends Component {
  state = {};
  render() {
    return (
      <div className="weather__history">
        <h1> Analytics</h1>

        {this.props.isLoading && (
          <h3 style={{ color: "#fff" }}>Loading .... </h3>
        )}
        {this.props.error && (
          <h3 style={{ color: "#fff" }}>{this.props.error}</h3>
        )}

        {this.props.data && (
          <table class="table">
            <thead>
              <tr className="weather__history">
                <th>City</th>
                <th>Current Search</th>
                <th>Historical Search</th>
              </tr>
            </thead>
            <tbody>
              {this.props.data.map((d) => (
                <tr>
                  <td>{d.city}</td>
                  <td>{d.currentCount}</td>
                  <td>{d.historicalCount}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    );
  }
}

export default Analytics;
