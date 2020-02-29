package com.mysite.netconf.xmlModel;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.NONE)
public class ConfigXmlModel {

    ConfigureXmlModel configureXmlModel = new ConfigureXmlModel();

    @XmlElement(name="configure")
    public ConfigureXmlModel getConfigureXmlModel() {
        return configureXmlModel;
    }

    public void setConfigureXmlModel(ConfigureXmlModel configureXmlModel) {
        this.configureXmlModel = configureXmlModel;
    }

    public static class ConfigureXmlModel{

        String xmlns = "urn:alcatel-lucent.com:sros:ns:yang:conf-r13";
        FilterXmlModel filter = new FilterXmlModel();

        @XmlAttribute
        public String getXmlns() {
            return xmlns;
        }

        public void setXmlns(String xmlns) {
            this.xmlns = xmlns;
        }

        public FilterXmlModel getFilter() {
            return filter;
        }

        public void setFilter(FilterXmlModel filter) {
            this.filter = filter;
        }
    }
}
