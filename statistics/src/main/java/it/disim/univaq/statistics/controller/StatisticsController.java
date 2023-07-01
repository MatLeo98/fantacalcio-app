package it.disim.univaq.statistics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.disim.univaq.statistics.model.Statistics;
import it.disim.univaq.statistics.service.StatisticsService;

@RestController
@RequestMapping("/stats")
public class StatisticsController {
	
	@Value("${server.port}")
	private String portNumber;

	@Autowired
	private StatisticsService statisticService;

	@GetMapping
	public ResponseEntity<List<Statistics>> getAllStatistics() {
		System.out.println(portNumber);
		return new ResponseEntity<List<Statistics>>(statisticService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Statistics> getStatisticsById(@PathVariable("id") Long id) {
		System.out.println(portNumber);
		return new ResponseEntity<Statistics>(statisticService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/playerid/{playerId}")
	public ResponseEntity<Statistics> getPlayerStatistics(@PathVariable("playerId") Long playerId) {
		System.out.println(portNumber);
		return new ResponseEntity<Statistics>(statisticService.findByPLayerId(playerId).orElse(null), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> createStatistics(@RequestBody Statistics statistics) {
		System.out.println(portNumber);
		statisticService.create(statistics);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping
	public ResponseEntity<Void> updateStatistics(@RequestBody Statistics statistics) {
		System.out.println(portNumber);
		statisticService.update(statistics);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	//FORSE SI PUò TOGLIERE PERCHé NON HA SENSO ELIMINARE UNICAMENTE LE STATISTICHE, ANDREBBERO ELIMINATE CASCADE CON IL PLAYER
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Void> deleteStatistics(@PathVariable("id") Long id) {
		System.out.println(portNumber);
		statisticService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
