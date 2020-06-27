import React from "react";
import "./App.css";
import Titles from "./components/Titles";
import Form from "./components/Form";
import Weather from "./components/Weather";
import PreviousWeather from "./components/PreviousWeather";

const API_KEY = "1c9770dfaf3b327dd03510a4c07b7f2d";

const SERVER_URL = "http://localhost:8080";

class App extends React.Component {
  state = {
    temperature: undefined,
    city: undefined,
    icon: undefined,
    description: undefined,
    logo: undefined,
    error: undefined,
  };

  getWeather = async (e) => {
    e.preventDefault();
    const city = e.target.elements.city.value;
    const type = e.target.elements.type.value;
    const api_call = await fetch(
      `${SERVER_URL}/api/weather/${type}?city=${city}`
    );
    const data = await api_call.json();
    console.log(data);
    if (city && type) {
      this.setState({
        temperature: data.temp,
        city: data.city,
        description: data.weatherDescription,
        icon: data.icon,
        error: "",
      });
    } else {
      this.setState({
        temperature: undefined,
        city: undefined,
        icon: undefined,
        description: undefined,
        logo: undefined,
        error: "please enter city and country",
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
                  <Titles />
                </div>
                <div className="col-xs-6 form-container">
                  <Form getWeather={this.getWeather} />
                  <div className="overflow-auto">
                    <PreviousWeather />
                    <PreviousWeather />
                    <PreviousWeather />
                    <PreviousWeather />
                    <PreviousWeather />
                  </div>

                  <Weather
                    temperature={this.state.temperature}
                    city={this.state.city}
                    description={this.state.description}
                    icon={this.state.icon}
                    error={this.state.error}
                  />
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
