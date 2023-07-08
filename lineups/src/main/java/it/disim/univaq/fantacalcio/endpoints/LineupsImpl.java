package it.disim.univaq.fantacalcio.endpoints;

import it.disim.univaq.fantacalcio.model.LineupOfAllTeamsResponse;
import it.disim.univaq.fantacalcio.model.LineupOfSingleTeamsResponse;
import it.disim.univaq.fantacalcio.model.Player;
import it.disim.univaq.fantacalcio.model.Team;

import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.jaxws.ServerAsyncResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;

@WebService
public class LineupsImpl implements Lineups {
	private static final Map<String, List<String>> lineups = new HashMap<String, List<String>>();
	private void initializeLineups() {
		// Initialization of the lineups from the lineups.txt file in the
		// src/main/resources folder
		File lines = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("lineups.txt")).getFile());
		// For each line of the file, the first element is the team name, the others are
		// the players in order
		try (Stream<String> stream = Files.lines(lines.toPath())) {
			stream.map(l -> l.split(",")).forEach(l -> {
				lineups.put(l[0], Arrays.asList(l).subList(1, l.length));
			});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		lineups.forEach((k, v) -> {
			System.out.println("**** 'LineupEndpoint' INITIALIZED LINEUP FOR TEAM '"+k+"': "+v);
		});
	}

	@Override
	@UseAsyncMethod
	public LineupOfSingleTeamsResponse lineupOfSingleTeam(String teamName) {
		initializeLineups();
		System.out.println("**** 'LineupEndpoint' RECEIVED A REQUEST FOR 'lineupOfSingleTeam'");
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
			System.out.println("**** 'LineupEndpoint' DID NOT FIND ANY LINEUP FOR TEAM '"+teamName+"'");
			throw new RuntimeException("No lineup found for team " + teamName);
		}
		System.out.println(team);
		System.out.println("**** 'LineupEndpoint' IS GOING TO SEND THE RESULT OF THE 'lineupOfSingleTeam' OPERATION");
		LineupOfSingleTeamsResponse lost = new LineupOfSingleTeamsResponse();
		lost.setTeam(team);
		return lost;
	}

	@Override
	@UseAsyncMethod
	public LineupOfAllTeamsResponse lineupOfAllTeams() {
		initializeLineups();
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
		LineupOfAllTeamsResponse loat = new LineupOfAllTeamsResponse();
		loat.setTeams(teams);
		return loat;
	}

	@Override
	public Future<?> lineupOfSingleTeamAsync(String teamName, AsyncHandler<LineupOfSingleTeamsResponse> asyncHandler) {
		System.out.println("**** Executing operation lineupOfSingleTeamAsync asynchronously ****");
		initializeLineups();
		final ServerAsyncResponse<LineupOfSingleTeamsResponse> asyncResponse = new ServerAsyncResponse<>();
		new Thread() {
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
					System.out.println("**** 'LineupEndpoint' DID NOT FIND ANY LINEUP FOR TEAM '"+teamName+"'" );
					throw new RuntimeException("No lineup found for team " + teamName);
				}
				LineupOfSingleTeamsResponse t = new LineupOfSingleTeamsResponse();
				t.setTeam(team);
				asyncResponse.set(t);
				System.out.println("Responding on background thread\n");
				asyncHandler.handleResponse(asyncResponse);
			}
		}.start();

		return asyncResponse;
	}

	@Override
	public Future<?> lineupOfAllTeamsAsync(AsyncHandler<LineupOfAllTeamsResponse> asyncHandler) {
		System.out.println("**** Executing operation lineupOfAllTeamsAsync asynchronously ****");
		initializeLineups();
		final ServerAsyncResponse<LineupOfAllTeamsResponse> asyncResponse = new ServerAsyncResponse<>();
		new Thread() {
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
				LineupOfAllTeamsResponse t = new LineupOfAllTeamsResponse();
				t.setTeams(teams);
				asyncResponse.set(t);
				System.out.println("Responding on background thread\n");
				asyncHandler.handleResponse(asyncResponse);
			}
		}.start();
		
		return asyncResponse;
	}

	
}
