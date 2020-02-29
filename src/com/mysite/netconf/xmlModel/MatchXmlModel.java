package com.mysite.netconf.xmlModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class MatchXmlModel {

    @XmlElement(name="protocol")
    String protocol;
    @XmlElement(name="next-header")
    String nextHeader;
    @XmlElement(name="dst-ip")
    DstIp dstIp = new DstIp();
    @XmlElement(name="dst-port")
    DstPort dstPort = new DstPort();

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getNextHeader() {
        return nextHeader;
    }

    public void setNextHeader(String nextHeader) {
        this.nextHeader = nextHeader;
    }

    public DstIp getDstIp() {
        return dstIp;
    }

    public void setDstIp(DstIp dstIp) {
        this.dstIp = dstIp;
    }

    public DstPort getDstPort() {
        return dstPort;
    }

    public void setDstPort(DstPort dstPort) {
        this.dstPort = dstPort;
    }

    public static class DstIp{

        String ipAddressMask;
        String ipv6AddressPrefixLength;

        public String getIpAddressMask() {
            return ipAddressMask;
        }

        @XmlElement(name="ip-address-mask")
        public void setIpAddressMask(String ipAddressMask) {
            this.ipAddressMask = ipAddressMask;
        }

        @XmlElement(name="ipv6-address-prefix-length")
        public String getIpv6AddressPrefixLength() {
            return ipv6AddressPrefixLength;
        }

        public void setIpv6AddressPrefixLength(String ipv6AddressPrefixLength) {
            this.ipv6AddressPrefixLength = ipv6AddressPrefixLength;
        }
    }

    public static class DstPort{

        String portList;

        public String getPortList() {
            return portList;
        }

        @XmlElement(name="port-list")
        public void setPortList(String portList) {
            this.portList = portList;
        }
    }
}
