package org.apache.maven.archetypes.nopcommerceApp;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.AddManufacturer;
import pageObjects.LoginPage;


import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;

import org.testng.annotations.AfterMethod;

public class TestAddManufacturer extends TestBase{
	LoginPage loginPage;
	
	AddManufacturer addManufacturer;
	
	
  @Test
  public void test_addManufacturer() throws AWTException, InterruptedException {
	  
	 addManufacturer.clickLnkCatalog();
	 addManufacturer.clickLnkManufacturers();
	 
	 
	  
	 addManufacturer.clickAddNew();
	 
	 addManufacturer.addManufacturerName("Samsung");
	 addManufacturer.loadImage("D:\\Programming Languages\\Java\\nopcommerceApp\\images\\samsung.png");
	
	 addManufacturer.pageSize();
	 addManufacturer.pageSizeOptions("6,10,30");
	 addManufacturer.priceRanges("10000-20000"); 
	 addManufacturer.displayOrder();
	 
	
	 addManufacturer.clickSaveButton();
	 
	 logger.info("validation started");
	 String expMessage = "The new manufacturer has been added successfully.";
	 String actualMessage = driver.findElement(By.tagName("body")).getText();
	 
	 if(actualMessage.contains(expMessage))
	 {
		 logger.info("Add Manufacturer test Passed");
		 Assert.assertTrue(true);
	 }
	 else
	 {
		 logger.warn("Add Manufacturer test Failed");
		 try {
			captureScreen(driver, "test_addManufacturer");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Assert.assertTrue(false);
	 }
  }
  @BeforeMethod
  public void beforeMethod() {

	  logger.info("Load Add Manufacturer Test");
	  loginPage = new LoginPage(driver);
	  
	  loginPage.setUsername(readConfig.getUsername());
	  logger.info("username provided");
	  loginPage.setPassword(readConfig.getPassword());
	  logger.info("password provided");
	  loginPage.clickSubmit();
	  
	  addManufacturer = new AddManufacturer(driver);

	  
	 
  }

  @AfterMethod
  public void afterMethod() {
	  
	  logger.info("Load Add Manufacturer Test Completed");
  }

}
