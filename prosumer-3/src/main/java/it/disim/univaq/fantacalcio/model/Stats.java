package it.disim.univaq.fantacalcio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Stats(Long id,

		Integer matches_played,

		Float fanta_mean,

		Float rating_avarage,

		Integer goals,

		Integer goals_conceded,

		Integer penalties_saved,

		Integer penalties_taken,

		Integer penalties_scored,

		Integer penalties_missed,

		Integer assists,

		Integer yellow_cards,

		Integer red_cards,

		Integer autogoals,

		Integer clean_sheet,

		Long playerId) {
}
