package com.mysite.netconf.xmlModel;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "target",
        "config"
})
public class EditConfigXmlModel {

    @XmlElement
    TargetXmlModel target = new TargetXmlModel();
    @XmlElement(name="config")
    ConfigXmlModel config = new ConfigXmlModel();

    public TargetXmlModel getTarget() {
        return target;
    }

    public void setTarget(TargetXmlModel target) {
        this.target = target;
    }

    public ConfigXmlModel getConfig() {
        return config;
    }

    public void setConfig(ConfigXmlModel config) {
        this.config = config;
    }
}