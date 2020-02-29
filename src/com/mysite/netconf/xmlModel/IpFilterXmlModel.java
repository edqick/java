package com.mysite.netconf.xmlModel;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.NONE)
public class IpFilterXmlModel {

    @XmlElement(name="filter-id")
    String filter_id = "";
    @XmlElement(name="default-action")
    ActionXmlModel action = new ActionXmlModel();
    @XmlAttribute
    String operation;
    @XmlElement(name="entry")
    EntryXmlModel entryXmlModel;

    public String getFilter_id() {
        return filter_id;
    }

    public void setFilter_id(String filter_id) {
        this.filter_id = filter_id;
    }

    public ActionXmlModel getAction() {
        return action;
    }

    public void setAction(ActionXmlModel action) {
        this.action = action;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public EntryXmlModel getEntryXmlModel() {
        return entryXmlModel;
    }

    public void setEntryXmlModel(EntryXmlModel entryXmlModel) {
        this.entryXmlModel = entryXmlModel;
    }
}
