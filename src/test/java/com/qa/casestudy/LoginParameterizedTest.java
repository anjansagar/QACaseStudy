package com.qa.casestudy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	public void testLogin(String username, String password) {
		WebElement uname = driver.findElement(By.name("email"));
		uname.clear();
		uname.sendKeys(username);
		WebElement pword = driver.findElement(By.name("password"));
		pword.clear();
		pword.sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Login']")).click();
	}

	@DataProvider
	public Object[][] testData(){
		Object[][] testCredentials = new Object[][]{
			{"binnujesudasan@gmail.com","HelloWorld"}}; 
			return testCredentials;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}