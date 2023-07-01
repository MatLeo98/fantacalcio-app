package it.disim.univaq.stats.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.disim.univaq.stats.model.Stats;
import it.disim.univaq.stats.repository.StatsRepository;

@Service
public class StatsServiceImpl implements StatsService {
	
	@Autowired
	protected StatsRepository repository;

	@Override
	@Transactional(readOnly=true)
	public List<Stats> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Stats findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void create(Stats statistics) {
		repository.save(statistics);
		
	}

	@Override
	@Transactional
	public void update(Stats statistics) {
		repository.save(statistics);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public Optional<Stats> findByPLayerId(Long playerId) {
		return repository.findByPlayerId(playerId);
	}

}
