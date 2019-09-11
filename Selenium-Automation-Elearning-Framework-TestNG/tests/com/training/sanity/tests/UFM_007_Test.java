package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.pom.UFM_007_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UFM_007_Test {

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private UFM_007_POM UFM_007_POM;
	private static Properties properties;


	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		//loginPOM = new LoginPOM(driver);
		UFM_007_POM = new UFM_007_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void validLoginTest() {
		UFM_007_POM.usermenu();
		UFM_007_POM.login();
		UFM_007_POM.sendEmail("ruparani.s19@gmail.com");
		UFM_007_POM.sendPassword("Denny");
		UFM_007_POM.clickLoginBtn(); 
		}
	
	@Test (dependsOnMethods = "validLoginTest")
	public void Step1() {
		
		UFM_007_POM.clickchangepwdlink();
		
		String ActTitle = driver.getTitle();
		String ExpTitle = "Change Password";
		//String ExpTitle = "Your Password";
		Assert.assertEquals(ActTitle, ExpTitle);
		System.out.println("Step 1: PASS - " + ActTitle+" is displayed");
		}
	
	@Test (dependsOnMethods = "Step1")
	  public void Step2() {
		UFM_007_POM.sendnewPassword("Rani");
	 }
	
	@Test (dependsOnMethods = "Step2")
	  public void Step3(){
		UFM_007_POM.sendconfirmPassword("Rupa");
	  }
	
	@Test (dependsOnMethods = "Step3")
	  public void Step4() throws InterruptedException{
		UFM_007_POM.clickContinue();
		Thread.sleep(1000);
		UFM_007_POM.pwdconfirmerrormsg();
	  }
}
