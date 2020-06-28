package app.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.weather.entity.SearchAnalytics;
import app.weather.repository.AnalyticRepository;

@Service
public class AnalyticsService {

	@Autowired
	AnalyticRepository analyticRepository;

	public Iterable<SearchAnalytics> findAll() {
		return analyticRepository.findAll();
	};

}
