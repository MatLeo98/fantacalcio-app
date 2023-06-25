package it.disim.univaq.player.service;

import java.util.List;
import java.util.Optional;

import it.disim.univaq.player.model.Player;

public interface PlayerService {
	
	List<Player> findAll();

	Player findById(Long id);

	void create(Player user);

	void update(Player user);

	void delete(Long id);

	Optional<Player> findBySurname(String surname);
	
	List<Player> findByNationality(String nationality);

}
