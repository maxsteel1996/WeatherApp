package app.weather.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.weather.dto.City;
import app.weather.dto.CurrentWeatherDTO;
import app.weather.service.WeatherForcastService;

@RestController
@RequestMapping("/weather")
@CrossOrigin(origins = "*")
public class WeatherController {

	org.slf4j.Logger logger = LoggerFactory.getLogger(WeatherController.class);

	@Autowired
	WeatherForcastService weatherForcastService;

	@GetMapping("/current")
	ResponseEntity<CurrentWeatherDTO> getCurrentForcast(@RequestParam City city) throws Exception {
		logger.info("[getCurrentForcast] called with city : {}", city);
		CurrentWeatherDTO result = weatherForcastService.getCurrentForcast(city);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/historical")
	ResponseEntity<List<CurrentWeatherDTO>> getHistoricalForcast(@RequestParam City city) throws Exception {
		logger.info("[getHistoricalForcast] called with city : {}", city);
		List<CurrentWeatherDTO> result = weatherForcastService.getHistoricalForcast(city);
		return ResponseEntity.ok().body(result);
	}

}
