package com.qa.casestudy;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Binnu
 *
 */
public class SubmitFormTest 
{
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://bootsnipp.com/login");
	}

	@Test
	public void submitLoginFormUsingClickMethod()
	{
		WebElement username = driver.findElement(By.name("email"));
		username.clear();
		username.sendKeys("binnujesudasan@gmail.com");
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("HelloWorld");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		String errorMessage  = driver.findElement(By.xpath("//*[@id=\"loginform\"]/fieldset/div[1]/h5")).getText();
		assertTrue(errorMessage.equals("E-mail or password was incorrect, please try again"));
	}
	
	@Test
	public void submitLoginFormUsingSubmitMethod()
	{
		WebElement username = driver.findElement(By.name("email"));
		username.clear();
		username.sendKeys("binnujesudasan@gmail.com");
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("HelloWorld");
		password.submit();
		String errorMessage  = driver.findElement(By.xpath("//*[@id=\"loginform\"]/fieldset/div[1]/h5")).getText();
		assertTrue(errorMessage.equals("E-mail or password was incorrect, please try again"));
	}

	@Test
	public void submitLoginFormUsingKeysEnum()
	{
		WebElement username = driver.findElement(By.name("email"));
		username.clear();
		username.sendKeys("binnujesudasan@gmail.com");
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("HelloWorld",Keys.ENTER);
		String errorMessage  = driver.findElement(By.xpath("//*[@id=\"loginform\"]/fieldset/div[1]/h5")).getText();
		assertTrue(errorMessage.equals("E-mail or password was incorrect, please try again"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}