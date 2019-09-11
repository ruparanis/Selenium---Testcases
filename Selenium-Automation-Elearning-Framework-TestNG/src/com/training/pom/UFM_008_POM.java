package com.training.pom;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UFM_008_POM {
	private WebDriver driver; 
	
	public UFM_008_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath = "//a[contains(text(),'REGULAR T-SHIRTS (Rust)')]")
	@FindBy(xpath = "//div[@class='image']//img[@title='REGULAR T-SHIRTS (Rust)']")
	private WebElement tshirtRust;
	
	@FindBy(xpath = "//h3[contains(text(),'REGULAR T-SHIRTS (Rust)')]")
	private WebElement tshirtRustheading;
	
	@FindBy(xpath="//select[@id='input-option376']")
	private WebElement chestsizeSelect; 
	
	@FindBy(id="button-cart")
	private WebElement addcart;	
		
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement alertsuccess; 
	
	@FindBy(xpath = "/html[1]/body[1]/nav[1]/header[1]/div[1]/div[3]/div[1]/ul[1]/li[1]/div[1]/button[1]")
	private WebElement cart;
	
	@FindBy(xpath = "//a[@href='http://uniformm1.upskills.in/index.php?route=checkout/cart']//strong")
	private WebElement viewcart;
	
	@FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
	private WebElement shoppingcart;
	
	@FindBy(xpath = "//table[@class='table table-bordered']//img[@title='REGULAR T-SHIRTS (Rust)']")
	private WebElement selecteditem;
	
	//Click on Regular TShirt
	
	public void clicktshirtRust() throws InterruptedException{
		Thread.sleep(1000);
		this.tshirtRust.click();
		Thread.sleep(3000);
		WebDriverWait mywait = new WebDriverWait(driver, 50);
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'REGULAR T-SHIRTS (Rust)')]")));
		
		if(tshirtRustheading.isDisplayed())
			System.out.println("Step 1: PASS - Complete Details of Regular Tshirt are displayed");
		else
			System.out.println("Step 1: FAIL");
		
	} 
	
	//Select Chest Size
	
	public void selectchestSize(String csize) throws InterruptedException {
		
		Select sel = new Select(chestsizeSelect);
		
		sel.selectByVisibleText(csize);
		Thread.sleep(1000);
		String selectedvalue = sel.getFirstSelectedOption().getText().trim();
		Thread.sleep(1000);
		Assert.assertEquals(selectedvalue, csize);
		System.out.println("Step 2: PASS - Chest size selected");
				
	}
	
	//Add to Cart
	
	public void addtoCart() {
		
		this.addcart.click();
		
		String Actmsg = this.alertsuccess.getText();
		String Expmsg = "Success: You have added REGULAR T-SHIRTS (Rust) to your shopping cart!";
		Assert.assertTrue(Actmsg.contains(Expmsg), Expmsg);
		System.out.println("Step 3: PASS - Displays message : " + Actmsg );
		/*if(Actmsg.contains("Success:"))
			System.out.println("Step 3: PASS - Displays message : " +Actmsg);
		else
			System.out.println("Step 3: FAIL");*/
		
		
	}
	
	//View Cart
	
	public void viewCart(){
		this.cart.click();
		this.viewcart.click();
		
		if(shoppingcart.isDisplayed())
			if(selecteditem.isDisplayed())
				System.out.println("Step 4: PASS - Product Details are displayed");
			else
				System.out.println("Step 4: FAIL");
		
	}
}
