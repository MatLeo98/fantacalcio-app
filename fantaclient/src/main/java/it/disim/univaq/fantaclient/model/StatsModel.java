package it.disim.univaq.fantaclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatsModel {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("matches_played")
	private Integer matches_played;
	
	@JsonProperty("fanta_mean")
	private Float fanta_mean;
	
	@JsonProperty("rating_avarage")
	private Float rating_avarage;
	
	@JsonProperty("goals")
	private Integer goals;
	
	@JsonProperty("goals_conceded")
	private Integer goals_conceded;

	@JsonProperty("penalties_saved")
	private Integer penalties_saved;
	
	@JsonProperty("penalties_taken")
	private Integer penalties_taken;

	@JsonProperty("penalties_scored")
	private Integer penalties_scored;

	@JsonProperty("penalties_missed")
	private Integer penalties_missed;

	@JsonProperty("assists")
	private Integer assists;

	@JsonProperty("yellow_cards")
	private Integer yellow_cards;

	@JsonProperty("red_cards")
	private Integer red_cards;

	@JsonProperty("autogoals")
	private Integer autogoals;

	@JsonProperty("clean_sheet")
	private Integer clean_sheet;

	@JsonProperty("playerId")
	private Long playerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMatches_played() {
		return matches_played;
	}

	public void setMatches_played(Integer matches_played) {
		this.matches_played = matches_played;
	}

	public Float getFanta_mean() {
		return fanta_mean;
	}

	public void setFanta_mean(Float fanta_mean) {
		this.fanta_mean = fanta_mean;
	}

	public Float getRating_avarage() {
		return rating_avarage;
	}

	public void setRating_avarage(Float rating_avarage) {
		this.rating_avarage = rating_avarage;
	}

	public Integer getGoals() {
		return goals;
	}

	public void setGoals(Integer goals) {
		this.goals = goals;
	}

	public Integer getGoals_conceded() {
		return goals_conceded;
	}

	public void setGoals_conceded(Integer goals_conceded) {
		this.goals_conceded = goals_conceded;
	}

	public Integer getPenalties_saved() {
		return penalties_saved;
	}

	public void setPenalties_saved(Integer penalties_saved) {
		this.penalties_saved = penalties_saved;
	}

	public Integer getPenalties_taken() {
		return penalties_taken;
	}

	public void setPenalties_taken(Integer penalties_taken) {
		this.penalties_taken = penalties_taken;
	}

	public Integer getPenalties_scored() {
		return penalties_scored;
	}

	public void setPenalties_scored(Integer penalties_scored) {
		this.penalties_scored = penalties_scored;
	}

	public Integer getPenalties_missed() {
		return penalties_missed;
	}

	public void setPenalties_missed(Integer penalties_missed) {
		this.penalties_missed = penalties_missed;
	}

	public Integer getAssists() {
		return assists;
	}

	public void setAssists(Integer assists) {
		this.assists = assists;
	}

	public Integer getYellow_cards() {
		return yellow_cards;
	}

	public void setYellow_cards(Integer yellow_cards) {
		this.yellow_cards = yellow_cards;
	}

	public Integer getRed_cards() {
		return red_cards;
	}

	public void setRed_cards(Integer red_cards) {
		this.red_cards = red_cards;
	}

	public Integer getAutogoals() {
		return autogoals;
	}

	public void setAutogoals(Integer autogoals) {
		this.autogoals = autogoals;
	}

	public Integer getClean_sheet() {
		return clean_sheet;
	}

	public void setClean_sheet(Integer clean_sheet) {
		this.clean_sheet = clean_sheet;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
}
