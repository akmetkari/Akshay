package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProduct extends BasePage{
	
	public SearchProduct(WebDriver rDriver)
	{
		super(rDriver);
	}
	
	@FindBy(how = How.XPATH, using="//a[@href='#']//span[contains(text(), 'Catalog')]")
	@CacheLookup
	WebElement lnkCatalog;
	
	@FindBy(how = How.XPATH, using="//span[@class='menu-item-title'][text()='Products']")
	@CacheLookup
	WebElement lnkProducts;
	
	@FindBy(how=How.XPATH, using="//input[@id='SearchProductName']")
	@CacheLookup
	WebElement productName;
	
	@FindBy(how=How.XPATH, using="//select[@id='SearchCategoryId']")
	@CacheLookup
	WebElement category;
	
	@FindBy(how=How.XPATH, using="//input[@id='SearchIncludeSubCategories']")
	@CacheLookup
	WebElement searchSubcategory;
	
	@FindBy(how=How.XPATH, using="//select[@id='SearchManufacturerId']")
	@CacheLookup
	WebElement manufacturer;
	
	@FindBy(how=How.XPATH, using="//select[@id='SearchVendorId']")
	@CacheLookup
	WebElement vendor;
	
	@FindBy(how=How.XPATH, using="//select[@id='SearchWarehouseId']")
	@CacheLookup
	WebElement warehouse;
	
	@FindBy(how=How.XPATH, using="//select[@id='SearchProductTypeId']")
	@CacheLookup
	WebElement productType;
	
	@FindBy(how=How.XPATH, using="//select[@id='SearchPublishedId']")
	@CacheLookup
	WebElement published;
	
	@FindBy(how= How.XPATH, using="//input[@id='GoDirectlyToSku']")
	@CacheLookup
	WebElement goToSku;
	
	@FindBy(how=How.XPATH, using="//button[@id='go-to-product-by-sku']")
	@CacheLookup
	WebElement btnSku;
	
	@FindBy(how=How.XPATH, using="//button[@id='search-products']")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using="//button[@id='delete-selected']")
	@CacheLookup
	WebElement btnDelete;
	
	@FindBy(how= How.XPATH, using="//button[@id='delete-selected-action-confirmation-submit-button']")
	WebElement btnConfirm;
	
	@FindBy(how=How.XPATH, using="//input[@class='checkboxGroups']")
	@CacheLookup
	WebElement checkboxGroups;
	
	@FindBy(how=How.XPATH, using="//td[@class=' button-column']//a[text()='Edit']")
	@CacheLookup
	WebElement btnEdit;
	
	@FindBy(how=How.XPATH, using="//select[@name='products-grid_length']")
	@CacheLookup
	WebElement productLength;
	
	public void selectProductLength()
	{
		Select sel = new Select(this.productLength);
		sel.selectByVisibleText("100");
	}
	
	public void clickLnkCatalog()
	{
		this.lnkCatalog.click();
	}
	
	public void clickLnkProducts()
	{
		WebDriverWait wait = new WebDriverWait(lDriver,15);
		wait.until(ExpectedConditions.elementToBeClickable(lnkProducts)).click();
	}
	
	public void setProductName(String name)
	{
		this.productName.clear();
		this.productName.sendKeys(name);
	}
	
	public void selectCategory()
	{
		Select sel = new Select(this.category);
		sel.selectByVisibleText("Computers >> Notebooks");
	}
	
	
	public void clickSubcategory()
	{
		this.searchSubcategory.click();
	}
	
	
	public void selectManufacturer()
	{
		Select sel = new Select(this.category);
		sel.selectByVisibleText("Apple");
	}
	
	public void selectVendor()
	{
		Select sel = new Select(this.vendor);
		sel.selectByVisibleText("Vendor 1");
	}
	
	public void selectProductType()
	{
		Select sel = new Select(this.productType);
		sel.selectByVisibleText("Simple");
	}
	
	public void selectPublishedOnly()
	{
		Select sel = new Select(this.published);
		sel.selectByVisibleText("Published only");
	}
	
	public void gotoSKU(String sku)
	{
		this.goToSku.clear();
		this.goToSku.sendKeys(sku);
	}
	
	public void clickSkuBtn()
	{
		this.btnSku.click();
	}
	
	public void clickSearchBtn()
	{
		this.btnSearch.click();
	}
	
	public void clickDeleteBtn()
	{
		this.btnDelete.click();
		
	}
	
	public void clickConfirmBtn()
	{
		WebDriverWait wait = new WebDriverWait(lDriver,15);
		wait.until(ExpectedConditions.visibilityOf(btnConfirm)).click();
	}
	
	public void clickEditBtn()
	{
		//this.btnEdit.click();
		WebDriverWait wait = new WebDriverWait(lDriver,15);
		wait.until(ExpectedConditions.visibilityOf(btnEdit)).click();
		
	}
	
	public void clickCheckboxGroups()
	{
		this.checkboxGroups.click();
	}
	
	int getRowsNumber()
	{
		int ln= lDriver.findElements(By.xpath("//table[@id='products-grid']/tbody/tr")).size();
		return ln;
	}
	
	int getColumnsNumber()
	{
		int ln= lDriver.findElements(By.xpath("//table[@id='products-grid']/tbody/tr/td")).size();
		return ln;
	}
	
	public boolean searchProductByName(String name)
	{
		boolean flag = false;
		
		for(int r=1; r < this.getRowsNumber()+1; r++)
		{
			try 
			{
			   WebElement table = lDriver.findElement(By.xpath("//table[@id='products-grid']"));
			   String nameId = table.findElement(By.xpath("//table[@id='products-grid']/tbody/tr["+String.valueOf(r)+"]/td[3]")).getText();
			   
			   if(name.equals(nameId))
			   {
					flag = true;
			   }
			   
			}
			catch(Exception e)
			{
				flag= false;
			}
			
			
		}
		
		return flag;
	}
	
	public boolean searchProductByType(String type)
	{
		boolean flag = false;
		
		for(int r=1; r< this.getRowsNumber()+1; r++)
		{
		
			try
			{
				WebElement table = lDriver.findElement(By.xpath("//table[@id='products-grid']"));
				String typeId = table.findElement(By.xpath("//table[@id='products-grid']/tbody/tr["+String.valueOf(r)+"]/td[7]")).getText();
				
				if(type.equals(typeId))
				{
					flag = true;
				}
			}catch(Exception e) {
				flag = false;
			}
		}
		
		return flag;
	}
	
	public void selectTableItems()
	{
		List<WebElement> elements = lDriver.findElements(By.xpath("//input[@class='checkboxGroups']"));
		
		for(WebElement el : elements)
		{
			if(!el.isSelected()) {
			   el.click();
			}
			
		}
		
	}
	
	

}
