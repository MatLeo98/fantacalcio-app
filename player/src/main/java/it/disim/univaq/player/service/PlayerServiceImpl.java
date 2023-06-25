package it.disim.univaq.player.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.disim.univaq.player.model.Player;
import it.disim.univaq.player.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	protected PlayerRepository repository;

	@Override
	@Transactional(readOnly=true)
	public List<Player> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Player findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void create(Player player) {
		repository.save(player);
		
	}

	@Override
	@Transactional
	public void update(Player player) {
		repository.save(player);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Player> findBySurname(String surname) {
		return repository.findBySurname(surname);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Player> findByNationality(String nationality) {
		return repository.findByNationality(nationality);
	}

}
