package com.mysite.netconf.xmlModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class EntryXmlModel {

    @XmlElement(name="entry-id")
    String entry_id;
    @XmlElement(name="match")
    MatchXmlModel match;
    @XmlAttribute
    String operation;
    @XmlElement(name="action")
    EntryActionXmlModel entryActionXmlModel;

    public String getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(String entry_id) {
        this.entry_id = entry_id;
    }

    public MatchXmlModel getMatch() {
        return match;
    }

    public void setMatch(MatchXmlModel match) {
        this.match = match;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public EntryActionXmlModel getEntryActionXmlModel() {
        return entryActionXmlModel;
    }

    public void setEntryActionXmlModel(EntryActionXmlModel entryActionXmlModel) {
        this.entryActionXmlModel = entryActionXmlModel;
    }
}
