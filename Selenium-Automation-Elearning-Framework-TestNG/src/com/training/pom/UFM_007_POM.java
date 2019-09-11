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
	
	public void usermenu(){
		this.user.click();
	}
	
	public void login(){
		this.login.click();
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	public void clickchangepwdlink(){
		this.changepwdlink.click();
			
	}
	
	public void sendnewPassword(String newpassword) {
		this.newpwd.clear(); 
		this.newpwd.sendKeys(newpassword); 
		if(this.newpwd.getAttribute("value").equals(newpassword))
			System.out.println("Step 2: PASS - Entered password is displayed in Password text box");
		else
		System.out.println("Step 2: FAIL");
		
	}
	
	public void sendconfirmPassword(String confirmpassword) {
			
		this.confirmpwd.clear(); 
		this.confirmpwd.sendKeys(confirmpassword); 
		
		//System.out.println(confirmpwd.getText().toString());
		if(this.confirmpwd.getAttribute("value").equals(confirmpassword))
			System.out.println("Step 3: PASS - Entered credentials displayed in Confirm Password textbox");
		else
			System.out.println("Step 3: FAIL");
	}
	
	public void clickContinue(){
		this.continuebtn.click();
	}
	
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
