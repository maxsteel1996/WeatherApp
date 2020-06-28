package app.weather.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString

public class SearchAnalytics {

	public SearchAnalytics(Long currentCount, Long historicalCount, String city) {
		this.currentCount = currentCount;
		this.historicalCount = historicalCount;
		this.city = city;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long currentCount;
	private Long historicalCount;
	private String city;

}
