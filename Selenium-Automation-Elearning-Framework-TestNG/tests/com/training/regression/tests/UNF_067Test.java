package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.UNF_067_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_067Test {
	private WebDriver driver;
	private String baseUrl;
	private UNF_067_POM UNF_067_POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		UNF_067_POM = new UNF_067_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password) {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
				
		UNF_067_POM.senduserName(userName);
		
		UNF_067_POM.sendPassword(password);
		UNF_067_POM.login();
		
		//screenShot.captureScreenShot(userName);

	}
	
	@Test(dependsOnMethods="loginDBTest", dataProvider = "db-productinputs", dataProviderClass = LoginDataProviders.class)
	public void productTest(String pName, String price, String status, String model, String quantity) throws InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		
		UNF_067_POM.clickCatalog();
		UNF_067_POM.clickProducts();
		UNF_067_POM.enterproductName(pName);
		UNF_067_POM.enterprice(price);
		UNF_067_POM.filter5();
		UNF_067_POM.selectStatus(status);
		UNF_067_POM.entermodel(model);
		UNF_067_POM.enterquantity(quantity);
		UNF_067_POM.filter();
		UNF_067_POM.logout();
		//screenShot.captureScreenShot(userName);

	}

}
