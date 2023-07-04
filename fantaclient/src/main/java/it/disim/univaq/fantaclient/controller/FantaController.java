package it.disim.univaq.fantaclient.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import it.disim.univaq.fantaclient.model.DataModel;

@Controller
public class FantaController {

    
	@GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "The first Univaq fantasy football game!");
        return "home";
    }

    @GetMapping("/best-formation")
    public void sendGetRequest(Model model) {
    	
    	RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9070/best-formation";
        ResponseEntity<DataModel[]> best = restTemplate.getForEntity(url, DataModel[].class);
        
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> roles = new ArrayList<>();
        
        for (DataModel player : best.getBody()) {
        	names.add(player.getSurname());
        	roles.add(player.getRole());
        }
        
        ArrayList<String> response = new ArrayList<>();
        for (int i = 0; i < roles.size(); i++) {
            response.add(roles.get(i) + " - " + names.get(i));
        }
        
        model.addAttribute("response", response);
    }
	
}
