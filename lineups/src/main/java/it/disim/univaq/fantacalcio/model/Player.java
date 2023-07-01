package it.disim.univaq.fantacalcio.model;

import javax.xml.bind.annotation.*;
@XmlType(name = "Player")
@XmlAccessorType(XmlAccessType.FIELD)
public class Player {

    @XmlElement(name = "name")
    protected String name;


    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

}
