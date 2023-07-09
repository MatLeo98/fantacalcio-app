package it.disim.univaq.fantacalcio.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import it.disim.univaq.fantacalcio.model.Player;
import it.disim.univaq.fantacalcio.model.Stats;

@FeignClient(name = "api-gateway")
public interface MicroservicesFeignClient {
	@GetMapping("/api/player")
    List<Player> getPlayers();
	
	@GetMapping("/api/stats")
    List<Stats> getStats();
}
