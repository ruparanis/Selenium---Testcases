package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.pom.UNF_039_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_039_Test{

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private UNF_039_POM UNF_039_POM;
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
		UNF_039_POM = new UNF_039_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		
		// Launch the application
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		UNF_039_POM.logout();
		driver.quit();
	}
	
	//Valid Login as admin
	
	@Test
	public void validLoginTest() {
		UNF_039_POM.senduserName("admin");
		UNF_039_POM.sendPassword("admin@123");
		UNF_039_POM.login(); 
		}
	
	// Add category
	
	@Test (dependsOnMethods = "validLoginTest")
	public void addCategory() throws InterruptedException{
		
		UNF_039_POM.clickCatalog();
		UNF_039_POM.clickCategories();
		UNF_039_POM.clickAddnew();
		UNF_039_POM.entercategoryName("Blazers(3-5)");
		UNF_039_POM.enterDescription("Blazers for students");
		UNF_039_POM.entermetatagTitle("BLZ 03");
		UNF_039_POM.entermetatagDesc("Blazers for primary class students");
		UNF_039_POM.dataTab();
		UNF_039_POM.designTab();
		UNF_039_POM.save();
	}
	
	//Step 1: Click on Catalog icon
	@Test (dependsOnMethods = "addCategory")
	public void Step1() throws InterruptedException {
		UNF_039_POM.clickCatalogicon();
	}
	
	//Step 2: Click on Categories link
	@Test (dependsOnMethods = "Step1")
	public void Step2() throws InterruptedException {
		UNF_039_POM.clickCategorieslink();
	}
	
	//Step 3: Click on Edit icon
	@Test (dependsOnMethods = "Step2")
	public void Step3() throws InterruptedException {
		UNF_039_POM.editCategory();
	}
	
	//Step 4: Clear values on Meta Tag Title
	@Test (dependsOnMethods = "Step3")
	public void Step4() throws InterruptedException {
		UNF_039_POM.clearMetatagTitle();
	}
	
	//Step 5: Enter Meta Tag Title
	@Test (dependsOnMethods = "Step4")
	public void Step5() throws InterruptedException {
		UNF_039_POM.entervalidmetatagTitle("BLZ 05");
	}
	
	//Step 6: Enter Meta Tag Description
	@Test (dependsOnMethods = "Step5")
	public void Step6() throws InterruptedException {
		UNF_039_POM.entervalidmetatagDesc("Uniform for students");
	}
		
	//Step 7: Keep Default Data and Design Tabs
	@Test (dependsOnMethods = "Step6")
	public void Step7() throws InterruptedException {
		UNF_039_POM.defaultdataTab();
	}	
	
	//Step 8: Click Save
	@Test (dependsOnMethods = "Step7")
	public void Step8() throws InterruptedException {
			UNF_039_POM.clickSave();
	}
		
}
