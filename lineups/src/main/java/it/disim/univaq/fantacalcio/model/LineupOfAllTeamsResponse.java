package it.disim.univaq.fantacalcio.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlType(name = "lineupOfAllTeamsResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class LineupOfAllTeamsResponse {
    protected List<Team> teams;

    public List<Team> getTeams() {
        if (teams == null) {
            teams = new ArrayList<Team>();
        }
        return this.teams;
    }
    
    public void setTeams(List<Team> teams) {
    	this.teams = teams;
    }
}
