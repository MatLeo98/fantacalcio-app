package it.disim.univaq.fantaclient.controller;

import java.util.ArrayList;
import java.util.List;

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
		if(criteria != null && !criteria.isEmpty()){
			switch(criteria) {
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
		List<PlayerModel> goalkeeper = new ArrayList<>();
		List<PlayerModel> defenders = new ArrayList<>();
		List<PlayerModel> midfielders = new ArrayList<>();
		List<PlayerModel> strikers = new ArrayList<>();
		  var modulo = "";
		  var dif = 0;
		  var cen = 0;
		  var att = 0;
	      for(var giocatore:best) {
	    	  switch (giocatore.getRole()) {
                  case "P":
                      goalkeeper.add(giocatore);
                      break;
                  case "D":
                      defenders.add(giocatore);
                      dif += 1;
                      break;
                  case "C":
                      midfielders.add(giocatore);
                      cen += 1;
                      break;
                  case "A":
                      strikers.add(giocatore);
                      att += 1;
                      break;
              }

	      }
	      modulo = "" + dif + "-" + cen + "-" + att;	 
	      model.addAttribute("modulo", modulo);
	      model.addAttribute("response", best);
	      model.addAttribute("goalkeeper", goalkeeper);
	      model.addAttribute("defenders", defenders);
	      model.addAttribute("midfielders", midfielders);
	      model.addAttribute("strikers", strikers);
	      model.addAttribute("nDif", dif);
	      model.addAttribute("nCen", cen);
	      model.addAttribute("nAtt", att);
	}

	@GetMapping("/stats")
	public void getStats(@RequestParam("playerId") Long playerId,
	                     @RequestParam("surname") String surname,
	                     @RequestParam("role") String role,
								 Model model) {
		StatsModel stats = fantafeignclient.getStatsByPlayer(playerId);
		model.addAttribute("stats", stats);
		model.addAttribute("surname", surname);
		model.addAttribute("role", role);
	}
	
}
