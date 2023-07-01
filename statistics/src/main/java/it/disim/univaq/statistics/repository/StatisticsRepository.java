package it.disim.univaq.statistics.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.disim.univaq.statistics.model.Statistics;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
	
	Optional<Statistics> findByPlayerId(Long playerId);

}
