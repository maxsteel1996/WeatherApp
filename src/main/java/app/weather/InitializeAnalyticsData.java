package app.weather;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.weather.dto.City;
import app.weather.entity.SearchAnalytics;
import app.weather.repository.AnalyticRepository;

@Component
public class InitializeAnalyticsData {

	@Autowired
	AnalyticRepository analyticRepository;

	@PostConstruct
	public void initData() {
		for (City c : City.values()) {
			analyticRepository.save(new SearchAnalytics((long) 0, (long) 0, c.getFullInfo()));
		}
	}

}
