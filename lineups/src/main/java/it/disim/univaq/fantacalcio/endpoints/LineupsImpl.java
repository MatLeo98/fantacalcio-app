package it.disim.univaq.fantacalcio.endpoints;


import it.disim.univaq.fantacalcio.model.Player;
import it.disim.univaq.fantacalcio.model.Team;
import org.apache.cxf.annotations.UseAsyncMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Stream;

public class LineupsImpl implements Lineups {
    private static final Map<String, List<String>> lineups = new HashMap<String, List<String>>();

    private static final Logger LOGGER = LoggerFactory.getLogger(LineupsImpl.class);

    private void initializeLineups() {
        // Initialization of the lineups from the lineups.txt file in the src/main/resources folder
        File lines = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("lineups.txt")).getFile());
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

    @Override
    @UseAsyncMethod
    public Team lineupOfSingleTeam(String teamName) {
        initializeLineups();
        LOGGER.info("**** 'LineupEndpoint' RECEIVED A REQUEST FOR 'GetLineupOfSingleTeam'");
        Team team = new Team();
        team.setTeamName(teamName.toUpperCase());
        List<String> players = lineups.get(teamName.toUpperCase());
        if (players != null) {
            players.forEach(p -> {
                Player player = new Player();
                player.setSurname(p);
                team.getPlayers().add(player);
            });
        } else {
            LOGGER.info("**** 'LineupEndpoint' DID NOT FIND ANY LINEUP FOR TEAM '{}'", teamName);
            throw new RuntimeException("No lineup found for team " + teamName);
        }
        System.out.println(team);
        LOGGER.info("**** 'LineupEndpoint' IS GOING TO SEND THE RESULT OF THE 'GetLineupOfSingleTeam' OPERATION");
        return team;
    }

    @Override
    @UseAsyncMethod
    public List<Team> lineupOfAllTeams() {
        initializeLineups();
        LOGGER.info("**** 'LineupEndpoint' RECEIVED A REQUEST FOR 'GetLineupOfAllTeams'");
        List<Team> teams = new ArrayList<>();
        lineups.forEach((teamName, playerNames) -> {
            Team team = new Team();
            team.setTeamName(teamName);
            playerNames.forEach(p -> {
                Player player = new Player();
                player.setSurname(p);
                team.getPlayers().add(player);
            });
            teams.add(team);
        });
        LOGGER.info("**** 'LineupEndpoint' IS GOING TO SEND THE RESULT OF THE 'GetLineupOfAllTeams' OPERATION");
        return teams;
    }
}
