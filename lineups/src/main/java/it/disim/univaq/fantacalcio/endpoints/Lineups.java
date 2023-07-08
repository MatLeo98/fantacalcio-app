package it.disim.univaq.fantacalcio.endpoints;


import java.util.concurrent.Future;

import it.disim.univaq.fantacalcio.model.LineupOfAllTeamsResponse;
import it.disim.univaq.fantacalcio.model.LineupOfSingleTeamsResponse;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.ResponseWrapper;


@WebService
public interface Lineups {

    @WebMethod
    @ResponseWrapper(localName = "lineupOfSingleTeamsResponse", targetNamespace = "http://it.univaq.disim.fantacalcio/lineups", className = "it.disim.univaq.fantacalcio.model.LineupOfSingleTeamsResponse")
    public LineupOfSingleTeamsResponse lineupOfSingleTeam(String teamName);

    @WebMethod
    @ResponseWrapper(localName = "lineupOfAllTeamsResponse", targetNamespace = "http://it.univaq.disim.fantacalcio/lineups", className = "it.disim.univaq.fantacalcio.model.LineupOfAllTeamsResponse")
    public LineupOfAllTeamsResponse lineupOfAllTeams();
    
    @WebMethod
    @ResponseWrapper(localName = "lineupOfSingleTeamsResponse", targetNamespace = "http://it.univaq.disim.fantacalcio/lineups", className = "it.disim.univaq.fantacalcio.model.LineupOfSingleTeamsResponse")
    public Future<?> lineupOfSingleTeamAsync(String teamName, AsyncHandler<LineupOfSingleTeamsResponse> asyncHandler);

    @WebMethod
    @ResponseWrapper(localName = "lineupOfAllTeamsResponse", targetNamespace = "http://it.univaq.disim.fantacalcio/lineups", className = "it.disim.univaq.fantacalcio.model.LineupOfAllTeamsResponse")
    public Future<?> lineupOfAllTeamsAsync(AsyncHandler<LineupOfAllTeamsResponse> asyncHandler);
}
