package it.disim.univaq.fantacalcio.endpoints;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import it.univaq.disim.fantacalcio.lineup.wsdltypes.*;

@Endpoint
public class LineupsEndpoint {
	private static Map<String, List<String>> lineups = new HashMap<String, List<String>>();
    
    private static final Logger LOGGER = LoggerFactory.getLogger(LineupsEndpoint.class);

    @EventListener(ApplicationReadyEvent.class)
    public void initializeLineups() {
        // Initialization of the lineups from the lineups.txt file in the src/main/resources folder
        File lines = new File("src/main/resources/lineups.txt");
        // For each line of the file, the first element is the team name, the others are the players in order
        try (Stream<String> stream = Files.lines(lines.toPath())){
            stream.map(l -> l.split(",")).forEach(l -> {
                lineups.put(l[0], Arrays.asList(l).subList(1, l.length));
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lineups.forEach((k, v) -> {
            LOGGER.info("**** 'LineupEndpoint' INITIALIZED LINEUP FOR TEAM '{}': {}", k, v);
        });
    }
    
    @PayloadRoot(namespace = "http://disim.univaq.it/fantacalcio/lineup/wsdltypes", localPart = "GetLineupOfAllTeamsRequest")
    @ResponsePayload
    public GetLineupOfAllTeamsResponse getLineupOfAllTeams(@RequestPayload GetLineupOfAllTeamsRequest request) {
        LOGGER.info("**** 'LineupEndpoint' RECEIVED A REQUEST FOR 'GetLineupOfAllTeams'");

        ObjectFactory factory = new ObjectFactory();
        GetLineupOfAllTeamsResponse response = factory.createGetLineupOfAllTeamsResponse();
        List<Team> teams = response.getTeams();
        // For each team, a new Team object is created and added to the response
        lineups.forEach((k, v) -> {
            Team team = new Team();
            team.setName(k);
            List<Player> players = team.getPlayer();
            v.forEach(p -> {
                Player player = new Player();
                player.setName(p);
                players.add(player);
            });
            teams.add(team);
        });
        // The teams are sorted by name
        teams.sort(Comparator.comparing(Team::getName));

        LOGGER.info("**** 'LineupEndpoint' IS GOING TO SEND THE RESULT OF THE 'GetLineupOfAllTeams' OPERATION");

        return response;
    }
    
    @PayloadRoot(namespace = "http://disim.univaq.it/fantacalcio/lineup/wsdltypes", localPart = "GetLineupOfSingleTeamRequest")
    @ResponsePayload
    public GetLineupOfSingleTeamResponse getLineupOfSingleTeam(@RequestPayload GetLineupOfSingleTeamRequest request) {

        LOGGER.info("**** 'LineupEndpoint' RECEIVED A REQUEST FOR 'GetLineupOfSingleTeam'");

        ObjectFactory factory = new ObjectFactory();
        GetLineupOfSingleTeamResponse response = factory.createGetLineupOfSingleTeamResponse();
        Team team = new Team();
        team.setName(request.getTeamName().toUpperCase());
        List<Player> players = team.getPlayer();
        // If the team is not found, an exception is thrown
        if (!lineups.containsKey(request.getTeamName().toUpperCase())) {
            LOGGER.info("**** 'LineupEndpoint' DID NOT FIND ANY LINEUP FOR TEAM '{}'", request.getTeamName());
            throw new RuntimeException("No lineup found for team " + request.getTeamName());
        }
        // For each player in the lineup, a new Player object is created and added to the response
        lineups.get(request.getTeamName().toUpperCase()).forEach(p -> {
            Player player = new Player();
            player.setName(p);
            players.add(player);
        });
        response.setTeams(team);
        LOGGER.info("**** 'LineupEndpoint' NOW IS GOING TO SEND THE RESULT OF THE 'GetLineupOfSingleTeam' OPERATION");
        return response;
    }
}
