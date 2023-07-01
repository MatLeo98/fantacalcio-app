package it.disim.univaq.stats.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.disim.univaq.stats.model.Stats;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {
	
	Optional<Stats> findByPlayerId(Long playerId);

}
