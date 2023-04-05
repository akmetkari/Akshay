package pageObjects;


import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProduct extends BasePage{
	
	
	WebElement listItem;
	
	WebElement element;
	
	public AddProduct(WebDriver rDriver)
	{
		super(rDriver);
	}
	
	@FindBy(how = How.XPATH, using="//a[@href='#']//span[contains(text(), 'Catalog')]")
	@CacheLookup
	WebElement lnkCatalog;
	
	@FindBy(how = How.XPATH, using="//span[@class='menu-item-title'][text()='Products']")
	@CacheLookup
	WebElement lnkProducts;
	
	@FindBy(how = How.XPATH, using="//a[@class='btn bg-blue']")
	@CacheLookup
	WebElement btnAddNew;
	
	@FindBy(how=How.XPATH, using="//input[@id='Name']")
	@CacheLookup
	WebElement productName;
	
	@FindBy(how=How.XPATH, using="//textarea[@id='ShortDescription']")
	@CacheLookup
	WebElement shortDescription;
	
	@FindBy(how=How.XPATH, using="//input[@id='Sku']")
	@CacheLookup
	WebElement SKU;
	
	@FindBy(how=How.XPATH, using="//div[@class='k-widget k-multiselect k-multiselect-clearable']")
	@CacheLookup
	WebElement categories;
	
	@FindBy(how=How.XPATH, using="//input[@id='Published']")
	@CacheLookup
	WebElement published;
	
	@FindBy(how=How.XPATH, using="//div[@class='col-md-9']//ul[@class='tag-editor ui-sortable']")
	@CacheLookup
	WebElement productTags;
	
	@FindBy(how=How.XPATH, using="//input[@id='ShowOnHomepage']")
	@CacheLookup
	WebElement showOnHomePage;
	
	@FindBy(how=How.XPATH, using="//select[@class='form-control valid']")
	@CacheLookup
	WebElement productType;
	
	@FindBy(how=How.XPATH, using="//input[@id='Price']")
	@CacheLookup
	WebElement price;
	
	@FindBy(how=How.XPATH, using="//input[@id='OldPrice']")
	@CacheLookup
	WebElement oldPrice;
	
	@FindBy(how=How.XPATH, using="//input[@id='ProductCost']")
	@CacheLookup
	WebElement productCost;
	
	@FindBy(how=How.CSS, using="body.skin-blue.sidebar-mini.advanced-settings-mode:nth-child(2) div.wrapper:nth-child(5) div.content-wrapper div.content:nth-child(4) div.form-horizontal div.panel.panel-default.collapsible-panel div.panel-container div.panel-group:nth-child(2) div.panel div.panel-body div.form-group:nth-child(1) div.col-md-9 span.k-widget.k-numerictextbox:nth-child(1) span.k-numeric-wrap.k-state-default span.k-select span.k-link.k-link-increase:nth-child(1) > span.k-icon.k-i-arrow-60-up")
	@CacheLookup
	WebElement priceArrowUp;
	
	@FindBy(how=How.CSS, using="body.skin-blue.sidebar-mini.advanced-settings-mode:nth-child(2) div.wrapper:nth-child(5) div.content-wrapper div.content:nth-child(4) div.form-horizontal div.panel.panel-default.collapsible-panel div.panel-container div.panel-group:nth-child(2) div.panel div.panel-body div.form-group:nth-child(1) div.col-md-9 span.k-widget.k-numerictextbox:nth-child(1) span.k-numeric-wrap.k-state-default span.k-select span.k-link.k-link-decrease:nth-child(2) > span.k-icon.k-i-arrow-60-down")
	@CacheLookup
	WebElement priceArrowDown;
		
	@FindBy(how=How.XPATH, using="//button[@class='btn bg-blue'][2]")
	@CacheLookup
	WebElement btnSaveAndEdit;
	
	@FindBy(how=How.XPATH, using="//button[@class='btn bg-blue'][1]")
	@CacheLookup
	WebElement btnSave;
	
	/*Categories*/
	@FindBy(how=How.XPATH, using="//li[text()='Computers']")
	@CacheLookup
	WebElement computersCategory;
	
	@FindBy(how=How.XPATH, using="//li[text()='Computers >> Desktops']")
	@CacheLookup
	WebElement computersDesctops;
	
	@FindBy(how=How.XPATH, using="//li[text()='Computers >> Software']")
	@CacheLookup
	WebElement computersSoftware;
	
	@FindBy(how=How.XPATH, using="//li[text()='Electronics']")
	@CacheLookup
	WebElement electronicsCategory;
	
	@FindBy(how=How.XPATH, using="//select[@id='VendorId']")
	@CacheLookup
	WebElement vendor;

	public void clickLnkCatalog()
	{
		this.lnkCatalog.click();
	}
	
	public void clickLnkProducts()
	{
		WebDriverWait wait = new WebDriverWait(lDriver,15);
		wait.until(ExpectedConditions.elementToBeClickable(lnkProducts)).click();
	}
	
	public void clickAddNewProduct()
	{
	
		WebDriverWait wait = new WebDriverWait(lDriver,15);
		wait.until(ExpectedConditions.elementToBeClickable(btnAddNew)).click();
	}
	
	public void addProductName(String name)
	{
		this.productName.clear();
		this.productName.sendKeys(name);
	}
	
	public void addDescription(String description)
	{
		this.shortDescription.clear();
		this.shortDescription.sendKeys(description);
	}
	
	public void addSKU(String sku)
	{
		this.SKU.clear();
		this.SKU.sendKeys(sku);
	}
	
	public void checkPublished()
	{
		this.published.click();
	}
	
	
	public void productTags(String tags)
	{
		
      Actions action = new Actions(lDriver);
      action.moveToElement(productTags).click().sendKeys(tags).perform();
	}
	
	public void selectVendors()
	{
		Select sel = new Select(this.vendor);
		sel.selectByVisibleText("Vendor 1");
	}
	
	public void chooseCategory(String cat) throws InterruptedException
	{
		
		this.categories.click();
		
		Thread.sleep(5);
		if(cat.equals("Computers"))
		{
			listItem = this.computersCategory;
		}
		else if(cat.equals("Computers>>Desctops"))
		{
			listItem = this.computersDesctops;
		}
		else if(cat.equals("Computers>>Software"))
		{
			listItem = this.computersSoftware;
		}
		else if(cat.equals("Electronics"))
		{
			listItem = this.electronicsCategory;
		}
		
		JavascriptExecutor executor = (JavascriptExecutor)lDriver;
		executor.executeScript("arguments[0].click()", listItem);
		
	}
	
	public void addPrice()
	{
		
		 
		for(int i=0; i < 10; i++) {
	       
			 Actions action = new Actions(lDriver);
			 action.moveToElement(priceArrowUp).click().perform();
	     
		}
	}
	
	public void saveAndEditProduct()
	{
		JavascriptExecutor executor = (JavascriptExecutor)lDriver;
		executor.executeScript("arguments[0].click()",btnSaveAndEdit );
	}
	
	public void saveProduct()
	{
		JavascriptExecutor executor = (JavascriptExecutor)lDriver;
		executor.executeScript("arguments[0].click()",btnSave );
	}

}
