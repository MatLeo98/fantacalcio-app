package it.disim.univaq.statistics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.disim.univaq.statistics.model.Statistics;
import it.disim.univaq.statistics.repository.StatisticsRepository;

@Service
public class StatisticsServiceImpl implements StatisticsService {
	
	@Autowired
	protected StatisticsRepository repository;

	@Override
	@Transactional(readOnly=true)
	public List<Statistics> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Statistics findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void create(Statistics statistics) {
		repository.save(statistics);
		
	}

	@Override
	@Transactional
	public void update(Statistics statistics) {
		repository.save(statistics);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public Optional<Statistics> findByPLayerId(Long playerId) {
		return repository.findByPlayerId(playerId);
	}

}
