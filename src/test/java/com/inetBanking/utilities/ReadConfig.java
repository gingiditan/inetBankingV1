package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	//constructor to load the complete  properties file
	public ReadConfig() {
	
		File src = new File ("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src); // to read the data
			pro = new Properties();
			pro.load(fis);
			}
		catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
		
	}
	
	// for every variable we have to create a different method
	public String getApplicationURL() {
		// read the data from property file using pro.getProperty() method, store that in to variable and return it
		String  url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	

	public String getEdgePath() {
		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}
	
	public String getFireFoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}  
	
	
	
}
