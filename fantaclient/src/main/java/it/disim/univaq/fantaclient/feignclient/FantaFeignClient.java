package it.disim.univaq.fantaclient.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import it.disim.univaq.fantaclient.model.DataModel;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="prosumer-1-microservice")
public interface FantaFeignClient {
	@GetMapping("/best-formation")
	public List<DataModel> getBestFormation(@RequestParam("formationDesired") String formationDesired);
}
