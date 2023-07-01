package it.disim.univaq.fantacalcio.controller;

import it.disim.univaq.fantacalcio.endpoints.Lineups;
import it.disim.univaq.fantacalcio.endpoints.LineupsImplService;
import it.disim.univaq.fantacalcio.endpoints.Team;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.xml.ws.Response;

import java.util.List;


@RestController
@RequestMapping("/best-formation")
public class ProsumerController {
	@Value("${server.port}")
	private String portNumber;

	@GetMapping
	public List<Team> getBestFormation() {
		return lineupAllInvok();
	}

	private static List<Team> lineupAllInvok() {
		LineupsImplService service = new LineupsImplService();
		Lineups port = service.getLineupsImplPort();
		return port.lineupOfAllTeams();
	}
}
