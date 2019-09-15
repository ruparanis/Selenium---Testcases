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

import com.training.pom.UNF_037_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_037_Test {

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private UNF_037_POM UNF_037_POM;
	private static Properties properties;


	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	//Launch the application
	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		//loginPOM = new LoginPOM(driver);
		UNF_037_POM = new UNF_037_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	//Step 1 : Enter User Name
	
	@Test 
	public void Step1() {
		UNF_037_POM.senduserName("Rani");
		}

	//Step 2: Enter Password
	@Test (dependsOnMethods = "Step1")
	  public void Step2() {
		UNF_037_POM.sendPassword("Rani123");
	 }
	
	//Step 3: Click Login
	@Test (dependsOnMethods = "Step2")
	  public void Step3(){
		UNF_037_POM.login();
		
	  }
	
}
