package it.disim.univaq.fantaclient.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import it.disim.univaq.fantaclient.model.StatsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.disim.univaq.fantaclient.feignclient.FantaFeignClient;
import it.disim.univaq.fantaclient.model.PlayerModel;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class FantaController {

    @Autowired
    private FantaFeignClient fantafeignclient;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("message", "The first Univaq fantasy football game!");
        return "home";
    }

    @GetMapping("/best-formation")
    public void getBestFormation(@RequestParam("formationDesired") String formationDesired,
                                 @RequestParam(required = false) String nationality,
                                 @RequestParam(required = false) String age,
                                 @RequestParam(required = false) String criteria,
                                 Model model) {
        List<PlayerModel> best = new ArrayList<>();
        if (criteria != null && !criteria.isEmpty()) {
            switch (criteria) {
                case "rating" -> best = fantafeignclient.getBestFormationByFantaMean(formationDesired);
                case "matchesPlayed" -> best = fantafeignclient.getBestFormationByMatchesPlayed(formationDesired);
            }
        } else if (nationality != null && !nationality.isEmpty()) {
            best = fantafeignclient.getBestFormationByNationality(formationDesired, nationality);
        } else if (age != null && !age.isEmpty()) {
            best = fantafeignclient.getBestFormationByAge(formationDesired, age);
        } else {
            best = fantafeignclient.getBestFormation(formationDesired);
        }
        System.out.println("Thread-0: starting multi-threading");
        List<PlayerModel> finalBest = best;
        var statsModelHashMap = new HashMap<Integer, StatsModel>();
        var t1 = new Thread(() -> {
            System.out.println("Thread-1: Starting to retrieve stats");
            finalBest.forEach(player -> {
                var stats = fantafeignclient.getStatsByPlayer(Long.valueOf(player.getId()));
                /*stats.thenAccept(s -> {
                    System.out.println(s);
                    statsModelHashMap.put(player.getId(), s);
                    System.out.println("Thread-1: Stats retrieved for player " + player.getId() + " - " + player.getSurname());
                });*/
                statsModelHashMap.put(player.getId(), stats);
            });
            System.out.println("Thread-1: Stats retrieved for all players");
            model.addAttribute("stats", statsModelHashMap);
        });

        var t2 = new Thread(() -> {
            List<PlayerModel> goalkeeper = new ArrayList<>();
            List<PlayerModel> defenders = new ArrayList<>();
            List<PlayerModel> midfielders = new ArrayList<>();
            List<PlayerModel> strikers = new ArrayList<>();
            var modulo = "";
            var dif = 0;
            var cen = 0;
            var att = 0;
            System.out.println("Thread-2: Starting to divide players by role");
            for (var giocatore : finalBest) {
                switch (giocatore.getRole()) {
                    case "P" -> goalkeeper.add(giocatore);
                    case "D" -> {
                        defenders.add(giocatore);
                        dif += 1;
                    }
                    case "C" -> {
                        midfielders.add(giocatore);
                        cen += 1;
                    }
                    case "A" -> {
                        strikers.add(giocatore);
                        att += 1;
                    }
                }
                modulo = dif + "-" + cen + "-" + att;
            }
            System.out.println("Thread-2: Players divided by role");
            model.addAttribute("modulo", modulo);
            model.addAttribute("response", finalBest);
            model.addAttribute("goalkeeper", goalkeeper);
            model.addAttribute("defenders", defenders);
            model.addAttribute("midfielders", midfielders);
            model.addAttribute("strikers", strikers);
            model.addAttribute("nDif", dif);
            model.addAttribute("nCen", cen);
            model.addAttribute("nAtt", att);
        });

        var images = new HashMap<Integer, String>();
        var t3 = new Thread(() -> {
            System.out.println("Thread-3: Starting to retrieve campioncini");
            finalBest.forEach(player -> {
                var campioncino = fantafeignclient.getCampioncino(player.getSurname());
                /*campioncino.thenAccept(c -> {
                    images.put(player.getId(), c);
                    System.out.println("Thread-3: Campioncino retrieved for player " + player.getId() + " - " + player.getSurname());
                });*/
                images.put(player.getId(), campioncino);
                System.out.println("Thread-3: Campioncino retrieved for player " + player.getId() + " - " + player.getSurname());
            });
            model.addAttribute("images", images);
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/stats")
    public void getStats(@RequestParam("playerId") Long playerId,
                         @RequestParam("surname") String surname,
                         @RequestParam("role") String role,
                         Model model) {
        StatsModel stats = fantafeignclient.getStatsByPlayer(playerId);
        var campioncino = fantafeignclient.getCampioncino(surname);
        model.addAttribute("campioncino", campioncino);
        model.addAttribute("stats", stats);
        model.addAttribute("surname", surname);
        model.addAttribute("role", role);
    }

}
