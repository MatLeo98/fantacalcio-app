package it.disim.univaq.fantacalcio.feignclient;

import it.disim.univaq.fantacalcio.model.Player;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "player-microservice")
public interface PlayerMicroserviceFeignClient {
    @GetMapping("/player")
    List<Player> getPlayers();
}
