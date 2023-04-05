package org.apache.maven.archetypes.nopcommerceApp;

import org.testng.annotations.Test;

import pageObjects.AddProduct;
import pageObjects.LoginPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;


import org.openqa.selenium.By;

import org.testng.Assert;

public class TestAddProduct extends TestBase{
	

	public LoginPage loginPage;

	public AddProduct addProduct;
	
  @Test
  public void test_AddProduct() throws InterruptedException {
	  


	  logger.info("providing product details..........");
	  
	  addProduct.addProductName("Laptop Dell Inspiron LTD.");
	  addProduct.addDescription("Notebook computer with built in  Windows OS and toucheable screen");
	  addProduct.addSKU("NEW_PC");
	  
	  
	  addProduct.chooseCategory("Electronics");
	  
	  addProduct.productTags("#Laptop");
	  
	  logger.info("save and update price");
	  addProduct.saveAndEditProduct();
	  
	  
	  
	  logger.info("validation before price update started.........");
	  
	  String expMsg =  "The new product has been added successfully.";
	  String actMsg = driver.findElement(By.xpath("//body/div[3]/div[3]/div[1]")).getText();
	 
	  
	  
	  if(actMsg.contains(expMsg))
	  {
		  
		  Assert.assertTrue(true);
		  logger.info("Add product(before price update) test Passed");
	  }
	  else
	  {
		  try {
			captureScreen(driver, "test_AddProduct");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  logger.warn("Add product(before price update) test Failed");
		  Assert.assertTrue(false,"Texts are not equal");
		
	  }
	  
	 
	  
	  logger.info("After product added update price");
	  
	  addProduct.addPrice();
	  
	  addProduct.saveProduct();
	  
	  
	  logger.info("validation after price update started.........");
	  String updatedexpMsg = "The product has been updated successfully.";
	  String updatedactMsg = driver.findElement(By.xpath("//body/div[3]/div[3]/div[1]")).getText();
	  
	  
	  if(updatedactMsg.contains(updatedexpMsg))
	  {
		  Assert.assertTrue(true);
		  logger.info("Add product(after price update) test Passed");
	  }
	  else
	  {
		  try {
			captureScreen(driver, "test_AddProduct");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  logger.warn("Add product(after price update) test Failed");
		  Assert.assertTrue(false,"Texts are not equal");
		  
	  }  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  logger.info("Prepare Add product Test");
	  
	  loginPage = new LoginPage(driver);
	  loginPage.setUsername(username);
	  logger.info("username provided");
	  loginPage.setPassword(password);
	  logger.info("password provided");
	  loginPage.clickSubmit();
	  addProduct = new AddProduct(driver);
	  logger.info("Go to Add product Page");
	  addProduct.clickLnkCatalog();
	  addProduct.clickLnkProducts();
	  addProduct.clickAddNewProduct();
	  
  }
  
  @AfterMethod
  public void afterMethod()
  {
	  logger.info("Add product test Completed");
  }


}
