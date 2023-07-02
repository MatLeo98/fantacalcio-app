package it.disim.univaq.fantacalcio.feignclient;

import it.disim.univaq.fantacalcio.model.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "player-microservice")
public interface PlayerMicroserviceFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "/player/surname/{surname}")
    Player getPlayerBySurname(@PathVariable String surname);
}
