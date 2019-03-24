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
	public static String ipV6AdderssFix(String ipV6){
		StringBuffer sb = new StringBuffer();
		if(ipV6.contains("::")){
			if(ipV6.equals("::")){
				return "0000:0000:0000:0000:0000:0000:0000:0000";
			}
			String ipV6$ = ipV6.replace("::",":$:");
			String[] ipV6s = ipV6$.split(":");
			if(ipV6s[0].isEmpty() && ipV6s[1].equals("$")){
				for(int i=0;i<10-ipV6s.length;i++){
					sb = sb.append("0000:");
				}
				return sb.append(ipV6.split("::")[1].toLowerCase()).toString();
			}else if(ipV6s.length==2 && ipV6s[1].equals("$")){
				sb = sb.append(ipV6.replace("::",":").toLowerCase());
				for(int i=0;i<9-ipV6s.length;i++){
					sb = sb.append("0000:");
				}
				return sb.substring(0,sb.length()-1);
			}else if(ipV6s.length==3 && ipV6s[1].equals("$")){
				sb = sb.append(ipV6.split("::")[0].toLowerCase()).append(":");
				for(int i=0;i<9-ipV6s.length;i++){
					sb = sb.append("0000:");
				}
				sb = sb.append(ipV6.split("::")[1].toLowerCase());
				return sb.toString();
			}
        }
		sb.append(ipV6);
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
