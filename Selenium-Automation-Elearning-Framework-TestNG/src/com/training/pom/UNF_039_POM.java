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

public class UNF_039_POM {
	private WebDriver driver; 
	
	public UNF_039_POM(WebDriver driver) {
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
	
	@FindBy(xpath="	//tbody//tr[1]//td[4]//a[1]")
	private WebElement edit;
	
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
			
			}
		//Click on Categories
		public void clickCategories() throws InterruptedException{
			
			Actions act = new Actions(driver);
			//WebElement categories = driver.findElement(By.xpath("//a[contains(text(),'Categories')]"));
		
			act.sendKeys(categories,(Keys.ENTER)).build().perform();
			Thread.sleep(1000);

			}
		
		//Click on addNewicon
		public void clickAddnew() throws InterruptedException{
			this.addNew.click();
			Thread.sleep(1000);
			}
		
		//Enter valid data in Category Name text box
		public void entercategoryName(String catname) throws InterruptedException {
			this.categoryName.clear();
			this.categoryName.sendKeys(catname);
			Thread.sleep(1000);
			
			}
		
		//Enter valid data in Description text box
				public void enterDescription(String desc) {
					this.description.clear();
					this.description.sendKeys(desc);
					
					}
				
		//Enter valid data in Meta tag title text box
				public void entermetatagTitle(String metatag) {
					this.metatagTitle.clear();
					this.metatagTitle.sendKeys(metatag);
					
					}
				
			//Enter valid data in Meta tag description text box
				public void entermetatagDesc(String metatagdesc) {
					this.metatagDescription.clear();
					this.metatagDescription.sendKeys(metatagdesc);
					
				}
		//Click on Data tab
				public void dataTab() {
					this.dataTab.click();
					}
				
	   //Click on Design tab
				public void designTab() {
					this.designTab.click();
														
				}
				
		// Save
				public void save(){
					this.save.click();
				}
				
		//Click on Catalog icon
		public void clickCatalogicon() throws InterruptedException{
			Actions act = new Actions(driver);
					
			act.sendKeys(catalog, (Keys.ENTER)).build().perform();
			Thread.sleep(1000);
				if(categories.isDisplayed()){
						System.out.println("Step 1: PASS - Categories, Products, Recurring Profiles, Filters, Attributes, Option links are displayed");
					}
					else
						System.out.println("Step 1: FAIL");
					
			}
		//Click on Categories link
		public void clickCategorieslink() throws InterruptedException{
					
				Actions act = new Actions(driver);
							
				act.sendKeys(categories,(Keys.ENTER)).build().perform();
				Thread.sleep(1000);

				WebElement categoriespage = driver.findElement(By.xpath("//h1[contains(text(),'Categories')]"));
					if(categoriespage.isDisplayed())
						System.out.println("Step 2: PASS - Categories Page containing Category Name, Sort Order & Action for list of categories is displayed");
					else
						System.out.println("Step 2: FAIL");
				}
				
		//Click on edit
				public void editCategory() throws InterruptedException{
					this.edit.click();
					Thread.sleep(1000);
					WebElement editCategory = driver.findElement(By.xpath("//h3[@class='panel-title']"));
					
					if(editCategory.isDisplayed())
						System.out.println("Step 3: PASS - Edit Category Page is displayed");
					else
						System.out.println("Step 3: FAIL");
					
				}
				
		//Clear values on Meta Tag Title Text box
				public void clearMetatagTitle() throws InterruptedException {
					this.metatagTitle.clear();
					Thread.sleep(1000);
					
					if(this.metatagTitle.getAttribute("value").isEmpty())
					{
						System.out.println("Step 4: PASS - Cleared data in Meta Tag title textbox is displayed" );
					}
					else
						System.out.println("Step 4: FAIL");
				}
				
	  //Enter Values on Meta Tag Title Text box
				public void entervalidmetatagTitle(String metatag) {
					this.metatagTitle.clear();
					this.metatagTitle.sendKeys(metatag);
					
					if(metatag.equalsIgnoreCase(this.metatagTitle.getAttribute("value")))
					{
						System.out.println("Step 5: PASS - Entered data in Meta Tag title textbox is displayed" );
					}
					else
						System.out.println("Step 5: FAIL");
					
				}
				
	//Enter valid data in Meta tag description textbox
				public void entervalidmetatagDesc(String metatagdesc) {
					this.metatagDescription.clear();
					this.metatagDescription.sendKeys(metatagdesc);
					
					if(metatagdesc.equalsIgnoreCase(this.metatagDescription.getAttribute("value")))
					{
						System.out.println("Step 6: PASS - Entered data in Meta Tag Description textbox is displayed" );
					}
					else
						System.out.println("Step 6: FAIL");
					
				}
	//Click on Data tab
		public void defaultdataTab() throws InterruptedException{
					this.dataTab.click();
					if(defaultData.isSelected())
						//System.out.println("Default values of Data tab are selected");
						this.defaultdesignTab();
					else
						System.out.println("Step 7: FAIL - Default values not selected");
					}
				
	//Click on Design tab
		public void defaultdesignTab() throws InterruptedException{
					this.designTab.click();
					
					Select sel = new Select(layoutdesignTab);
					String selectedvalue = sel.getFirstSelectedOption().getText().trim();
					Thread.sleep(1000);
				
					List<WebElement> data = sel.getOptions();
				//	System.out.println(data.size());
					
					for(int i=0; i<data.size(); i++)
					{
						if(data.get(i).getText().equals(selectedvalue))
							System.out.println("Step 7: PASS - Default values of Data tab and Design tab are selected");
					}
					
										
				}
				
	// Save
				public void clickSave(){
					this.save.click();
					
					String Actmsg = this.successAlert.getText().toString().trim();
					String Expmsg = "Success: You have modified categories!";
					Assert.assertTrue(Actmsg.contains(Expmsg), Expmsg);
					System.out.println("Step 8: PASS - Displays message : " + Actmsg );
				}
				
	//logout
				public void logout(){
					this.logout.click();
				}
				
}
