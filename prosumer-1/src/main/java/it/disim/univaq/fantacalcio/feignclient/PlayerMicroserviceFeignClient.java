package it.disim.univaq.fantacalcio.feignclient;

import it.disim.univaq.fantacalcio.model.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "player-microservice")
public interface PlayerMicroserviceFeignClient {
    @GetMapping("/player/surname/{surname}")
    Player getPlayerBySurname(@PathVariable String surname);
}
