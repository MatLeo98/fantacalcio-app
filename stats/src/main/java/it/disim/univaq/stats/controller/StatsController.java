package it.disim.univaq.stats.controller;

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

import it.disim.univaq.stats.model.Stats;
import it.disim.univaq.stats.service.StatsService;

@RestController
@RequestMapping("/stats")
public class StatsController {
	
	@Value("${server.port}")
	private String portNumber;

	@Autowired
	private StatsService statisticService;

	@GetMapping
	public ResponseEntity<List<Stats>> getAllStatistics() {
		System.out.println(portNumber);
		return new ResponseEntity<List<Stats>>(statisticService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Stats> getStatisticsById(@PathVariable("id") Long id) {
		System.out.println(portNumber);
		return new ResponseEntity<Stats>(statisticService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/playerid/{playerId}")
	public ResponseEntity<Stats> getPlayerStatistics(@PathVariable("playerId") Long playerId) {
		System.out.println(portNumber);
		return new ResponseEntity<Stats>(statisticService.findByPLayerId(playerId).orElse(null), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> createStatistics(@RequestBody Stats statistics) {
		System.out.println(portNumber);
		statisticService.create(statistics);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping
	public ResponseEntity<Void> updateStatistics(@RequestBody Stats statistics) {
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
