package it.disim.univaq.fantacalcio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Player{
	Long id; 
	String name; 
	String surname; 
	String nationality; 
	Integer age; 
	String role; 
	String team; 
	Integer fanta_value;
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
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", surname=" + surname + ", nationality=" + nationality
				+ ", age=" + age + ", role=" + role + ", team=" + team + ", fanta_value=" + fanta_value + "]";
	}
	public Player(Long id, String name, String surname, String nationality, Integer age, String role, String team,
			Integer fanta_value) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.nationality = nationality;
		this.age = age;
		this.role = role;
		this.team = team;
		this.fanta_value = fanta_value;
	}
	
}
