package app.weather.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.weather.entity.SearchAnalytics;

@Repository
public interface AnalyticRepository extends CrudRepository<SearchAnalytics, Long> {

	Optional<SearchAnalytics> findTopByCity(String fullInfo);

}
