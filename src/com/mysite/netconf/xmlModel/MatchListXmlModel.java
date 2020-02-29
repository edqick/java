package com.mysite.netconf.xmlModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="match-list")
@XmlAccessorType(XmlAccessType.FIELD)
public class MatchListXmlModel {

    @XmlElement(name="port-list")
    PortListXmlModel portListXmlModel = new PortListXmlModel();

    public PortListXmlModel getPortListXmlModel() {
        return portListXmlModel;
    }

    public void setPortListXmlModel(PortListXmlModel portListXmlModel) {
        this.portListXmlModel = portListXmlModel;
    }
}
