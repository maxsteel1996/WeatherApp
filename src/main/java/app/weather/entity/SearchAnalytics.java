package app.weather.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
