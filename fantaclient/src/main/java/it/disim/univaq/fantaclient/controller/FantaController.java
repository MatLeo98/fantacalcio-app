package it.disim.univaq.fantaclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.disim.univaq.fantaclient.feignclient.FantaFeignClient;
import it.disim.univaq.fantaclient.model.DataModel;

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
	public void getBestFormation(Model model) {
		List<DataModel> best = fantafeignclient.getBestFormation();
		  var modulo = "";
		  var dif = 0;
		  var cen = 0;
		  var att = 0;
	      for(var giocatore:best) {
	    	  switch(giocatore.getRole()) {
		    	  case "D" -> dif += 1;
		    	  case "C" -> cen += 1;
		    	  case "A" -> att += 1;
	    	  }
	      }
	      modulo = "" + dif + "-" + cen + "-" + att;	 
	      model.addAttribute("modulo", modulo);
	      model.addAttribute("response", best);
	}
	
}
