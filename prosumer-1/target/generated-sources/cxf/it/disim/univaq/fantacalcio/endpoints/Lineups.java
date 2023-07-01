package it.disim.univaq.fantacalcio.endpoints;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 4.0.0
 * 2023-07-01T18:46:20.643+02:00
 * Generated source version: 4.0.0
 *
 */
@WebService(targetNamespace = "http://endpoints.fantacalcio.univaq.disim.it/", name = "Lineups")
@XmlSeeAlso({ObjectFactory.class})
public interface Lineups {

    @WebMethod
    @RequestWrapper(localName = "lineupOfSingleTeam", targetNamespace = "http://endpoints.fantacalcio.univaq.disim.it/", className = "it.disim.univaq.fantacalcio.endpoints.LineupOfSingleTeam")
    @ResponseWrapper(localName = "SingleTeamResponse", targetNamespace = "http://endpoints.fantacalcio.univaq.disim.it/", className = "it.disim.univaq.fantacalcio.endpoints.SingleTeamResponse")
    @WebResult(name = "return", targetNamespace = "")
    public it.disim.univaq.fantacalcio.endpoints.Team lineupOfSingleTeam(

        @WebParam(name = "teamName", targetNamespace = "")
        java.lang.String teamName
    );

    @WebMethod
    @RequestWrapper(localName = "lineupOfAllTeams", targetNamespace = "http://endpoints.fantacalcio.univaq.disim.it/", className = "it.disim.univaq.fantacalcio.endpoints.LineupOfAllTeams")
    @ResponseWrapper(localName = "AllTeamsResponse", targetNamespace = "http://endpoints.fantacalcio.univaq.disim.it/", className = "it.disim.univaq.fantacalcio.endpoints.AllTeamsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<it.disim.univaq.fantacalcio.endpoints.Team> lineupOfAllTeams()
;
}