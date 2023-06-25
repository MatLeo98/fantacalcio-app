package it.disim.univaq.player.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.disim.univaq.player.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	Optional<Player> findBySurname(String surname);
	
	List<Player> findByNationality(String nationality);

}
