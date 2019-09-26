package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders68;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.UNF_068_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_068Test {
	private WebDriver driver;
	private String baseUrl;
	private UNF_068_POM UNF_068_POM;
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
		UNF_068_POM = new UNF_068_POM(driver);
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


	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders68.class)
	public void loginDBTest(String userName, String password) {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
				
		UNF_068_POM.senduserName(userName);
		
		UNF_068_POM.sendPassword(password);
		UNF_068_POM.login();
		
		//screenShot.captureScreenShot(userName);

	}
	
	@Test(dependsOnMethods="loginDBTest", dataProvider = "db-productinputs", dataProviderClass = LoginDataProviders68.class)
	public void productTest(String pName, String metatitle,  String model, String price,  String quantity, String category) throws InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		
		UNF_068_POM.clickCatalog();
		UNF_068_POM.clickProducts();
		UNF_068_POM.addNew();
		UNF_068_POM.enterproductName(pName);
		UNF_068_POM.entermetatagTitle(metatitle);
		UNF_068_POM.dataTab();
		UNF_068_POM.entermodel(model);
		UNF_068_POM.enterprice(price);
		UNF_068_POM.enterquantity(quantity);
		UNF_068_POM.clickLinks();
		UNF_068_POM.clickCategorieslinks(category);
		UNF_068_POM.designTab();
		UNF_068_POM.save();
		UNF_068_POM.logout();
		
	}



}
