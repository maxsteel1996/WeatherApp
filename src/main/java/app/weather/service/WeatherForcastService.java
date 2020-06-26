package app.weather.service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.weather.model.City;
import app.weather.model.CurrentWeatherDTO;

@Service
public class WeatherForcastService {

	@Value("${weather.url}")
	private String url;

	@Value("${weather.apikey}")
	private String apikey;

	@Autowired
	RestTemplate restTemp;

	public CurrentWeatherDTO getCurrentForcast(City city) throws Exception {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(url).path("")
				.query("lat={lattitude}&lon={longitude}&appid={appid}&exclude=minutely,daily,hourly&units=metric")
				.buildAndExpand(city.getLatitude(), city.getLongitude(), apikey);
		String uri = uriComponents.toUriString();
		ResponseEntity<String> resp = restTemp.exchange(uri, HttpMethod.GET, null, String.class);
		return convertIntoCurrentWeatherResponse(resp.getBody(), city);
	}

	public List<CurrentWeatherDTO> getHistoricalForcast(City city)
			throws JsonMappingException, JsonProcessingException {
		List<CurrentWeatherDTO> forcastHistory = new ArrayList<>();
		long ut1 = Instant.now().getEpochSecond();
		Instant originalInstant = Instant.ofEpochSecond(ut1);
		for (int i = 1; i <= 5; i++) {
			long apiDate = originalInstant.minus(i, ChronoUnit.DAYS).getEpochSecond();
			String transformedDate = new SimpleDateFormat("H:mm  dd MMM yy").format(new Date(apiDate * 1000));
			System.out.println("date : " + transformedDate + " " + (apiDate));
			UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("http").host(url)
					.path("timemachine")
					.query("lat={lattitude}&lon={longitude}&appid={appid}&dt={dt}&exclude=minutely,daily,hourly&units=metric")
					.buildAndExpand(city.getLatitude(), city.getLongitude(), apikey, apiDate);
			String uri = uriComponents.toUriString();
			try {
				ResponseEntity<String> resp = restTemp.exchange(uri, HttpMethod.GET, null, String.class);
				forcastHistory.add(convertIntoCurrentWeatherResponse(resp.getBody(), city));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return forcastHistory;
	}

	private CurrentWeatherDTO convertIntoCurrentWeatherResponse(String response, City city)
			throws JsonMappingException, JsonProcessingException {
		ObjectMapper objMapper = new ObjectMapper();
		JsonNode root = objMapper.readTree(response);
		JsonNode currentNode = root.get("current");
		JsonNode weatherArray = currentNode.get("weather").get(0);
		CurrentWeatherDTO currentWeatherDTO = new CurrentWeatherDTO();
		currentWeatherDTO.setIcon(weatherArray.get("icon").asText());
		currentWeatherDTO.setTemp(currentNode.get("temp").asText());
		currentWeatherDTO.setWeatherDescription(weatherArray.get("description").asText());
		currentWeatherDTO.setCity(city.getFullInfo());
		currentWeatherDTO.setLat(city.getLatitude());
		currentWeatherDTO.setLongt(city.getLongitude());
		Long dt = currentNode.get("dt").asLong();
		currentWeatherDTO.setDate(new Date((dt * 1000)));
		return currentWeatherDTO;
	}

}
