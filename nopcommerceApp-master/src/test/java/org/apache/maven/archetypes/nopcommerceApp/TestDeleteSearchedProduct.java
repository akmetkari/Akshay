package org.apache.maven.archetypes.nopcommerceApp;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LoginPage;
import pageObjects.SearchProduct;


import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;

public class TestDeleteSearchedProduct extends TestBase{
	
	
	LoginPage loginPage;
	
	SearchProduct searchProduct;
	
  @Test
  public void test_IfSearchedProductWasDeletedAfterPressingDeleteButton() {
	  
	  searchProduct.clickLnkCatalog();
	  searchProduct.clickLnkProducts();
	  searchProduct.setProductName("Laptop Dell Inspiron LTD.");
	  searchProduct.clickSearchBtn();
	  
	  //if product presented in table
	  if(searchProduct.searchProductByName("Laptop Dell Inspiron LTD.")==true)
	  {
		  searchProduct.clickCheckboxGroups();
		  searchProduct.clickDeleteBtn();
		  searchProduct.clickConfirmBtn();
		  
		  String expectedMessage = "No data available in table";
		  String actualMessage = driver.findElement(By.xpath("//*[text()='No data available in table']")).getText();
		  //System.out.println("Actual message: " + actualMessage);
		  
		  if(actualMessage.equals(expectedMessage)) {
			  Assert.assertTrue(true);
			  logger.info("test_IfSearchedProductWasDeletedAfterPressingDeleteButton passed");
			  

		  }
		  else
		  {
			  try {
				captureScreen(driver,"test_IfSearchedProductWasDeletedAfterPressingDeleteButton");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  logger.warn("test_IfSearchedProductWasDeletedAfterPressingDeleteButton failed");
			  Assert.assertTrue("Element still presented",false);
		  }
	  }
	  else if(!(searchProduct.searchProductByName("Laptop Dell Inspiron LTD.")==true)) 
	  {
		  try {
			captureScreen(driver,"test_IfSearchedProductWasDeletedAfterPressingDeleteButton");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  logger.warn("Element is not presented or already deleted");
		  Assert.assertTrue("Element is not presented", false);
	  }

 }
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  logger.info("test_IfSearchedProductWasDeletedAfterPressingDeleteButton loaded");
	  loginPage = new LoginPage(driver);
	  loginPage.setUsername(readConfig.getUsername());
	  logger.info("username provided");
	  loginPage.setPassword(readConfig.getPassword());
	  logger.info("password provided");
	  loginPage.clickSubmit();
	  searchProduct = new SearchProduct(driver);
  }

  @AfterMethod
  public void afterMethod(){
	  
	  logger.info("test_IfSearchedProductWasDeletedAfterPressingDeleteButton completed");
	  
  }

}
