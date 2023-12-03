package com.inetBanking.testCases;

import java.io.IOException;

//import java.io.IOException;

import org.testng.Assert;
//import org.junit.Assert;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{


	@Test
		public void loginTest( ) throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		Thread.sleep(3000);
		logger.info("Entered username");
		
		
		lp.setPassword(password);
		Thread.sleep(3000);
		logger.info("Entered password");
		
		lp.clickSubmit();
		Thread.sleep(3000);
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);	
			Thread.sleep(3000);
		
			logger.info("login test passed");
		}
		else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			Thread.sleep(3000);
			logger.info("login test failed");
		}
		
	}

	
}
