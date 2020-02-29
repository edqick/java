package com.mysite.netconf.xmlModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="action")
public class EntryActionXmlModel {


    EntryAction forward = new EntryAction();

    public EntryAction getForward() {
        return forward;
    }

    public void setForward(EntryAction forward) {
        this.forward = forward;
    }

    public static class EntryAction{

        String redirectPolicy;

        public String getRedirectPolicy() {
            return redirectPolicy;
        }

        @XmlElement(name="redirect-policy")
        public void setRedirectPolicy(String redirectPolicy) {
            this.redirectPolicy = redirectPolicy;
        }
    }
}
