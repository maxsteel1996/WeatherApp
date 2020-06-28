# WeatherApp
This is a fullstack application which shows the current and historical weather forcast upto previous 5 days, using https://openweathermap.org/.
I have used their one call api.
The number of selection of cities is limited to 4.

# Technology Used
- Java 8
- Springboot
- React JS

# Fetaure
- Current Weather Forcast
- Historical Weather Forcast
- Analytics for cities with their respective search type

# APIs exposed from Backend side
- GET /api/weather/current?city=Delhi
- GET /api/weather/historical?city=Mumbai
- GET /api/analytics

# Database schema for storing analytics
- city
- currentCount
- historicalCount

# Screenshot 

Current Weather
![image](https://github.com/maxsteel1996/WeatherApp/blob/master/ScreenShot/Screenshot_current_weather.PNG)

Previous Weather
![image](https://github.com/maxsteel1996/WeatherApp/blob/master/ScreenShot/Screenshot_Current.PNG)

Analytics
![image](https://github.com/maxsteel1996/WeatherApp/blob/master/ScreenShot/Screenshot_Analytics.PNG)
