package it.disim.univaq.fantacalcio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProsumerOneApplication{
	public static void main(String[] args) {
		SpringApplication.run(ProsumerOneApplication.class, args);
	}

}
