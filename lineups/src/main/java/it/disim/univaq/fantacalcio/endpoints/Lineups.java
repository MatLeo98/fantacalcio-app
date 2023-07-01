package it.disim.univaq.fantacalcio.endpoints;

import it.disim.univaq.fantacalcio.model.Team;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.ResponseWrapper;
import java.util.List;

@WebService
public interface Lineups {

    @WebMethod
    @ResponseWrapper(localName = "SingleTeamResponse")
    public Team lineupOfSingleTeam(@WebParam(name = "teamName") String teamName);

    @WebMethod
    @ResponseWrapper(localName = "AllTeamsResponse")
    public List<Team> lineupOfAllTeams();

}
