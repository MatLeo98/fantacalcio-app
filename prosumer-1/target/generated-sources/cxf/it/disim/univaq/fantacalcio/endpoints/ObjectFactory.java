
package it.disim.univaq.fantacalcio.endpoints;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.disim.univaq.fantacalcio.endpoints package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AllTeamsResponse_QNAME = new QName("http://endpoints.fantacalcio.univaq.disim.it/", "AllTeamsResponse");
    private final static QName _SingleTeamResponse_QNAME = new QName("http://endpoints.fantacalcio.univaq.disim.it/", "SingleTeamResponse");
    private final static QName _LineupOfAllTeams_QNAME = new QName("http://endpoints.fantacalcio.univaq.disim.it/", "lineupOfAllTeams");
    private final static QName _LineupOfSingleTeam_QNAME = new QName("http://endpoints.fantacalcio.univaq.disim.it/", "lineupOfSingleTeam");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.disim.univaq.fantacalcio.endpoints
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Team }
     * 
     */
    public Team createTeam() {
        return new Team();
    }

    /**
     * Create an instance of {@link AllTeamsResponse }
     * 
     */
    public AllTeamsResponse createAllTeamsResponse() {
        return new AllTeamsResponse();
    }

    /**
     * Create an instance of {@link SingleTeamResponse }
     * 
     */
    public SingleTeamResponse createSingleTeamResponse() {
        return new SingleTeamResponse();
    }

    /**
     * Create an instance of {@link LineupOfAllTeams }
     * 
     */
    public LineupOfAllTeams createLineupOfAllTeams() {
        return new LineupOfAllTeams();
    }

    /**
     * Create an instance of {@link LineupOfSingleTeam }
     * 
     */
    public LineupOfSingleTeam createLineupOfSingleTeam() {
        return new LineupOfSingleTeam();
    }

    /**
     * Create an instance of {@link Player }
     * 
     */
    public Player createPlayer() {
        return new Player();
    }

    /**
     * Create an instance of {@link Team.Players }
     * 
     */
    public Team.Players createTeamPlayers() {
        return new Team.Players();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllTeamsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AllTeamsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoints.fantacalcio.univaq.disim.it/", name = "AllTeamsResponse")
    public JAXBElement<AllTeamsResponse> createAllTeamsResponse(AllTeamsResponse value) {
        return new JAXBElement<AllTeamsResponse>(_AllTeamsResponse_QNAME, AllTeamsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SingleTeamResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SingleTeamResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoints.fantacalcio.univaq.disim.it/", name = "SingleTeamResponse")
    public JAXBElement<SingleTeamResponse> createSingleTeamResponse(SingleTeamResponse value) {
        return new JAXBElement<SingleTeamResponse>(_SingleTeamResponse_QNAME, SingleTeamResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LineupOfAllTeams }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LineupOfAllTeams }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoints.fantacalcio.univaq.disim.it/", name = "lineupOfAllTeams")
    public JAXBElement<LineupOfAllTeams> createLineupOfAllTeams(LineupOfAllTeams value) {
        return new JAXBElement<LineupOfAllTeams>(_LineupOfAllTeams_QNAME, LineupOfAllTeams.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LineupOfSingleTeam }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LineupOfSingleTeam }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoints.fantacalcio.univaq.disim.it/", name = "lineupOfSingleTeam")
    public JAXBElement<LineupOfSingleTeam> createLineupOfSingleTeam(LineupOfSingleTeam value) {
        return new JAXBElement<LineupOfSingleTeam>(_LineupOfSingleTeam_QNAME, LineupOfSingleTeam.class, null, value);
    }

}
