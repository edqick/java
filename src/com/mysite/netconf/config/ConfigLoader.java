package com.mysite.netconf.config;

import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
	private Properties conf = new Properties();
	private static ConfigLoader confLoader = new ConfigLoader();
  
	private ConfigLoader() {
		loadConf("/config/netconf.properties");
	}
  
	public static ConfigLoader getInstance() {
		return confLoader;
	}
  
	public void loadConf(String confFile) {
		loadOneConfFile(confFile);
	}
  
	public String getConf(String name) {
		String value = this.conf.getProperty(name);
		if (value == null) {
			return value;
		}
		return value.trim();
	}
  
	public int getInt(String name) {
		String val = getConf(name);
		try {
			return Integer.parseInt(val);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return 0;
	}
  
	private void loadOneConfFile(String file) {
		try {
			this.conf.load(getClass().getResourceAsStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
