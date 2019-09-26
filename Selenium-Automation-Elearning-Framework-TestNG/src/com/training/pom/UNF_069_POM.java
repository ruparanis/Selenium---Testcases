package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UNF_069_POM {
	private WebDriver driver; 
	
	public UNF_069_POM(WebDriver driver) {
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
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addnew; 
	
	@FindBy(xpath="//h3[@class='panel-title']")
	private WebElement addproduct; 
		
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement productName; 
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement metatagTitle; 
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement dataTab; 
	
	@FindBy(xpath="//input[@id='input-model']")
	private WebElement model;
	
	@FindBy(xpath="//input[@id='input-price']")
	private WebElement price; 
	
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement quantity; 
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	private WebElement linksTab;
	
	@FindBy(xpath="//input[@id='input-category']")
	private WebElement categorieslinks;
	
	@FindBy(xpath="//li[@data-value='456']//a[@href='#'][contains(text(),'Blazers(3-5)')]")
	private WebElement categorieslistvalues;
	
	@FindBy(xpath="//div[@id='product-category485']")
	private WebElement categorieslist;
	
	@FindBy(xpath="//a[contains(text(),'Design')]")
	private WebElement designTab;
	
	@FindBy(xpath="//select[@name='product_layout[0]']")
	private WebElement layout;
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement save;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement erroralert;
	
	@FindBy(xpath="	//i[@class='fa fa-sign-out fa-lg']")
	private WebElement logout;
		
	//Enter Username
			public void senduserName(String user) {
				this.userName.clear();
				this.userName.sendKeys(user);
				
			}
		//Enter Password
			public void sendPassword(String password) {
				this.password.clear(); 
				this.password.sendKeys(password); 
				
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
			
			}
		//Click on Products
		public void clickProducts() throws InterruptedException{
			
			this.products.click();
			
			if(productList.isDisplayed())
				System.out.println("Step 2: PASS - Product List with product details is displayed");
			else
				System.out.println("Step 2: FAIL");
		}
		
		//Click on Add New
		
		public void addNew() throws InterruptedException {
			this.addnew.click();
			Thread.sleep(1000);
			if(addproduct.isDisplayed())
				System.out.println("Step 3: PASS - Add Product Page is displayed");
			else
				System.out.println("Step 3: FAIL");
		}
				
		//Enter valid data in Product Name
		public void enterproductName(String pName) throws InterruptedException{
			this.productName.clear();
			this.productName.sendKeys(pName);
			Thread.sleep(1000);
			String pnamemsg = this.productName.getAttribute("value");
			Assert.assertEquals(pnamemsg, pName);
				System.out.println("Step 4: PASS - Entered data in Product Name textbox is displayed");
						
		}
		
		//Enter valid data in Meta Tag Title
				public void entermetatagTitle(String metatitle) throws InterruptedException{
					this.metatagTitle.clear();
					this.metatagTitle.sendKeys(metatitle);
					Thread.sleep(1000);
					String metatagtitle = this.metatagTitle.getAttribute("value");
					Assert.assertEquals(metatagtitle, metatitle);
						System.out.println("Step 5: PASS - Entered data in Meta Tag Title textbox is displayed");
								
				}
				
		//click on Data Tab
				public void dataTab() throws InterruptedException{
					this.dataTab.click();
					if(model.isDisplayed())
						System.out.println("Step 6: PASS - Data tab fields are displayed");
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
		
		//Enter valid data in Price textbox
		public void enterprice(String price) throws InterruptedException {
			this.price.clear();
			this.price.sendKeys(price);
			Thread.sleep(1000);
			
			String pricevalue = this.price.getAttribute("value");
			Assert.assertEquals(pricevalue, price);
			System.out.println("Step 8: PASS - Entered data in Price textbox is displayed" );
			
					
		}
		
		//Enter valid data in Quantity description textbox
		public void enterquantity(String qty) {
			this.quantity.clear();
			this.quantity.sendKeys(qty);
			
			if(qty.equalsIgnoreCase(this.quantity.getAttribute("value")))
			{
				System.out.println("Step 9: PASS - Entered data in Quantity textbox is displayed" );
			}
			else
				System.out.println("Step 9: FAIL");
			
		}
		
		//Click on Links tab
		public void clickLinks() throws InterruptedException{
			this.linksTab.click();
			if(categorieslinks.isDisplayed())
				System.out.println("Step 10: PASS - Links tab fields are displayed");
			else
				System.out.println("Step 10: FAIL");
			}
		
		//Click on Categories from Links tab
				public void clickCategorieslinks(String categories) throws InterruptedException {
					this.categorieslinks.click();
					
					if(categorieslistvalues.isDisplayed())
						System.out.println("Step 11: PASS - Categories present in the category list are displayed");
					else
						System.out.println("Step 11: FAIL");
					
					categorieslinks.sendKeys(categories);
					
					Thread.sleep(1000);
					String categorieslistvalue = categorieslinks.getAttribute("value");
					//String selectedvalue = sel.getFirstSelectedOption().getText().trim();
					
					if(categorieslistvalue.equalsIgnoreCase(categories))
					{
						System.out.println("Step 12: PASS - Selected Categories value is displayed" );
					}
					else
						System.out.println("Step 12: FAIL");
					
				}
				
				//Click on Design tab
				public void designTab() throws InterruptedException{
					this.designTab.click();
					Thread.sleep(1000);
					if(layout.isDisplayed())
							System.out.println("Step 13: PASS - Default values in Attribute, Option, Recurring, Discount, Special, Image, Reward Points and Design tab");
					else
						System.out.println("Step 13: FAIL");
				}
					
										
			// Save
				public void save(){
					this.save.click();
					
					String Actmsg = this.erroralert.getText().toString().trim();
					String Expmsg = "Warning: Please check the form carefully for errors!";
					Assert.assertTrue(Actmsg.contains(Expmsg), Expmsg);
					System.out.println("Step 14: PASS - Error with a warning message is displayed ");
				}
		
				
	   	//logout
			public void logout(){
				this.logout.click();
			}
				
}
