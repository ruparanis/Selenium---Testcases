package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.pom.UFM_008_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UFM_008_Test {

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private UFM_008_POM UFM_008_POM;
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
		UFM_008_POM = new UFM_008_POM(driver);
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
	public void Step1() throws InterruptedException {
				UFM_008_POM.clicktshirtRust();
				}
	
	@Test (dependsOnMethods = "Step1")
	public void Step2() throws InterruptedException {
		UFM_008_POM.selectchestSize("42");
	}

	@Test (dependsOnMethods = "Step2") 
	public void Step3() {
		UFM_008_POM.addtoCart();
	}
	
	@Test (dependsOnMethods = "Step3")
	public void Step4() {
		UFM_008_POM.viewCart();
	}

}
