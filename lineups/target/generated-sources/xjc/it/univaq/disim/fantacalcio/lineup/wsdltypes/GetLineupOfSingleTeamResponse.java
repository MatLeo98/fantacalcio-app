//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2023.06.28 alle 04:27:01 PM CEST 
//


package it.univaq.disim.fantacalcio.lineup.wsdltypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Teams" type="{http://disim.univaq.it/fantacalcio/lineup/wsdltypes}Team"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "teams"
})
@XmlRootElement(name = "GetLineupOfSingleTeamResponse")
public class GetLineupOfSingleTeamResponse {

    @XmlElement(name = "Teams", required = true)
    protected Team teams;

    /**
     * Recupera il valore della proprietà teams.
     * 
     * @return
     *     possible object is
     *     {@link Team }
     *     
     */
    public Team getTeams() {
        return teams;
    }

    /**
     * Imposta il valore della proprietà teams.
     * 
     * @param value
     *     allowed object is
     *     {@link Team }
     *     
     */
    public void setTeams(Team value) {
        this.teams = value;
    }

}
