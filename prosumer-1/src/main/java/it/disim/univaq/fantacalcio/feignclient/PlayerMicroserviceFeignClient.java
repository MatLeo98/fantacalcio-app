package it.disim.univaq.fantacalcio.feignclient;

import it.disim.univaq.fantacalcio.model.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "api-gateway")
public interface PlayerMicroserviceFeignClient {
    @GetMapping("/api/player/surname/{surname}")
    Player getPlayerBySurname(@PathVariable String surname);

    @GetMapping("/api/player")
    List<Player> getAllPlayers();
}
