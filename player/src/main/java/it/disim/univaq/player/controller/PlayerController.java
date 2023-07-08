package it.disim.univaq.player.controller;

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

import it.disim.univaq.player.model.Player;
import it.disim.univaq.player.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {
	
	@Value("${server.port}")
	private String portNumber;

	@Autowired
	private PlayerService playerService;

	@GetMapping
	public ResponseEntity<List<Player>> getAllPlayers() {
		System.out.println(portNumber);
		return new ResponseEntity<>(playerService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Player> getPlayerById(@PathVariable("id") Long id) {
		System.out.println(portNumber);
		return new ResponseEntity<Player>(playerService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/surname/{surname}")
	public ResponseEntity<Player> getPlayerBySurname(@PathVariable("surname") String surname) {
		System.out.println(portNumber);
		return new ResponseEntity<Player>(playerService.findBySurname(surname).orElse(null), HttpStatus.OK);
	}
	
	@GetMapping("/nationality/{nationality}")
	public ResponseEntity<List<Player>> getPlayerByNationality(@PathVariable("nationality") String nationality) {
		System.out.println(portNumber);
		return new ResponseEntity<List<Player>>(playerService.findByNationality(nationality), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> createPlayer(@RequestBody Player player) {
		System.out.println(portNumber);
		playerService.create(player);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping
	public ResponseEntity<Void> updatePlayer(@RequestBody Player player) {
		System.out.println(portNumber);
		playerService.update(player);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<Void> deletePlayer(@PathVariable("id") Long id) {
		System.out.println(portNumber);
		playerService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
