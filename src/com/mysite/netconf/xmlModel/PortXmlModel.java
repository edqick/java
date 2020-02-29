package com.mysite.netconf.xmlModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="port")
public class PortXmlModel {

    String portNumber;

    public String getPortNumber() {
        return portNumber;
    }

    @XmlElement(name="port-number")
    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }
}
