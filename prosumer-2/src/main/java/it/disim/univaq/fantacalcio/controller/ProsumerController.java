package it.disim.univaq.fantacalcio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import it.disim.univaq.fantacalcio.feignclient.CampionciniFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Base64;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/campioncini")
public class ProsumerController {
    @Value("${server.port}")
    private String portNumber;

    @Autowired
    private CampionciniFeignClient campionciniFeignClient;

    @PostMapping
    @Operation(summary = "Get the 'Campioncini' for the desired formation")
    public List<String> getCampioncini(@Parameter(description = "A list of player names in order to retrieve the 'Campioncini'") @RequestBody List<String> players) {
        System.out.println("\t\t [Prosumer-2] - getCampioncini() invoked" + " on port " + portNumber);
        var playerimages = players.stream()
                .map(player -> campionciniFeignClient.getCampioncino(player.toUpperCase()
                        .replace(" ", "-")
                        .replace("'", "")
                        .replace(".", "")))
                .toList();
        return playerimages.stream()
                .map(Base64.getEncoder()::encodeToString)
                .toList();
    }
    
    @GetMapping("/{playerName}")
    @Operation(summary = "Get the 'Campioncino' for the desired player")
    @Async
    public CompletableFuture<String> getCampioncino(@Parameter(description = "The name of the player in order to retrieve the 'Campioncino'") @PathVariable("playerName") String playerName) {
        System.out.println("\t\t [Prosumer-2] - getCampioncino() invoked" + " on port " + portNumber);
        var campioncino = campionciniFeignClient.getCampioncino(playerName.toUpperCase()
                .replace(" ", "-")
                .replace("'", "")
                .replace(".", ""));
        return CompletableFuture.completedFuture(Base64.getEncoder().encodeToString(campioncino));
    }
}
