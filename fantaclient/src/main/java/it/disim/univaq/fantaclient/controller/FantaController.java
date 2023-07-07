package it.disim.univaq.fantaclient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.disim.univaq.fantaclient.feignclient.FantaFeignClient;
import it.disim.univaq.fantaclient.model.DataModel;
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
	public void getBestFormation(@RequestParam("formationDesired") String formationDesired, Model model) {
		List<DataModel> best = fantafeignclient.getBestFormation(formationDesired);
		List<DataModel> goalkeeper = new ArrayList<>();
		List<DataModel> defenders = new ArrayList<>();
		List<DataModel> midfielders = new ArrayList<>();
		List<DataModel> strikers = new ArrayList<>();
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
	
}
