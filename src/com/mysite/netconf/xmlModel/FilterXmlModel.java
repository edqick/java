package com.mysite.netconf.xmlModel;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="filter")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "ipV4Filter",
        "ipV6Filter",
        "matchList"
})
public class FilterXmlModel {

    @XmlElement(name="ip-filter")
    IpFilterXmlModel ipV4Filter;
    @XmlElement(name="ipv6-filter")
    IpFilterXmlModel ipV6Filter;
    @XmlElement(name="match-list")
    MatchListXmlModel matchList;

    public IpFilterXmlModel getIpV4Filter() {
        return ipV4Filter;
    }

    public void setIpV4Filter(IpFilterXmlModel ipV4Filter) {
        this.ipV4Filter = ipV4Filter;
    }

    public IpFilterXmlModel getIpV6Filter() {
        return ipV6Filter;
    }

    public void setIpV6Filter(IpFilterXmlModel ipV6Filter) {
        this.ipV6Filter = ipV6Filter;
    }

    public MatchListXmlModel getMatchList() {
        return matchList;
    }

    public void setMatchList(MatchListXmlModel matchList) {
        this.matchList = matchList;
    }
}
