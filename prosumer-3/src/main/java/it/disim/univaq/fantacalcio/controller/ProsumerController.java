package it.disim.univaq.fantacalcio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import it.disim.univaq.fantacalcio.model.Player;
import it.disim.univaq.fantacalcio.model.Stats;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/formation")
public class ProsumerController {
	@Value("${server.port}")
	private String portNumber;
	
	@GetMapping("/rating")
	@Operation(summary = "Get the best formation by rating")
	public List<Player> getFormationByRating(@Parameter(description = "the desired fomration") String formationDesired){
		
		var availableFormations = List.of("3-4-3", "3-5-2", "4-3-3", "4-4-2", "4-5-1", "5-3-2", "5-4-1");
		if (formationDesired == null || !availableFormations.contains(formationDesired)) {
			formationDesired = "4-3-3";
		}
		
		int formation[] = Arrays.stream(formationDesired.split("-")).mapToInt(Integer::parseInt).toArray();
		List<Player> bestFormation = new ArrayList<Player>();
		
		
		List<Player> players = players();
		
		List<Stats> stats = stats();
		
		
        Collections.sort(stats, Comparator.comparing(Stats::rating_avarage).reversed());

        List<Player> sortedPlayers = new ArrayList<>(players);
        Collections.sort(sortedPlayers, Comparator.comparingLong(item -> {
            for (int i = 0; i < stats.size(); i++) {
                if (stats.get(i).playerId().equals(item.id())) {
                    return (long) i;
                }
            }
            return Long.MAX_VALUE;
        }));
		
        Map<String, List<Player>> playerMap = sortedPlayers.stream()
		        .collect(Collectors.groupingBy(Player::role));
        
		playerMap.getOrDefault("P", new ArrayList<>()).stream()
		.findFirst()
		.ifPresent(bestFormation::add);

		playerMap.getOrDefault("D", new ArrayList<>()).stream()
				.limit(formation[0])
				.forEach(bestFormation::add);

		playerMap.getOrDefault("C", new ArrayList<>()).stream()
				.limit(formation[1])
				.forEach(bestFormation::add);

		playerMap.getOrDefault("A", new ArrayList<>()).stream()
				.limit(formation[2])
				.forEach(bestFormation::add);	
		
		return bestFormation;
		
	}
	
	@GetMapping("/matchesPlayed")
	@Operation(summary = "Get the best formation based on match played ")
	public List<Player> getFormationByMatchesPlayed(@Parameter(description = "the desired fomration") String formationDesired){
		
		var availableFormations = List.of("3-4-3", "3-5-2", "4-3-3", "4-4-2", "4-5-1", "5-3-2", "5-4-1");
		if (formationDesired == null || !availableFormations.contains(formationDesired)) {
			formationDesired = "4-3-3";
		}
		
		int formation[] = Arrays.stream(formationDesired.split("-")).mapToInt(Integer::parseInt).toArray();
		List<Player> bestFormation = new ArrayList<Player>();
		
		
		List<Player> players = players();
		
		List<Stats> stats = stats();
		
		
        Collections.sort(stats, Comparator.comparing(Stats::matches_played).reversed());

        List<Player> sortedPlayers = new ArrayList<>(players);
        Collections.sort(sortedPlayers, Comparator.comparingLong(item -> {
            for (int i = 0; i < stats.size(); i++) {
                if (stats.get(i).playerId().equals(item.id())) {
                    return (long) i;
                }
            }
            return Long.MAX_VALUE;
        }));
		
        Map<String, List<Player>> playerMap = sortedPlayers.stream()
		        .collect(Collectors.groupingBy(Player::role));
        
		playerMap.getOrDefault("P", new ArrayList<>()).stream()
		.findFirst()
		.ifPresent(bestFormation::add);

		playerMap.getOrDefault("D", new ArrayList<>()).stream()
				.limit(formation[0])
				.forEach(bestFormation::add);

		playerMap.getOrDefault("C", new ArrayList<>()).stream()
				.limit(formation[1])
				.forEach(bestFormation::add);

		playerMap.getOrDefault("A", new ArrayList<>()).stream()
				.limit(formation[2])
				.forEach(bestFormation::add);	
		
		return bestFormation;
		
	}
	
