package it.disim.univaq.fantacalcio.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import it.disim.univaq.fantacalcio.model.Stats;

@FeignClient(name = "stats-microservice")
public interface StatsMicroserviceFeignClient {
    @GetMapping("/stats")
    List<Stats> getStats();
}