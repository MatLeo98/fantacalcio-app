//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2023.06.28 alle 04:27:01 PM CEST 
//


package it.univaq.disim.fantacalcio.lineup.wsdltypes;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.univaq.disim.fantacalcio.lineup.wsdltypes package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.univaq.disim.fantacalcio.lineup.wsdltypes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLineupOfAllTeamsResponse }
     * 
     */
    public GetLineupOfAllTeamsResponse createGetLineupOfAllTeamsResponse() {
        return new GetLineupOfAllTeamsResponse();
    }

    /**
     * Create an instance of {@link Team }
     * 
     */
    public Team createTeam() {
        return new Team();
    }

    /**
     * Create an instance of {@link GetLineupOfAllTeamsRequest }
     * 
     */
    public GetLineupOfAllTeamsRequest createGetLineupOfAllTeamsRequest() {
        return new GetLineupOfAllTeamsRequest();
    }

    /**
     * Create an instance of {@link GetLineupOfSingleTeamResponse }
     * 
     */
    public GetLineupOfSingleTeamResponse createGetLineupOfSingleTeamResponse() {
        return new GetLineupOfSingleTeamResponse();
    }

    /**
     * Create an instance of {@link GetLineupOfSingleTeamRequest }
     * 
     */
    public GetLineupOfSingleTeamRequest createGetLineupOfSingleTeamRequest() {
        return new GetLineupOfSingleTeamRequest();
    }

    /**
     * Create an instance of {@link Player }
     * 
     */
    public Player createPlayer() {
        return new Player();
    }

}
