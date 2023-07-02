package it.disim.univaq.fantacalcio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Player(Long id, String name, String surname, String nationality, Integer age, String role, String team, Integer fanta_value) { }
