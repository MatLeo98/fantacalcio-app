package it.disim.univaq.fantacalcio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import it.disim.univaq.fantacalcio.endpoints.Lineups;
import it.disim.univaq.fantacalcio.endpoints.LineupsImplService;
import it.disim.univaq.fantacalcio.feignclient.PlayerMicroserviceFeignClient;
import it.disim.univaq.fantacalcio.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.disim.univaq.fantacalcio.endpoints.Team;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/best-formation")
public class ProsumerController {
	@Value("${server.port}")
	private String portNumber;

	@Autowired
	private PlayerMicroserviceFeignClient playerMicroserviceFeignClient;

	@GetMapping
	@Operation(summary = "Get the best formation of all teams")
	public List<Player> getBestFormation(@Parameter(description = "The desired formation") String formationDesired) {
		System.out.println("\t\t [ProsumerController] - getBestFormation() invoked" + " on port " + portNumber);

		var availableFormations = List.of("3-4-3", "3-5-2", "4-3-3", "4-4-2", "4-5-1", "5-3-2", "5-4-1");
		if (formationDesired == null || !availableFormations.contains(formationDesired)) {
			formationDesired = "4-3-3";
		}
		// Retrieve the lineups of all teams from the SOAP service
		List<Team> titolariSerieA = lineupAllInvoke();

		// Retrieve the list of all players in the lineups from the player REST microservice
		List<Player> players = titolariSerieA.stream()
				.flatMap(team -> team.getPlayers().getPlayer().stream())
				.map(player -> playerMicroserviceFeignClient.getPlayerBySurname(player.getSurname()))
				.toList();

		// Calculate the best formation
		var formation = Arrays.stream(formationDesired.split("-")).mapToInt(Integer::parseInt).toArray();
		var bestFormation = new ArrayList<Player>();

		players.forEach(System.out::println);

		Map<String, List<Player>> playerMap = players.stream()
				.collect(Collectors.groupingBy(Player::role));

		playerMap.getOrDefault("P", new ArrayList<>()).stream()
				.max(Comparator.comparing(Player::fanta_value))
				.ifPresent(bestFormation::add);

		playerMap.getOrDefault("D", new ArrayList<>()).stream()
				.sorted(Comparator.comparing(Player::fanta_value).reversed())
				.limit(formation[0])
				.forEach(bestFormation::add);

		playerMap.getOrDefault("C", new ArrayList<>()).stream()
				.sorted(Comparator.comparing(Player::fanta_value).reversed())
				.limit(formation[1])
				.forEach(bestFormation::add);

		playerMap.getOrDefault("A", new ArrayList<>()).stream()
				.sorted(Comparator.comparing(Player::fanta_value).reversed())
				.limit(formation[2])
				.forEach(bestFormation::add);

		return bestFormation;
	}


	private static List<Team> lineupAllInvoke() {
		LineupsImplService service = new LineupsImplService();
		Lineups port = service.getLineupsImplPort();
		return port.lineupOfAllTeams();
	}
}
