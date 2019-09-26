package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders69;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.UNF_069_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_069Test {
	private WebDriver driver;
	private String baseUrl;
	private UNF_069_POM UNF_069_POM;
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
		UNF_069_POM = new UNF_069_POM(driver);
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


	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders69.class)
	public void loginDBTest(String userName, String password) {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
				
		UNF_069_POM.senduserName(userName);
		
		UNF_069_POM.sendPassword(password);
		UNF_069_POM.login();
		
		//screenShot.captureScreenShot(userName);

	}
	
	@Test(dependsOnMethods="loginDBTest", dataProvider = "db-productinputs", dataProviderClass = LoginDataProviders69.class)
	public void productTest(String pName, String metatitle,  String model, String price,  String quantity, String category) throws InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		
		UNF_069_POM.clickCatalog();
		UNF_069_POM.clickProducts();
		UNF_069_POM.addNew();
		UNF_069_POM.enterproductName(pName);
		UNF_069_POM.entermetatagTitle(metatitle);
		UNF_069_POM.dataTab();
		UNF_069_POM.entermodel(model);
		UNF_069_POM.enterprice(price);
		UNF_069_POM.enterquantity(quantity);
		UNF_069_POM.clickLinks();
		UNF_069_POM.clickCategorieslinks(category);
		UNF_069_POM.designTab();
		UNF_069_POM.save();
		UNF_069_POM.logout();
		
	}





}
