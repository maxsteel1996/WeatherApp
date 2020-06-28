import React from "react";
import "./App.css";
import Titles from "./components/Titles";
import Form from "./components/Form";
import Weather from "./components/Weather";
import PreviousWeather from "./components/PreviousWeather";
import Analytics from "./components/Analytics";

const SERVER_URL = "http://localhost:8080";

class App extends React.Component {
  state = {
    isWeatherDisplay: true,
  };

  getWeather = async (e) => {
    e.preventDefault();
    const city = e.target.elements.city.value;
    const type = e.target.elements.type.value;
    if (city && type) {
      this.setState({
        isLoading: true,
        data: undefined,
        error: undefined,
        type: undefined,
      });
      try {
        const api_call = await fetch(
          `${SERVER_URL}/api/weather/${type}?city=${city}`
        );
        const responseData = await api_call.json();
        console.log("response back from server : {}", responseData);
        this.setState({ isLoading: false, data: responseData, type: type });
      } catch (e) {
        this.setState({ isLoading: false, error: "some error occured" });
      }
    } else {
      this.setState({
        data: undefined,
        error: "please enter city and country",
      });
    }
  };

  switchWeatherFinder = () => {
    this.setState({
      isLoading: false,
      data: undefined,
      error: undefined,
      type: undefined,
      isWeatherDisplay: true,
    });
  };

  switchAnalytics = async () => {
    this.setState({
      isLoading: true,
      data: undefined,
      error: undefined,
      type: undefined,
    });
    try {
      const api_call = await fetch(`${SERVER_URL}/api/analytics`);
      const responseData = await api_call.json();
      console.log("response back from server : {}", responseData);
      this.setState({
        isLoading: false,
        data: responseData,
        isWeatherDisplay: false,
      });
    } catch (e) {
      console.log("error while fetching analytics : {}", e);
      this.setState({
        isLoading: false,
        isWeatherDisplay: false,
        error: "some error occured",
      });
    }
  };

  render() {
    return (
      <div>
        <div className="wrapper">
          <div className="main">
            <div className="container">
              <div className="row">
                <div className="col-xs-5 title-container">
                  <Titles
                    switchWeatherFinder={this.switchWeatherFinder}
                    switchAnalytics={this.switchAnalytics}
                  />
                </div>

                <div className="col-xs-6 form-container">
                  {this.state.isWeatherDisplay && (
                    <div>
                      <Form getWeather={this.getWeather} />
                      {this.state.isLoading && (
                        <h3 style={{ color: "#fff" }}>Loading .... </h3>
                      )}
                      {this.state.error && (
                        <h3 style={{ color: "#fff" }}>{this.state.error}</h3>
                      )}
                      {this.state.type === "current" && (
                        <Weather data={this.state.data} />
                      )}
                      {this.state.type === "historical" && (
                        <div className="table-responsive">
                          <table class="table">
                            <thead>
                              <tr className="weather__history">
                                <th>Date</th>
                                <th>Temperature</th>
                                <th>Description</th>
                              </tr>
                            </thead>
                            <tbody>
                              {this.state.data.map((data) => (
                                <PreviousWeather data={data} />
                              ))}
                            </tbody>
                          </table>
                        </div>
                      )}
                    </div>
                  )}
                  {!this.state.isWeatherDisplay && (
                    <Analytics
                      data={this.state.data}
                      error={this.state.error}
                      isLoading={this.state.isLoading}
                    />
                  )}
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default App;
