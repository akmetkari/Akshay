package org.apache.maven.archetypes.nopcommerceApp;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LoginPage;
import pageObjects.SearchProduct;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestSearchProductByType extends TestBase{
	
	LoginPage loginPage;
	SearchProduct searchProduct;
	
  @Test
  public void test_searchProductByType() throws InterruptedException {
	  
	  searchProduct.selectProductType();
	  
	  searchProduct.clickSearchBtn();
	  logger.info("validation by type started.........");
	  
	  //test if searched product appears in table
	  if(searchProduct.searchProductByType("Simple") == true)
	  {
		  Assert.assertTrue(true);
		  logger.info("Search product by type test Passed");
	  }
	  else
	  {
		  try {
			captureScreen(driver,"test_searchProductByType");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		  logger.warn("Search product by type test Failed");
		  Assert.assertTrue("Product not appears in table", false);
		  
	  }
	 
  }
  
  @BeforeClass
  public void beforeClass() {
	  
	  logger.info("Prepare Search product by type Test");
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
	  logger.info("Search product by type test Completed");
  }
  
  

}
