package com.qa.casestudy;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginParameterizedTest {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://bootsnipp.com/login");
	}

	@Test(dataProvider="testData")
	public void testLogin(String username, String password, String errorMessage) {
		String title = driver.getTitle();
		Assert.assertTrue(title.equals("Login to free code playground for Bootstrap"), "Assert for page Title");
		WebElement uname = driver.findElement(By.name("email"));
		uname.clear();
		uname.sendKeys(username);
		WebElement pword = driver.findElement(By.name("password"));
		pword.clear();
		pword.sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		
		if(!(errorMessage.equals("")) && driver.findElement(By.xpath("//*[@id=\"loginform\"]/fieldset/div[1]/h5")).isDisplayed()) {
			assertTrue(errorMessage.equals(driver.findElement(By.xpath("//*[@id=\"loginform\"]/fieldset/div[1]/h5")).getText()));
		}
	}
   
	/**
	 * 
	 * Provides all the combinations of credentials
	 * Only "binnujesudasan@gmail.com","123@xyz", "" is the valid credential combination
	 */
	@DataProvider
	public Object[][] testData(){
		Object[][] testCredentials = new Object[][]{
			{"binnujesudasan@gmail.com","HelloWorld","E-mail or password was incorrect, please try again"},
			{"binnujesudasan1@gmail.com","HelloWorld","E-mail or password was incorrect, please try again"},
			{"binnujesudasan1@gmail.com","abc@xyz","E-mail or password was incorrect, please try again"},
			{"binnujesudasan@gmail.com","123@xyz",""}, 
			{"","","E-mail or password was incorrect, please try again"}, 
			{"","123@xyz","E-mail or password was incorrect, please try again"},
			{"binnujesudasan@gmail.com","","E-mail or password was incorrect, please try again"}}; 
			return testCredentials;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}