package app.weather.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CurrentWeatherDTO {
	private String weatherDescription;
	private String icon;
	private String temp;
	private String city;
	private String lat;
	private String longt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date date;
}
