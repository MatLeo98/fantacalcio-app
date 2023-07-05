package it.disim.univaq.fantacalcio.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "campioncini-service", url = "https://content.fantacalcio.it/web/campioncini/card/")
public interface CampionciniFeignClient {
    @GetMapping("{playerName}.png")
    public byte[] getCampioncino(@PathVariable("playerName") String playerName);
}
