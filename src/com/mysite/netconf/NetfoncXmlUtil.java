package com.mysite.netconf;

import com.mysite.netconf.xmlModel.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

public class NetfoncXmlUtil {
  
	@SuppressWarnings("unchecked")
	public static <T> T fromXml(String xml, Class<T> valueType) {
		try {
			JAXBContext context = JAXBContext.newInstance(new Class[] { valueType });
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return (T)unmarshaller.unmarshal(new StringReader(xml));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public static String toXmlModel(Object input) {
		if (input == null) {
			return null;
		}
		Class<?> cl = input.getClass();
		StringWriter writer = new StringWriter();
		try {
			JAXBContext jc = JAXBContext.newInstance(new Class[] { cl });
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty("jaxb.encoding", "utf-8");
			marshaller.setProperty("jaxb.formatted.output", true);
			marshaller.setProperty("jaxb.fragment", true);
			StringWriter xmlWriter = new StringWriter();
			writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			marshaller.marshal(input, writer);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}

	public static void main(String[] args) {
		//1. add ipv4-filter with filter id="104"
		Rpc rpcIpFilterForCreate =  new Rpc();
		rpcIpFilterForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().setIpV4Filter(new IpFilterXmlModel());
		rpcIpFilterForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().setFilter_id("104");
		rpcIpFilterForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().setAction(new ActionXmlModel());
		System.out.println(NetfoncXmlUtil.toXmlModel(rpcIpFilterForCreate)+"\n]]>]]>");

		//2. delete ipv4-filter with filter id="104"
		Rpc rpcIpFilterForDelete =  new Rpc();
		rpcIpFilterForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().setIpV4Filter(new IpFilterXmlModel());
		rpcIpFilterForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().setFilter_id("104");
		rpcIpFilterForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().setOperation("delete");
		System.out.println(NetfoncXmlUtil.toXmlModel(rpcIpFilterForDelete)+"\n]]>]]>");

		//3. add ipv6-filter with filter id="104"
		Rpc rpcIpv6FilterForCreate =  new Rpc();
		rpcIpv6FilterForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().setIpV6Filter(new IpFilterXmlModel());
		rpcIpv6FilterForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().setFilter_id("104");
		rpcIpv6FilterForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().setAction(new ActionXmlModel());
		System.out.println(NetfoncXmlUtil.toXmlModel(rpcIpv6FilterForCreate)+"\n]]>]]>");

		//4. delete ipv6-filter with filter id="104" return error if no mapping ipv6-filter exists
		Rpc rpcIpv6FilterForDelete =  new Rpc();
		rpcIpv6FilterForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().setIpV6Filter(new IpFilterXmlModel());
		rpcIpv6FilterForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().setFilter_id("104");
		rpcIpv6FilterForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().setOperation("delete");
		System.out.println(NetfoncXmlUtil.toXmlModel(rpcIpv6FilterForDelete)+"\n]]>]]>");

		//5. add ipv4-entry with entry id="13" to filter id="104"
		Rpc rpcIpv4EntryForCreate =  new Rpc();
		rpcIpv4EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().setIpV4Filter(new IpFilterXmlModel());
		rpcIpv4EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().setFilter_id("104");
		rpcIpv4EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().setEntryXmlModel(new EntryXmlModel());
		rpcIpv4EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().getEntryXmlModel().setEntry_id("13");
		rpcIpv4EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().getEntryXmlModel().setMatch(new MatchXmlModel());
		rpcIpv4EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().getEntryXmlModel().getMatch().setProtocol("tcp");
		rpcIpv4EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().getEntryXmlModel().getMatch().getDstIp().setIpAddressMask("112.35.0.41/32");
		rpcIpv4EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().getEntryXmlModel().getMatch().getDstPort().setPortList("4a933bcb9e3603c1436df80a8732e390");
		rpcIpv4EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().getEntryXmlModel().setEntryActionXmlModel(new EntryActionXmlModel());
		//5.1 add ipv4-entry with "waf" redirect policy
//		rpcIpv4EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().getEntryXmlModel().getEntryActionXmlModel().getForward().setRedirectPolicy("waf");
		System.out.println(NetfoncXmlUtil.toXmlModel(rpcIpv4EntryForCreate)+"\n]]>]]>");

		//6. delete ipv4-entry with entry id="12" to filter id="104",return error if no mapping ipv6-filter exists
		Rpc rpcIpv4EntryForDelete =  new Rpc();
		rpcIpv4EntryForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().setIpV4Filter(new IpFilterXmlModel());
		rpcIpv4EntryForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().setFilter_id("104");
		rpcIpv4EntryForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().setEntryXmlModel(new EntryXmlModel());
		rpcIpv4EntryForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().getEntryXmlModel().setEntry_id("12");
		rpcIpv4EntryForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV4Filter().getEntryXmlModel().setOperation("delete");
		System.out.println(NetfoncXmlUtil.toXmlModel(rpcIpv4EntryForDelete)+"\n]]>]]>");

		//7. add ipv6-entry with entry id="12" to filter id="104"
		Rpc rpcIpv6EntryForCreate =  new Rpc();
		rpcIpv6EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().setIpV6Filter(new IpFilterXmlModel());
		rpcIpv6EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().setFilter_id("104");
		rpcIpv6EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().setEntryXmlModel(new EntryXmlModel());
		rpcIpv6EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().getEntryXmlModel().setEntry_id("12");
		rpcIpv6EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().getEntryXmlModel().setMatch(new MatchXmlModel());
		rpcIpv6EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().getEntryXmlModel().getMatch().setNextHeader("tcp");
		rpcIpv6EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().getEntryXmlModel().getMatch().getDstIp().setIpv6AddressPrefixLength("::112.35.0.40/128");
		rpcIpv6EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().getEntryXmlModel().getMatch().getDstPort().setPortList("tcp-80-443");
		rpcIpv6EntryForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().getEntryXmlModel().setEntryActionXmlModel(new EntryActionXmlModel());
		System.out.println(NetfoncXmlUtil.toXmlModel(rpcIpv6EntryForCreate)+"\n]]>]]>");

		//8. delete ipv6-entry with entry id="12" from filter id="104"
		Rpc rpcIpv6EntryForDelete =  new Rpc();
		rpcIpv6EntryForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().setIpV6Filter(new IpFilterXmlModel());
		rpcIpv6EntryForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().setFilter_id("104");
		rpcIpv6EntryForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().setEntryXmlModel(new EntryXmlModel());
		rpcIpv6EntryForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().getEntryXmlModel().setEntry_id("12");
		rpcIpv6EntryForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getIpV6Filter().getEntryXmlModel().setOperation("delete");
		System.out.println(NetfoncXmlUtil.toXmlModel(rpcIpv6EntryForDelete)+"\n]]>]]>");

		//9. create port-list with name="4a933bcb9e3603c1436df80a87321122" and add port 28080、28081
		Rpc rpcPortListForCreate =  new Rpc();
		rpcPortListForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().setMatchList(new MatchListXmlModel());
		rpcPortListForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getMatchList().getPortListXmlModel().setPortListName("4a933bcb9e3603c1436df80a87321122");
		ArrayList<PortXmlModel> portArrayList = new ArrayList<>();
		rpcPortListForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getMatchList().getPortListXmlModel().setPorts(portArrayList);
		PortXmlModel portXmlModel1 = new PortXmlModel();
		portXmlModel1.setPortNumber("28080");
		rpcPortListForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getMatchList().getPortListXmlModel().getPorts().add(portXmlModel1);
		PortXmlModel portXmlModel2 = new PortXmlModel();
		portXmlModel2.setPortNumber("28081");
		rpcPortListForCreate.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getMatchList().getPortListXmlModel().getPorts().add(portXmlModel2);
		System.out.println(NetfoncXmlUtil.toXmlModel(rpcPortListForCreate)+"\n]]>]]>");

		//10. delete port-list with name="4a933bcb9e3603c1436df80a87321122"
		Rpc rpcPortListForDelete =  new Rpc();
		rpcPortListForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().setMatchList(new MatchListXmlModel());
		rpcPortListForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getMatchList().getPortListXmlModel().setPortListName("4a933bcb9e3603c1436df80a87321122");
		rpcPortListForDelete.getEdit_config().getConfig().getConfigureXmlModel().getFilter().getMatchList().getPortListXmlModel().setOperation("delete");
		System.out.println(NetfoncXmlUtil.toXmlModel(rpcPortListForDelete)+"\n]]>]]>");

		
	}
}
