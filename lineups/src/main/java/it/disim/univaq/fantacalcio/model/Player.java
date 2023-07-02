package it.disim.univaq.fantacalcio.model;

import javax.xml.bind.annotation.*;
@XmlType(name = "Player")
@XmlAccessorType(XmlAccessType.FIELD)
public class Player {

    @XmlElement(name = "surname")
    protected String surname;


    public String getSurname() {
        return surname;
    }

    public void setSurname(String value) {
        this.surname = value;
    }

}
