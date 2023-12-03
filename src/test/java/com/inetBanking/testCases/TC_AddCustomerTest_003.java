package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user name is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		logger.info("providing customer details...");
		
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("500090");
		addcust.custtelephoneno("1234567891");
		
		String email = randomString() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdefg");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		//validate the data( customer added successfully)
		logger.info("validation started...");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully");
		
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("test case passed...");
		}
		else {
			logger.info("testcase failed...");
			captureScreen(driver,"addNewCustomer");   
			Assert.assertTrue(false);
			
		}
		
	}
	

}
