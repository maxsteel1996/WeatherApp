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
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString

public class SearchAnalytics {

	public SearchAnalytics(Date date, Long count, SearchType type, String city) {
		this.date = date;
		this.count = count;
		this.type = type;
		this.city = city;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private Long count;
	private SearchType type;
	private String city;

}
