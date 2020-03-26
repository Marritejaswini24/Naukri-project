package com.pages;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class filter_main {
	static WebDriver driver;
	
	public void launchChrome(String browser)
	{
		//To launch chrome browser
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\anusha\\src\\test\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		//To launch firefox browser
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.geckodriver.driver","C:\\Users\\DELL\\Downloads\\anusha\\src\\test\\resources\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	//To launch naukri url
	public void url()
	{
		driver.get("https://www.naukri.com/");
		String windowTitle= getCurrentWindowTitle();
		String mainWindow = getMainWindowHandle(driver);
		Assert.assertTrue(closeAllOtherWindows(mainWindow));
		Assert.assertTrue(windowTitle.contains("Jobs - Recruitment"));
	}
		
	public String getMainWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}
	
	//To close all the other windows except the main window.
	public static boolean closeAllOtherWindows(String openWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				driver.close();
			}
		}
		
		driver.switchTo().window(openWindowHandle);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}
	//To login to the naukri application
	public void login() throws IOException
	{   
        driver.findElement(By.xpath("//*[@id=\"login_Layer\"]/div")).click();
		driver.findElement(By.id("eLoginNew")).sendKeys("tejaswini.m481@gmail.com");
		driver.findElement(By.id("pLogin")).sendKeys("tejaswini@24");
		driver.findElement(By.xpath("//*[@id=\"lgnFrmNew\"]/div[9]/button")).click();
	}
	//To search for a job according to filter option
	public void search_job() throws InterruptedException {
		
	    driver.findElement(By.xpath("//*[@id=\"qsb-keyskill-sugg\"]")).sendKeys("dbms");
	    driver.findElement(By.xpath("//*[@id=\"qsb-location-sugg\"]")).sendKeys("chennai");
		driver.findElement(By.xpath("//*[@id=\"search-jobs\"]/button")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/section[1]/div[2]/div[2]/div[2]/div[1]/label/i")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/section[1]/div[2]/div[1]/div[2]/div[2]/label/i")).click();
		Thread.sleep(8000);
			
		driver.close();
		
	}
}

