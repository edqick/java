package com.mysite.netconf.xmlModel;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class ActionXmlModel {

    @XmlElement(name="drop-forward")
    String drop_forward = "forward";

    public String getDrop_forward() {
        return drop_forward;
    }

    public void setDrop_forward(String drop_forward) {
        this.drop_forward = drop_forward;
    }

}
