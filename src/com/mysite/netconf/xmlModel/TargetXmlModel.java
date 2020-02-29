package com.mysite.netconf.xmlModel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="target")
public class TargetXmlModel {


    Running running = new Running();

    public Running getRunning() {
        return running;
    }

    public void setRunning(Running running) {
        this.running = running;
    }

    private static class Running{}
}
