package it.disim.univaq.fantaclient.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import it.disim.univaq.fantaclient.model.DataModel;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="api-gateway")
public interface FantaFeignClient {
	@GetMapping("/api/best-formation")
	public List<DataModel> getBestFormation(@RequestParam("formationDesired") String formationDesired);

	@GetMapping("/api/formation/rating")
    public List<DataModel> getBestFormationByFantaMean(@RequestParam("formationDesired") String formationDesired);

    @GetMapping("/api/formation/matchesPlayed")
    public List<DataModel> getBestFormationByMatchesPlayed(@RequestParam("formationDesired") String formationDesired);

    @GetMapping("/api/formation/nation")
    public List<DataModel> getBestFormationByNationality(@RequestParam("formationDesired") String formationDesired, @RequestParam("nationality") String nationality);

    @GetMapping("/api/formation/age")
    public List<DataModel> getBestFormationByAge(@RequestParam("formationDesired") String formationDesired, @RequestParam("age") String age);
}
