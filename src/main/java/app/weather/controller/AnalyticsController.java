package app.weather.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.weather.service.AnalyticsService;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

	org.slf4j.Logger logger = LoggerFactory.getLogger(AnalyticsController.class);

	@Autowired
	AnalyticsService analyticsService;

	@GetMapping
	ResponseEntity<?> getAnalytics() {
		logger.info("[getCurrentForcast] called");
		return ResponseEntity.ok().body(analyticsService.findAll());
	}

}
