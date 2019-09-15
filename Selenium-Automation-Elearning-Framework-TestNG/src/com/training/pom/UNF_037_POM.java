package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UNF_037_POM {
	private WebDriver driver; 
	
	public UNF_037_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@id='input-username']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement alertMsg; 
		
	//Enter Username
		public void senduserName(String user) {
			this.userName.clear();
			this.userName.sendKeys(user);
			if(this.userName.getAttribute("value").equals(user))
				System.out.println("Step 1: PASS - Entered UserName is displayed in UserName text box");
			else
			System.out.println("Step 1: FAIL");
		}
	//Enter Password
		public void sendPassword(String password) {
			this.password.clear(); 
			this.password.sendKeys(password); 
			if(this.password.getAttribute("value").equals(password))
				System.out.println("Step 2: PASS - Entered password is displayed in Password text box");
			else
			System.out.println("Step 2: FAIL");
		}	
		
	//Click on the login link
	public void login(){
		this.loginBtn.click();
		String alertmsg = this.alertMsg.getText();
		if (alertmsg.contains("No match for Username and/or Password."))
		{
			System.out.println("Step 3: PASS - Error Message :" + alertmsg + " is displayed");
		}
		else
			System.out.println("Step 3: FAIL");
	}
		
}