	@GetMapping("/nation")
	@Operation(summary = "Get the best formation by nationality")
	public List<Player> getFormationByNationality(@Parameter(description = "the desired fomration") String formationDesired, @Parameter(description = "the desired nationality") final String nationality){
		
		var availableFormations = List.of("3-4-3", "3-5-2", "4-3-3", "4-4-2", "4-5-1", "5-3-2", "5-4-1");
		if (formationDesired == null || !availableFormations.contains(formationDesired)) {
			formationDesired = "4-3-3";
		}
		
		int formation[] = Arrays.stream(formationDesired.split("-")).mapToInt(Integer::parseInt).toArray();
		List<Player> bestFormation = new ArrayList<Player>();
		
		
		List<Player> players = players();
		
		List<Stats> stats = stats();
		
		
        Collections.sort(stats, Comparator.comparing(Stats::rating_avarage).reversed());

        List<Player> sortedPlayers = new ArrayList<>(players);
        Collections.sort(sortedPlayers, Comparator.comparingLong(item -> {
            for (int i = 0; i < stats.size(); i++) {
                if (stats.get(i).playerId().equals(item.id())) {
                    return (long) i;
                }
            }
            return Long.MAX_VALUE;
        }));
		
        Map<String, List<Player>> playerMap = sortedPlayers.stream()
		        .filter(player -> player.nationality().toLowerCase().equals(nationality))
		        .collect(Collectors.groupingBy(Player::role));
        
		playerMap.getOrDefault("P", new ArrayList<>()).stream()
		.findFirst()
		.ifPresent(bestFormation::add);

		playerMap.getOrDefault("D", new ArrayList<>()).stream()
				.limit(formation[0])
				.forEach(bestFormation::add);

		playerMap.getOrDefault("C", new ArrayList<>()).stream()
				.limit(formation[1])
				.forEach(bestFormation::add);

		playerMap.getOrDefault("A", new ArrayList<>()).stream()
				.limit(formation[2])
				.forEach(bestFormation::add);	
		
		return bestFormation;
		
	}
	
	
	@GetMapping("/age")
	@Operation(summary = "Get the best formation by ages")
	public List<Player> getFormationByAge(@Parameter(description = "the desired fomration") String formationDesired, @Parameter(description = "the desired age") String age){
		
		var availableFormations = List.of("3-4-3", "3-5-2", "4-3-3", "4-4-2", "4-5-1", "5-3-2", "5-4-1");
		if (formationDesired == null || !availableFormations.contains(formationDesired)) {
			formationDesired = "4-3-3";
		}
		
		var availableFeatures = List.of("minage", "maxage", "u21", "u23");
		if (age == null || !availableFeatures.contains(age)) {
			age = "minage";
		}
		
		int formation[] = Arrays.stream(formationDesired.split("-")).mapToInt(Integer::parseInt).toArray();
		List<Player> bestFormation = new ArrayList<Player>();
		
		
		List<Player> players = players();
		
		List<Stats> stats = stats();
		
		
        Collections.sort(stats, Comparator.comparing(Stats::rating_avarage).reversed());

        List<Player> sortedPlayers = new ArrayList<>(players);
        Collections.sort(sortedPlayers, Comparator.comparingLong(item -> {
            for (int i = 0; i < stats.size(); i++) {
                if (stats.get(i).playerId().equals(item.id())) {
                    return (long) i;
                }
            }
            return Long.MAX_VALUE;
        }));
		
        Map<String, List<Player>> playerMap = new HashMap<>();
        int limitAge;
        
        if (age.equals("u21")||age.equals("u23")) {
        	limitAge = Integer.parseInt(age.substring(1));
        
        	playerMap = sortedPlayers.stream()
        		.filter(player -> player.age() <= limitAge)
		        .collect(Collectors.groupingBy(Player::role));
        	
			playerMap.getOrDefault("P", new ArrayList<>()).stream()
				.findFirst()
				.ifPresent(bestFormation::add);

			playerMap.getOrDefault("D", new ArrayList<>()).stream()
				.limit(formation[0])
				.forEach(bestFormation::add);

			playerMap.getOrDefault("C", new ArrayList<>()).stream()
				.limit(formation[1])
				.forEach(bestFormation::add);

			playerMap.getOrDefault("A", new ArrayList<>()).stream()
				.limit(formation[2])
				.forEach(bestFormation::add);
        	
        }else if(age.equals("minage")) {
			playerMap.getOrDefault("P", new ArrayList<>()).stream()
				.min(Comparator.comparing(Player::age))
				.ifPresent(bestFormation::add);

			playerMap.getOrDefault("D", new ArrayList<>()).stream()
				.sorted(Comparator.comparing(Player::age))
				.limit(formation[0])
				.forEach(bestFormation::add);

			playerMap.getOrDefault("C", new ArrayList<>()).stream()
				.sorted(Comparator.comparing(Player::age))
				.limit(formation[1])
				.forEach(bestFormation::add);

			playerMap.getOrDefault("A", new ArrayList<>()).stream()
				.sorted(Comparator.comparing(Player::age))
				.limit(formation[2])
				.forEach(bestFormation::add);
		}else {
			playerMap.getOrDefault("P", new ArrayList<>()).stream()
				.max(Comparator.comparing(Player::age))
				.ifPresent(bestFormation::add);

			playerMap.getOrDefault("D", new ArrayList<>()).stream()
					.sorted(Comparator.comparing(Player::age).reversed())
					.limit(formation[0])
					.forEach(bestFormation::add);

			playerMap.getOrDefault("C", new ArrayList<>()).stream()
					.sorted(Comparator.comparing(Player::age).reversed())
					.limit(formation[1])
					.forEach(bestFormation::add);

			playerMap.getOrDefault("A", new ArrayList<>()).stream()
					.sorted(Comparator.comparing(Player::age).reversed())
					.limit(formation[2])
					.forEach(bestFormation::add);
		}
		
		return bestFormation;
		
	}
	
	
	//retrive all the stats
	private List<Stats> stats() {
		RestTemplate restTemplate = new RestTemplate();
        Stats[] statsArray = restTemplate.getForObject("http://host.docker.internal:9061/stats", Stats[].class);
        return Arrays.asList(statsArray);
    }	
	
	//retrive all players
	private List<Player> players() {
		RestTemplate restTemplate = new RestTemplate();
        Player[] playersArray = restTemplate.getForObject("http://host.docker.internal:9060/player", Player[].class);
        return Arrays.asList(playersArray);
    }
	
	
    
}
