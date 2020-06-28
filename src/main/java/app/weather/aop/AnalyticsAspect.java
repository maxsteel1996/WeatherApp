package app.weather.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import app.weather.dto.City;
import app.weather.entity.SearchAnalytics;
import app.weather.repository.AnalyticRepository;

@Aspect
@Configuration
public class AnalyticsAspect {

	@Autowired
	AnalyticRepository analyticRepository;

	private org.slf4j.Logger logger = LoggerFactory.getLogger(AnalyticsAspect.class);

	@AfterReturning(pointcut = "execution(* app.weather.service.WeatherForcastService.getCurrentForcast*(..))", returning = "retVal")
	public void afterCurrentForcast(JoinPoint jp, Object retVal) {
		Object[] args = jp.getArgs();
		City inputCity = (City) args[0];
		logger.info("[afterCurrentForcast] called with city: {}", inputCity);

		synchronized (this) {
			SearchAnalytics searchAnalytics = analyticRepository
					.findTopByCity(inputCity.getFullInfo())
					.orElse(new SearchAnalytics( (long) 0, (long) 0, inputCity.getFullInfo()));
			searchAnalytics.setCurrentCount(searchAnalytics.getCurrentCount() + 1);
			analyticRepository.save(searchAnalytics);
		}

		System.out.println("Returning:" + retVal.toString());
	}

	@AfterReturning(pointcut = "execution(* app.weather.service.WeatherForcastService.getHistoricalForcast*(..))", returning = "retVal")
	public void afterHistoricalForcast(JoinPoint jp, Object retVal) {
		Object[] args = jp.getArgs();
		City inputCity = (City) args[0];
		logger.info("[afterHistoricalForcast] called with city: {}", inputCity);
		synchronized (this) {
			SearchAnalytics searchAnalytics = analyticRepository
					.findTopByCity(inputCity.getFullInfo())
					.orElse(new SearchAnalytics( (long) 0, (long) 0, inputCity.getFullInfo()));
			searchAnalytics.setHistoricalCount(searchAnalytics.getHistoricalCount() + 1);
			analyticRepository.save(searchAnalytics);
		}
		System.out.println("Returning:" + retVal.toString());
	}
}