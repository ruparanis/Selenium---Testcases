package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UFM_007_POM {
	private WebDriver driver; 
	
	public UFM_007_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//i[@class='fa fa-user']")
	private WebElement user;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	private WebElement login; 
	
	@FindBy(id="input-email")
	private WebElement email;	
		
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[contains(text(),'Change your password')]")
	private WebElement changepwdlink;
	
	@FindBy(xpath= "//input[@id='input-password']")
	private WebElement newpwd;
	
	@FindBy(xpath= "//input[@id='input-confirm']")
	private WebElement confirmpwd;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continuebtn;
	
	@FindBy(xpath="//div[@class='text-danger']")
	private WebElement pwdconfirmmsg;
	
	//Click on the User Menu
	public void usermenu(){
		this.user.click();
	}
	
	//Click on the login link
	public void login(){
		this.login.click();
	}
	
	//Enter Username
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	//Enter Password
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	//Login
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	//Click on Change Password Link
	public void clickchangepwdlink(){
		this.changepwdlink.click();
			
	}
	
	//Enter New Password
	public void sendnewPassword(String newpassword) {
		this.newpwd.clear(); 
		this.newpwd.sendKeys(newpassword); 
		if(this.newpwd.getAttribute("value").equals(newpassword))
			System.out.println("Step 2: PASS - Entered password is displayed in Password text box");
		else
		System.out.println("Step 2: FAIL");
		
	}
	
	//Enter Confirm Password
	public void sendconfirmPassword(String confirmpassword) {
			
		this.confirmpwd.clear(); 
		this.confirmpwd.sendKeys(confirmpassword); 
		
		//System.out.println(confirmpwd.getText().toString());
		if(this.confirmpwd.getAttribute("value").equals(confirmpassword))
			System.out.println("Step 3: PASS - Entered credentials displayed in Confirm Password textbox");
		else
			System.out.println("Step 3: FAIL");
	}
	
	//Click on Continue
	public void clickContinue(){
		this.continuebtn.click();
	}
	
	//Validate the Error Message
	public void pwdconfirmerrormsg() {
		String pwdmsg = this.pwdconfirmmsg.getText();
		if (pwdmsg.equals("Password confirmation does not match password!"))
		{
			System.out.println("Step 4: PASS - Error Message :" + pwdmsg + " is displayed");
		}
		else
			System.out.println("Step 4: FAIL");
}
	
}
