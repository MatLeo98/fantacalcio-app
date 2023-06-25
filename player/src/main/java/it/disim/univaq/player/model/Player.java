package it.disim.univaq.player.model;


import it.disim.univaq.player.model.audit.DateAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class Player extends DateAudit{
	
	private static final long serialVersionUID = -6223740141442361933L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "player_id")
	private Long id;

	@Column(name = "name", nullable = false, length = 45)
	private String name;

	@Column(name = "surname", nullable = false, length = 45)
	private String surname;

	@Column(name = "nationality", nullable = false, length = 32)
	private String nationality;

	@Column(name = "age", nullable = false)
	private Integer age;

	@Column(name = "role", nullable = false, length = 15)
	private String role;

	@Column(name = "team", nullable = false, length = 30)
	private String team;

	@Column(name = "fanta_value", nullable = false)
	private Integer fanta_value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Integer getFanta_value() {
		return fanta_value;
	}

	public void setFanta_value(Integer fanta_value) {
		this.fanta_value = fanta_value;
	}
	
	

}
