package com.inetBanking.testCases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
/*
import java.io.File;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;



public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	

	
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	// it will take parameters from xml file
	@Parameters("browser")
	@BeforeClass
	//based on the value we get from the xml file browser is launched.
	public void setup(String br) throws Exception {
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		

		if(br.equals("chrome")) {
			try {
				System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
				driver = new ChromeDriver();
			}
			catch (Exception e) {
				e.printStackTrace();
				throw new Exception("failed!");
			}
		}
		
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
			driver = new FirefoxDriver();
			}
		
		else if(br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver = new EdgeDriver();
			}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		
	}
		
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png" );
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		
		return(generatedstring);
	}
	
	public static String randomNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return(generatedString2);
		
	}
	
	//whatever commom methods using across all the test cases, should be part of base class.
	
}
