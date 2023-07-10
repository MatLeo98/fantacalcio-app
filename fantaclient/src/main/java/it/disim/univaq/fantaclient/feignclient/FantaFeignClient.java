package it.disim.univaq.fantaclient.feignclient;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import feign.Response;
import it.disim.univaq.fantaclient.model.StatsModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;

import it.disim.univaq.fantaclient.model.PlayerModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="api-gateway")
public interface FantaFeignClient {
    @GetMapping("/api/best-formation")
    public List<PlayerModel> getBestFormation(@RequestParam("formationDesired") String formationDesired);

    @GetMapping("/api/formation/rating")
    public List<PlayerModel> getBestFormationByFantaMean(@RequestParam("formationDesired") String formationDesired);

    @GetMapping("/api/formation/matchesPlayed")
    public List<PlayerModel> getBestFormationByMatchesPlayed(@RequestParam("formationDesired") String formationDesired);

    @GetMapping("/api/formation/nation")
    public List<PlayerModel> getBestFormationByNationality(@RequestParam("formationDesired") String formationDesired, @RequestParam("nationality") String nationality);

    @GetMapping("/api/formation/age")
    public List<PlayerModel> getBestFormationByAge(@RequestParam("formationDesired") String formationDesired, @RequestParam("age") String age);

    @GetMapping("/api/stats")
    public List<StatsModel> getStats();

    @GetMapping("/api/stats/playerid/{playerId}")
    public StatsModel getStatsByPlayer(@PathVariable("playerId") Long playerId);

    @GetMapping(value = "/api/campioncini/{playerName}")
    public String getCampioncino(@PathVariable("playerName") String playerName);
}
