package com.mysite.netconf.xmlModel;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name="port-list")
@XmlAccessorType(XmlAccessType.FIELD)
public class PortListXmlModel {

    @XmlElement(name="port-list-name")
    String portListName;
    @XmlElement(name="port")
    ArrayList<PortXmlModel> ports;
    @XmlAttribute
    String operation;

    public String getPortListName() {
        return portListName;
    }

    public void setPortListName(String portListName) {
        this.portListName = portListName;
    }

    public ArrayList<PortXmlModel> getPorts() {
        return ports;
    }

    public void setPorts(ArrayList<PortXmlModel> ports) {
        this.ports = ports;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
