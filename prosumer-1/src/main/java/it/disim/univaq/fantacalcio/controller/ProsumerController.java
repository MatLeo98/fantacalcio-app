package it.disim.univaq.fantacalcio.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.xml.ws.Response;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import it.disim.univaq.fantacalcio.endpoints.LineupOfAllTeams;
import it.disim.univaq.fantacalcio.endpoints.LineupOfAllTeamsResponse;
import it.disim.univaq.fantacalcio.endpoints.Lineups;
import it.disim.univaq.fantacalcio.endpoints.LineupsImplService;
import it.disim.univaq.fantacalcio.feignclient.PlayerMicroserviceFeignClient;
import it.disim.univaq.fantacalcio.model.Player;

@RestController
@RequestMapping("/best-formation")
public class ProsumerController {
	@Value("${server.port}")
	private String portNumber;

	@Autowired
	private PlayerMicroserviceFeignClient playerMicroserviceFeignClient;

	@GetMapping
	@Operation(summary = "Get the best formation of all teams")
	public List<Player> getBestFormation(@Parameter(description = "The desired formation") String formationDesired)
			throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
		System.out.println("\t\t [ProsumerController] - getBestFormation() invoked" + " on port " + portNumber);

		List<String> availableFormations = Arrays.asList("3-4-3", "3-5-2", "4-3-3", "4-4-2", "4-5-1", "5-3-2", "5-4-1");

		if (formationDesired == null || !availableFormations.contains(formationDesired)) {
			formationDesired = "4-3-3";
		}

		// Retrieve the lineups of all teams from the SOAP service
		System.out.println("Invoking the async service");
		Response<LineupOfAllTeamsResponse> titolariSerieAResponse = titolariSerieAInvok();

		System.out.println("I will call the player-microservice in the meantime");
		List<Player> giocatoriSerieA = new ArrayList<>();
		giocatoriSerieA = playerMicroserviceFeignClient.getAllPlayers();

		while (!(titolariSerieAResponse.isDone())) {
			System.out.println("Waiting for the response...");
			Thread.sleep(1000);
		}

		// Filter the giocatoriSerieA including only the players inside the
		// titolariSerieA
		LineupOfAllTeamsResponse titolariSerieA = titolariSerieAResponse.get();
		Set<String> titolariSerieASet = new HashSet<>();
		titolariSerieA.getTeams().forEach(team -> {
			team.getPlayers().forEach(player -> {
				titolariSerieASet.add(player.getSurname());
			});
		});

		// Calculate the best formation
		int[] formation = Arrays.stream(formationDesired.split("-")).mapToInt(Integer::parseInt).toArray();
		List<Player> bestFormation = new ArrayList<>();

		List<Player> players = giocatoriSerieA.stream()
				.filter(player -> titolariSerieASet.contains(player.getSurname())).collect(Collectors.toList());

		Map<String, List<Player>> playerMap = players.stream().collect(Collectors.groupingBy(Player::getRole));

		playerMap.getOrDefault("P", new ArrayList<>()).stream().max(Comparator.comparing(Player::getFanta_value))
				.ifPresent(bestFormation::add);

		playerMap.getOrDefault("D", new ArrayList<>()).stream()
				.sorted(Comparator.comparing(Player::getFanta_value).reversed()).limit(formation[0])
				.forEach(bestFormation::add);

		playerMap.getOrDefault("C", new ArrayList<>()).stream()
				.sorted(Comparator.comparing(Player::getFanta_value).reversed()).limit(formation[1])
				.forEach(bestFormation::add);

		playerMap.getOrDefault("A", new ArrayList<>()).stream()
				.sorted(Comparator.comparing(Player::getFanta_value).reversed()).limit(formation[2])
				.forEach(bestFormation::add);
		
		System.out.println("Returning the best formation for module: "+formationDesired);

		return bestFormation;
	}

	private static Response<LineupOfAllTeamsResponse> titolariSerieAInvok() {
		LineupsImplService service = new LineupsImplService();
		Lineups port = service.getLineupsImplPort();
		LineupOfAllTeams loat = new LineupOfAllTeams();
		return port.lineupOfAllTeamsAsync(loat);
	}
}
