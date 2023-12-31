package it.disim.univaq.stats.model;


import it.disim.univaq.stats.model.audit.DateAudit;
import jakarta.persistence.*;

@Entity
@Table(name = "statistics")
public class Stats extends DateAudit{
	
	private static final long serialVersionUID = -6223740141442361933L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "statistic_id")
	private Long id;

	@Column(name = "matches_played", nullable = false, length = 45)
	private Integer matches_played;

	@Column(name = "fanta_mean", nullable = false, length = 30)
	private Float fanta_mean;

	@Column(name = "rating_avarage", nullable = false)
	private Float rating_avarage;

	@Column(name = "goals", nullable = false, length = 45)
	private Integer goals;

	@Column(name = "goals_conceded")
	private Integer goals_conceded;

	@Column(name = "penalties_saved")
	private Integer penalties_saved;

	@Column(name = "penalties_taken")
	private Integer penalties_taken;

	@Column(name = "penalties_scored")
	private Integer penalties_scored;

	@Column(name = "penalties_missed")
	private Integer penalties_missed;

	@Column(name = "assists", nullable = false, length = 32)
	private Integer assists;

	@Column(name = "yellow_cards", nullable = false)
	private Integer yellow_cards;

	@Column(name = "red_cards", nullable = false, length = 15)
	private Integer red_cards;

	@Column(name = "autogoals", nullable = false)
	private Integer autogoals;

	@Column(name = "clean_sheet")
	private Integer clean_sheet;

	@Column(name = "playerId", nullable = false)
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

	public Integer getGoals() {
		return goals;
	}

	public void setGoals(Integer goals) {
		this.goals = goals;
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

	public Integer getClean_sheet() {
		return clean_sheet;
	}

	public void setClean_sheet(Integer clean_sheet) {
		this.clean_sheet = clean_sheet;
	}

	public Integer getGoals_conceded() {
		return goals_conceded;
	}

	public void setGoals_conceded(Integer goals_conceded) {
		this.goals_conceded = goals_conceded;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
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

	public Integer getAutogoals() {
		return autogoals;
	}

	public void setAutogoals(Integer autogoals) {
		this.autogoals = autogoals;
	}
}
