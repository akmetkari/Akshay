package org.apache.maven.archetypes.nopcommerceApp;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.AddProduct;
import pageObjects.LoginPage;
import pageObjects.SearchProduct;


import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;

import org.testng.annotations.AfterMethod;

public class TestEditSearchedProduct extends TestBase{
	
	LoginPage loginPage;
	SearchProduct searchProduct;
	AddProduct addProduct;
	
  @Test
  public void test_ifTheSearchedProductUpdatedAfterEditing() {
	  
	  searchProduct.clickLnkCatalog();
	  searchProduct.clickLnkProducts();
	  searchProduct.setProductName("Laptop Dell Inspiron LTD.");
	  searchProduct.clickSearchBtn();
	  
	  searchProduct.clickEditBtn();
	  
	  addProduct.selectVendors();
	  
	  addProduct.saveProduct();
	  
	  String expMsg = "The product has been updated successfully.";
	  String actMsg = driver.findElement(By.tagName("body")).getText();
	  
	  
	  if(actMsg.contains(expMsg))
	  {
		  Assert.assertTrue(true);
		  logger.info("Edit searched product test Passed");
	  }else {
		  logger.warn("Edit searched product test Failed");
		  try {
			captureScreen(driver, "test_ifTheSearchedProductUpdatedAfterEditing");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  Assert.assertTrue("Update failed",false);
	  }
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  logger.info("Load Edit searched product Test");
	  loginPage = new LoginPage(driver);
	  loginPage.setUsername(readConfig.getUsername());
	  logger.info("Provide username");
	  loginPage.setPassword(readConfig.getPassword());
	  logger.info("Provide password");
	  loginPage.clickSubmit();
	  
	  searchProduct = new SearchProduct(driver);
	  addProduct = new AddProduct(driver);
  }

  @AfterMethod
  public void afterMethod() {
	  
	logger.info("Edit searched product test Completed");
  }

}
