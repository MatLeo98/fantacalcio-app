package it.disim.univaq.statistics.service;

import java.util.List;
import java.util.Optional;

import it.disim.univaq.statistics.model.Statistics;
import org.springframework.transaction.annotation.Transactional;

public interface StatisticsService {
	
	List<Statistics> findAll();

	Statistics findById(Long id);

	void create(Statistics playerStatistics);

	void update(Statistics playerStatistics);

	void delete(Long id);

	Optional<Statistics> findByPLayerId(Long playerId);
}
