package it.disim.univaq.fantacalcio.model;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "Team")
@XmlAccessorType(XmlAccessType.FIELD)
public class Team {
    @XmlElement(name = "teamName")
    protected String teamName;
    @XmlElement(name = "players")
    protected List<Player> players;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String value) {
        this.teamName = value;
    }

    public List<Player> getPlayers() {
        if (players == null) {
            players = new ArrayList<Player>();
        }
        return this.players;
    }

}
