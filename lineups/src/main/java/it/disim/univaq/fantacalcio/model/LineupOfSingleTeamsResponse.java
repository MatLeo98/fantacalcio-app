package it.disim.univaq.fantacalcio.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lineupOfSingleTeamsResponse")
public class LineupOfSingleTeamsResponse {
	private Team team;

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
}
