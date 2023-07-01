package it.disim.univaq.stats.service;

import java.util.List;
import java.util.Optional;

import it.disim.univaq.stats.model.Stats;
import org.springframework.transaction.annotation.Transactional;

public interface StatsService {
	
	List<Stats> findAll();

	Stats findById(Long id);

	void create(Stats playerStatistics);

	void update(Stats playerStatistics);

	void delete(Long id);

	Optional<Stats> findByPLayerId(Long playerId);
}
