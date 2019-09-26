package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UNF_067_POM {
	private WebDriver driver; 
	
	public UNF_067_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='input-username']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='catalog']/a[1]")
	private WebElement catalog; 
	
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	private WebElement categories; 
	
	//@FindBy(xpath="//a[@href='http://uniform.upskills.in/admin/index.php?route=catalog/product&token=f8Ggtzp9Mp6y6tyDOlVZxER9HLJiMkg3']")
	@FindBy(xpath="//a[contains(text(),'Products')]")
	private WebElement products; 
	
	@FindBy(xpath="//h3[@class='panel-title']")
	private WebElement productList; 
	
	@FindBy(xpath="//input[@id='input-name']")
	private WebElement productName; 
	
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement price; 
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filter; 
	
	@FindBy(xpath="//tbody//tr[1]//td[3]")
	private WebElement productNametable; 
	
	@FindBy(xpath="//select[@id='input-status']")
	private WebElement status; 
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement model;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement quantity; 
	
	@FindBy(xpath="	//i[@class='fa fa-sign-out fa-lg']")
	private WebElement logout;
		
	//Enter Username
			public void senduserName(String user) {
				this.userName.clear();
				this.userName.sendKeys(user);
				/*if(this.userName.getAttribute("value").equals(user))
					System.out.println("PASS - Entered UserName is displayed in UserName text box");
				else
				System.out.println("FAIL");*/
			}
		//Enter Password
			public void sendPassword(String password) {
				this.password.clear(); 
				this.password.sendKeys(password); 
				/*if(this.password.getAttribute("value").equals(password))
					System.out.println("PASS - Entered password is displayed in Password text box");
				else
				System.out.println("FAIL");*/
			}	
			
		//Click on the login link
		public void login(){
			this.loginBtn.click();
			}
		
		//Click on Catalog icon
		public void clickCatalog() throws InterruptedException{
			Actions act = new Actions(driver);
			
			act.sendKeys(catalog, (Keys.ENTER)).build().perform();
			Thread.sleep(1000);
			if(categories.isDisplayed()){
				System.out.println("Step 1: PASS - Categories, Products, Recurring Profiles, Filters, Attributes, Option links are displayed");
			}
			else
				System.out.println("Step 1: FAIL");
			
			 /*List<WebElement> links = driver.findElements(By.tagName("a"));
			    // no. p
			    System.out.println((links.size()));*/
			
			}
		//Click on Products
		public void clickProducts() throws InterruptedException{
			
			this.products.click();
			/*Actions act = new Actions(driver);
			//WebElement categories = driver.findElement(By.xpath("//a[contains(text(),'Categories')]"));
		
			act.sendKeys(products,(Keys.ENTER)).build().perform();
			Thread.sleep(1000);
*/
			if(productList.isDisplayed())
				System.out.println("Step 2: PASS - Product List with product details is displayed");
			else
				System.out.println("Step 2: FAIL");
		}
		
		//Enter valid data in Product Name
		public void enterproductName(String pName) throws InterruptedException{
			this.productName.clear();
			this.productName.sendKeys(pName);
			Thread.sleep(1000);
			String pnamemsg = this.productName.getAttribute("value");
			Assert.assertEquals(pnamemsg, pName);
				System.out.println("Step 3: PASS - Entered data in Product Name textbox is displayed");
						
		}
		
		//Enter valid data in Price textbox
		public void enterprice(String price) throws InterruptedException {
			this.price.clear();
			this.price.sendKeys(price);
			Thread.sleep(1000);
			
			String pricevalue = this.price.getAttribute("value");
			Assert.assertEquals(pricevalue, price);
			System.out.println("Step 4: PASS - Entered data in Price textbox is displayed" );
			
					
		}
		
		//Click on Filter
		public void filter5() throws InterruptedException{
			this.filter.click();
			if(productNametable.isDisplayed())
				System.out.println("Step 5: PASS - Product List with matching product details is displayed");
			else
				System.out.println("Step 5: FAIL");
			}
		
		//Select values from Status List
				public void selectStatus(String statusvalue) throws InterruptedException {
					Select sel = new Select(status);
					sel.selectByVisibleText(statusvalue);
					Thread.sleep(1000);
				
					String selectedvalue = sel.getFirstSelectedOption().getText().trim();
					
					if(selectedvalue.equalsIgnoreCase(statusvalue))
					{
						System.out.println("Step 6: PASS - Selected status value is displayed" );
					}
					else
						System.out.println("Step 6: FAIL");
					
				}
				
		//Enter valid data in Model textbox
				public void entermodel(String model) {
					this.model.clear();
					this.model.sendKeys(model);
					
					if(model.equalsIgnoreCase(this.model.getAttribute("value")))
					{
						System.out.println("Step 7: PASS - Entered data in Model textbox is displayed" );
					}
					else
						System.out.println("Step 7: FAIL");
					
				}
				
			//Enter valid data in Quantity description textbox
				public void enterquantity(String qty) {
					this.quantity.clear();
					this.quantity.sendKeys(qty);
					
					if(qty.equalsIgnoreCase(this.quantity.getAttribute("value")))
					{
						System.out.println("Step 8: PASS - Entered data in Quantity textbox is displayed" );
					}
					else
						System.out.println("Step 8: FAIL");
					
				}
			//Click on Filter	
				public void filter() throws InterruptedException{
					this.filter.click();
					if(productNametable.isDisplayed())
						System.out.println("Step 9: PASS - Product List with matching product details is displayed");
					else
						System.out.println("Step 9: FAIL");
					}
		
				
	   	//logout
			public void logout(){
				this.logout.click();
			}
				
}
