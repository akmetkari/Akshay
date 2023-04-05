package org.apache.maven.archetypes.nopcommerceApp;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LoginPage;
import pageObjects.SearchProduct;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestSearchProductByName extends TestBase{
	
  LoginPage loginPage;
  SearchProduct searchProduct;
  
  @Test
  public void test_searchByProductName(){
	 
	  searchProduct.setProductName("Laptop Dell Inspiron LTD.");
	  
	  searchProduct.clickSearchBtn();
	  
	  logger.info("validation by name  started.......");
	  //test if entered product equals to this one in a table
	  if(searchProduct.searchProductByName("Laptop Dell Inspiron LTD.") == true)
	  {
		  Assert.assertTrue(true);
		  logger.info("test_searchByProductName Passed");
	  }
	  else
	  {
		  
		  logger.warn("Search product by name test Failed");
		  try {
			captureScreen(driver,"test_searchByProductName");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		  Assert.assertTrue("Product not appears in table", false);
		 
	  }
	  
  }
  
  @BeforeMethod
  public void beforeMethod()
  {
	  logger.info("Prepare Search product by name Test");
	  loginPage = new LoginPage(driver);
	  loginPage.setUsername(username);
	  logger.info("username provided");
	  loginPage.setPassword(password);
	  logger.info("password provided");
	  loginPage.clickSubmit();
	  searchProduct = new SearchProduct(driver);
	  logger.info("go to search product page");
	  searchProduct.clickLnkCatalog();
	  searchProduct.clickLnkProducts();
  }
  
  @AfterMethod
  public void afterMethod()
  {
	  logger.info("Search product by name test Completed");
  }
  
  

}
