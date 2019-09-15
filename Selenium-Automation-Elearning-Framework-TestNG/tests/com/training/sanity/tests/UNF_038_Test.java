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

import com.training.pom.UNF_038_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_038_Test {

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private UNF_038_POM UNF_038_POM;
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
		UNF_038_POM = new UNF_038_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		
		// Launch the application
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		UNF_038_POM.logout();
		driver.quit();
	}
	
	//Valid Login as admin
	
	@Test
	public void validLoginTest() {
		UNF_038_POM.senduserName("admin");
		UNF_038_POM.sendPassword("admin@123");
		UNF_038_POM.login(); 
		}
	
	//Step 1 : Click on Catalog icon
	
	@Test (dependsOnMethods = "validLoginTest")
	public void Step1() throws InterruptedException {
		
		UNF_038_POM.clickCatalog();
				}
	//Step 2: Click on Categories 
		@Test (dependsOnMethods = "Step1")
		  public void Step2() throws InterruptedException {
			UNF_038_POM.clickCategories();
			}
		
	//Step 3: Click on Add new icon
		@Test (dependsOnMethods = "Step2")
		  public void Step3() throws InterruptedException{
			UNF_038_POM.clickAddnew();
		  }
	//Step 4: Enter Category Name
		@Test (dependsOnMethods = "Step3")
		  public void Step4() throws InterruptedException{
			UNF_038_POM.entercategoryName("Blazers(3-5)");
		  }
	//Step 5: Enter Description
		@Test (dependsOnMethods = "Step4")
		public void Step5() throws InterruptedException{
			UNF_038_POM.enterDescription("Blazers for students");
		 }
	//Step 6: Enter Meta Tag Title
		@Test (dependsOnMethods = "Step5")
		public void Step6() throws InterruptedException{
			UNF_038_POM.entermetatagTitle("BLZ 03");
		 }	
	//Step 7: Enter Meta Tag Description
		@Test (dependsOnMethods = "Step6")
		public void Step7() throws InterruptedException{
			UNF_038_POM.entermetatagDesc("Blazers for primary class students");
		 }	
		
	//Step 8: Keep Data and Design tab values default
		@Test (dependsOnMethods = "Step7")
		public void Step8() throws InterruptedException{
			UNF_038_POM.dataTab();
		//	UNF_038_POM.designTab();
		}	
		
	//Step 9: Save
		@Test (dependsOnMethods = "Step8")
		public void Step9() throws InterruptedException{
			UNF_038_POM.save();
		}	
					
		
		
}
