package work;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.DigestUtils;

public class demo {

	/**
	 * agrs:IPV6 addresses String with :: format
	 * return:IPV6 addresses String in the correct format
	 * */
	public static String ipV6AdderssFix(String IPV6){
		StringBuffer sb = new StringBuffer();
		if(IPV6.contains("::")){
			if(IPV6.equals("::")){
				return "0000:0000:0000:0000:0000:0000:0000:0000";
			}
			String[] ipV6s = IPV6.split("::");
			if(ipV6s[0].isEmpty() && ipV6s.length ==2){
				if(isIPV4Format(IPV6.split("::")[1])){
					String ipV4 = IPV4ToIPV6(IPV6.split("::")[1]);
					return ipV6AdderssFix("::".concat(ipV4));
				}
				for(int i=0;i<8-ipV6s[1].split(":").length;i++){
					sb = sb.append("0000:");
				}
				sb.append(IPV6.split("::")[1].toLowerCase());
			}else if(ipV6s.length==1){
				sb = sb.append(ipV6s[0].toLowerCase());
				for(int i=0;i<8-ipV6s[0].split(":").length;i++){
					sb.append(":0000");
				}
			}else if(!ipV6s[0].isEmpty() && ipV6s.length==2){
				sb = sb.append(ipV6s[0].toLowerCase());
				for(int i=0;i<8-IPV6.replace("::",":").split(":").length;i++){
					sb = sb.append(":0000");
				}
				sb = sb.append(":").append(ipV6s[1].toLowerCase());
			}else{
				return null;
			}
		}else{
			sb.append(IPV6);
		}
		return completionIPV6(sb.toString());
	}

	/**
	 * args:IPV6 addresses String in the correct format
	 * return:IPV6 addresses String in full format and length
	 * */
	public static String completionIPV6(String ipV6){
		StringBuffer sb = new StringBuffer();
		String[] ipV6s = ipV6.split(":");
		for(int i=0;i<ipV6s.length;i++){
			if(ipV6s[i].length()==1){
				sb.append("000".concat(ipV6s[i]).concat(":"));
			}else if(ipV6s[i].length()==2){
				sb.append("00".concat(ipV6s[i]).concat(":"));
			}else if(ipV6s[i].length()==3){
				sb.append("0".concat(ipV6s[i]).concat(":"));
			}else{
				sb.append(ipV6s[i].concat(":"));
			}
		}
		return sb.substring(0,sb.length()-1).toLowerCase();
	}

	/**
	 * args:ipV6 addresses String
	 * return:ture if ipV6 addresses String is correct or false if ipV6 addresses String is wrong
	 * */
	public static boolean isIPV6Format(String IPV6){
		String regex = "^[A-Fa-f0-9]+$";
		String[] ipV6s = null;
		if(IPV6.contains("::")){
			if(IPV6.indexOf("::")==0){
				if(IPV6.equals("::")){
					return true;
				}
				if(isIPV4Format(IPV6.split("::")[1])){
					return true;
				}
				ipV6s = IPV6.split("::")[1].split(":");
			}else if(IPV6.indexOf("::")==IPV6.length()-1){
				ipV6s = IPV6.split("::")[0].split(":");
			}else{
				ipV6s = IPV6.replace("::",":").split(":");
			}
		}else{
			ipV6s = IPV6.split(":");
		}
		for(String ip:ipV6s){
			if(ipV6s.length>8 || ip.isEmpty() || ip.length()>4 || !ip.matches(regex)){
				return false;
			}
		}
		return true;
	}

