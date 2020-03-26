package com.pages;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class more_main {
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
	//To select on more and move to another field
	public void more() throws InterruptedException
	{
		WebElement a =driver.findElement(By.xpath("/html/body/div[1]/div/div/ul[1]/li[6]/a/div"));
		WebElement b =driver.findElement(By.xpath("/html/body/div[1]/div/div/ul[1]/li[6]/div/ul[1]/li[6]/a"));
		Actions act = new Actions(driver);
		act.moveToElement(a);
		act.moveToElement(b).click().build().perform();
		Thread.sleep(4000);
		driver.close();
	}
}

