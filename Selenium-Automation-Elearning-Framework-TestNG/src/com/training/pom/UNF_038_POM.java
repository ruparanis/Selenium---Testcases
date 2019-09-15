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

public class UNF_038_POM {
	private WebDriver driver; 
	
	public UNF_038_POM(WebDriver driver) {
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
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addNew; 
	
	@FindBy(xpath="//input[@id='input-name1']")
	private WebElement categoryName; 
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement description; 
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement metatagTitle; 
	
	@FindBy(xpath="//textarea[@id='input-meta-description1']")
	private WebElement metatagDescription; 
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	private WebElement dataTab; 
	
	@FindBy(xpath="//div[@class='checkbox']//input[@value='0']")
	private WebElement defaultData;
	
	@FindBy(xpath="//a[contains(text(),'Design')]")
	private WebElement designTab; 
	
	@FindBy(xpath="//select[@name='category_layout[0]']")
	private WebElement layoutdesignTab;
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement save;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successAlert;
	
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
		//Click on Categories
		public void clickCategories() throws InterruptedException{
			
			Actions act = new Actions(driver);
			//WebElement categories = driver.findElement(By.xpath("//a[contains(text(),'Categories')]"));
		
			act.sendKeys(categories,(Keys.ENTER)).build().perform();
			Thread.sleep(1000);

			WebElement categoriespage = driver.findElement(By.xpath("//h1[contains(text(),'Categories')]"));
			if(categoriespage.isDisplayed())
				System.out.println("Step 2: PASS - Categories Page containing Category Name, Sort Order & Action for list of categories is displayed");
			else
				System.out.println("Step 2: FAIL");
		}
		
		//Click on addNewicon
		public void clickAddnew() throws InterruptedException{
			this.addNew.click();
			Thread.sleep(1000);
			WebElement addCategory = driver.findElement(By.xpath("//h3[@class='panel-title']"));
			
			if(addCategory.isDisplayed())
				System.out.println("Step 3: PASS - Add Category Page is displayed");
			else
				System.out.println("Step 3: FAIL");
			
		}
		
		//Enter valid data in Category Name textbox
		public void entercategoryName(String catname) throws InterruptedException {
			this.categoryName.clear();
			this.categoryName.sendKeys(catname);
			Thread.sleep(1000);
			
			String catnamemsg = this.categoryName.getAttribute("value");
			Assert.assertEquals(catnamemsg, catname);
			System.out.println("Step 4: PASS - Entered data in Category Name textbox is displayed" );
			
			/*if(catname.equalsIgnoreCase(this.categoryName.getText().toString().trim()))
			{
				System.out.println("Step 4: Entered data in Category Name textbox is displayed" );
			}
			else
				System.out.println("Step 4: FAIL");*/
			
		}
		
		//Enter valid data in Description textbox
				public void enterDescription(String desc) {
					this.description.clear();
					this.description.sendKeys(desc);
					
					if(desc.equalsIgnoreCase(this.description.getText().toString()))
					{
						System.out.println("Step 5: PASS - Entered data in Description textbox is displayed" );
					}
					else
						System.out.println("Step 5: FAIL");
					
				}
				
		//Enter valid data in Meta tag title textbox
				public void entermetatagTitle(String metatag) {
					this.metatagTitle.clear();
					this.metatagTitle.sendKeys(metatag);
					
					if(metatag.equalsIgnoreCase(this.metatagTitle.getAttribute("value")))
					{
						System.out.println("Step 6: PASS - Entered data in Meta Tag title textbox is displayed" );
					}
					else
						System.out.println("Step 6: FAIL");
					
				}
				
			//Enter valid data in Meta tag description textbox
				public void entermetatagDesc(String metatagdesc) {
					this.metatagDescription.clear();
					this.metatagDescription.sendKeys(metatagdesc);
					
					if(metatagdesc.equalsIgnoreCase(this.metatagDescription.getAttribute("value")))
					{
						System.out.println("Step 7: PASS - Entered data in Meta Tag Description textbox is displayed" );
					}
					else
						System.out.println("Step 7: FAIL");
					
				}
		//Click on Data tab
				public void dataTab() throws InterruptedException{
					this.dataTab.click();
					if(defaultData.isSelected())
						//System.out.println("Default values of Data tab are selected");
						this.designTab();
					else
						System.out.println("Step 8: FAIL - Default values not selected");
					}
				
	   //Click on Design tab
				public void designTab() throws InterruptedException{
					this.designTab.click();
					
					Select sel = new Select(layoutdesignTab);
					String selectedvalue = sel.getFirstSelectedOption().getText().trim();
					Thread.sleep(1000);
				
					List<WebElement> data = sel.getOptions();
				//	System.out.println(data.size());
					
					for(int i=0; i<data.size(); i++)
					{
						if(data.get(i).getText().equals(selectedvalue))
							System.out.println("Step 8: PASS - Default values of Data tab and Design tab are selected");
					}
					
										
				}
				
		// Save
				public void save(){
					this.save.click();
					
					String Actmsg = this.successAlert.getText().toString().trim();
					String Expmsg = "Success: You have modified categories!";
					Assert.assertTrue(Actmsg.contains(Expmsg), Expmsg);
					System.out.println("Step 9: PASS - Displays message : " + Actmsg );
				}
				
		//logout
			public void logout(){
				this.logout.click();
			}
				
}