	/**
	 * args:ipV4 addresses String
	 * return:ture if ipV4 addresses String is correct or false if ipV4 addresses String is wrong
	 * */
	public static boolean isIPV4Format(String ip){
		String[] ips = ip.split("\\.");
		if(ips.length != 4){
			return false;
		}
		try{
			for(String ipSplit:ips){
				Integer.valueOf(ipSplit);
			}
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}

	/**
	 * args:part of ipv4 address which split by point
	 * return:A string parameter converted to ipv6 format
	 * */
	public static String intToHex(int n){
		StringBuilder sb = new StringBuilder(8);
		char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		while(n != 0){
			sb = sb.append(b[n%16]);
			n = n/16;
		}
		return sb.reverse().toString();
	}

	/**
	 * args:The part of an ipv6 string with the ipv4 format
	 * return:The ipv4 format string is converted to an ipv6 format string
	 * */
	public static String IPV4ToIPV6(String ip){
		StringBuffer sbIPV4 = new StringBuffer();
		String[] ipV4s = ip.split("\\.");
		for(int i=0;i<ipV4s.length;i++){
			String intToHex = intToHex(Integer.valueOf(ipV4s[i]));
			sbIPV4.append(intToHex);
			if(i==1){
				sbIPV4.append(":");
			}
		}
		return sbIPV4.toString();
	}

	public static void main(String[] args) {
		String ipV6 = "abcd:1234:5678:ef90:abcd:1234:5678:ef90";
		String ipV6one = "2001:0DB8:0000:0023:0008:0800:200C:417A";
		String ipV6two = "2001:DB8:0:23:8:800:200C:417A";
		String ipV6three = "FF01:0:0:0:0:0:0:1101";
		String ipV6four = "FF01::1101";
		String ipV6five = "0:0:0:0:0:0:0:1";
		String ipV6six = "::";
		String ipV6seven = "::ABCD";
		String ipV6eight = "EF01::";
		String ipV6nine = "EF01::ABCD";
		String ipV6ten = "FF01:0:0:0:0:0:0:1101";
		String ipV6eleven = "::ac89:21f2:ed1f:1278:2AB8:ABCD";
		System.out.println("~~~~~~~~~~one~~~~~~~~~~");
		System.out.println(ipV6one);
		System.out.println(ipV6AdderssFix(ipV6one));
		System.out.println("~~~~~~~~~~one~~~~~~~~~~");
		System.out.println("~~~~~~~~~~two~~~~~~~~~~");
		System.out.println(ipV6two);
		System.out.println(ipV6AdderssFix(ipV6two));
		System.out.println("~~~~~~~~~~two~~~~~~~~~~");
		System.out.println("~~~~~~~~~~three~~~~~~~~~~");
		System.out.println(ipV6three);
		System.out.println(ipV6AdderssFix(ipV6three));
		System.out.println("~~~~~~~~~~three~~~~~~~~~~");
		System.out.println("~~~~~~~~~~four~~~~~~~~~~");
		System.out.println(ipV6four);
		System.out.println(ipV6AdderssFix(ipV6four));
		System.out.println("~~~~~~~~~~four~~~~~~~~~~");
		System.out.println("~~~~~~~~~~five~~~~~~~~~~");
		System.out.println(ipV6five);
		System.out.println(ipV6AdderssFix(ipV6five));
		System.out.println("~~~~~~~~~~five~~~~~~~~~~");
		System.out.println("~~~~~~~~~~six~~~~~~~~~~");
		System.out.println(ipV6six);
		System.out.println(ipV6AdderssFix(ipV6six));
		System.out.println("~~~~~~~~~~six~~~~~~~~~~");
		System.out.println("~~~~~~~~~~seven~~~~~~~~~~");
		System.out.println(ipV6seven);
		System.out.println(ipV6AdderssFix(ipV6seven));
		System.out.println("~~~~~~~~~~seven~~~~~~~~~~");
		System.out.println("~~~~~~~~~~eight~~~~~~~~~~");
		System.out.println(ipV6eight);
		System.out.println(ipV6AdderssFix(ipV6eight));
		System.out.println("~~~~~~~~~~eight~~~~~~~~~~");
		System.out.println("~~~~~~~~~~nine~~~~~~~~~~");
		System.out.println(ipV6nine);
		System.out.println(ipV6AdderssFix(ipV6nine));
		System.out.println("~~~~~~~~~~nine~~~~~~~~~~");
		System.out.println("~~~~~~~~~~ten~~~~~~~~~~");
		System.out.println(ipV6ten);
		System.out.println(ipV6AdderssFix(ipV6ten));
		System.out.println("~~~~~~~~~~ten~~~~~~~~~~");
		System.out.println("~~~~~~~~~~eleven~~~~~~~~~~");
		System.out.println(ipV6eleven);
		System.out.println(ipV6AdderssFix(ipV6eleven));
		System.out.println("~~~~~~~~~~eleven~~~~~~~~~~");
	}

}
