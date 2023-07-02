package it.disim.univaq.fantacalcio.controller;

import io.swagger.annotations.ApiOperation;
import it.disim.univaq.fantacalcio.endpoints.Lineups;
import it.disim.univaq.fantacalcio.endpoints.LineupsImplService;
import it.disim.univaq.fantacalcio.endpoints.Team;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/best-formation")
public class ProsumerController {
	@Value("${server.port}")
	private String portNumber;

	@GetMapping
	@ApiOperation(value = "Get the best formation of all teams",
			notes = "This operation returns the best formation of all teams")
	public List<Team> getBestFormation() {
		System.out.println("\t\t [ProsumerController] - getBestFormation() invoked" + " on port " + portNumber);


		return lineupAllInvoke();
	}

	private static List<Team> lineupAllInvoke() {
		LineupsImplService service = new LineupsImplService();
		Lineups port = service.getLineupsImplPort();
		return port.lineupOfAllTeams();
	}
}
