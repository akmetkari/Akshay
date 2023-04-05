package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest extends BaseClass 
{
	@Test 
	public void loginTest() 
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		Logger.info("URL is open");
		LoginPage lp = new LoginPage(driver);
		
		Logger.info("Entered userName");
		lp.setUserName(userName);
		Logger.info("Entered Password");
		lp.setPassword(password);
		lp.clickSubmit();
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			Logger.info("Login test passed");
		}
		else
		{
			Assert.assertTrue(false);
			Logger.info("Login test failed");
		}
		
		System.out.println("this is logger demo.");
		
		Logger.info("for info only");
					
	}
	
	
}
