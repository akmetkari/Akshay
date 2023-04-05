package org.apache.maven.archetypes.nopcommerceApp;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.SearchProduct;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ClearAllProductsTest extends TestBase {
	LoginPage loginPage;
	SearchProduct searchProduct;


	
  @Test
  public void test_IfAllTheChosenProductsCanBeDeletedWhenPressingDeleteButton() {
	  searchProduct.clickLnkCatalog();
	  searchProduct.clickLnkProducts();
	  
	  searchProduct.selectProductLength();
	  
	  try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  searchProduct.selectTableItems();
	  
	  searchProduct.clickDeleteBtn();
	  
	  searchProduct.clickConfirmBtn();
	  
	  logger.info("validation started");
	  String expectedMessage = "No data available in table";
	  String actualMessage = driver.findElement(By.xpath("//*[text()='No data available in table']")).getText();
	  
	  if(actualMessage.equals(expectedMessage))
	  {
		  logger.info("Delete all the products test Passed");
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  logger.warn("Delete all the products test failed");
		  try {
			captureScreen(driver,"test_IfSearchedProductWasDeletedAfterPressingDeleteButton");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  Assert.assertTrue(false);
	  }
	 
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	 
	  logger.info("Load test");
	  loginPage = new LoginPage(driver);
	  loginPage.setUsername(readConfig.getUsername());
	  logger.info("username provided");
	  loginPage.setPassword(readConfig.getPassword());
	  logger.info("password provided");
	  loginPage.clickSubmit();
	  
	  searchProduct = new SearchProduct(driver);
  }
  
  

  @AfterMethod
  public void afterMethod() {
	 logger.info("Delete all the products test completed");
  }

}
