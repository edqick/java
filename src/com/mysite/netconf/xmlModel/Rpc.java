package com.mysite.netconf.xmlModel;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="rpc")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rpc {
    @XmlAttribute(name="message-id")
    String message_id = "101";
    @XmlAttribute
    String xmlns = "urn:ietf:params:xml:ns:netconf:base:1.0";
    @XmlElement(name="edit-config")
    EditConfigXmlModel edit_config = new EditConfigXmlModel();

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public EditConfigXmlModel getEdit_config() {
        return edit_config;
    }

    public void setEdit_config(EditConfigXmlModel edit_config) {
        this.edit_config = edit_config;
    }
}
