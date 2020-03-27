package com.pages;


	import java.io.File;
	import java.io.IOException;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.junit.Assert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.excel.excel_utility;


	public class login_main{
		static WebDriver driver;
		excel_utility eu = new excel_utility();
	//To launch chrome browser	
		public void launchChrome(String browser)
		{
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
			driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		//To launch naukri url
		public void url() throws InterruptedException
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

		
		//To login to naukri application using valid login credentials
		public void login() throws IOException, InterruptedException
		{
			
			for(int i=1;i<=10;i++)
			{
				
			driver.findElement(By.xpath("//*[@id=\"login_Layer\"]/div")).click();
			driver.findElement(By.id("eLoginNew")).sendKeys(eu.excel_email(i));
			driver.findElement(By.id("pLogin")).sendKeys(eu.excel_password(i));
		    driver.findElement(By.xpath("//*[@id=\"lgnFrmNew\"]/div[9]/button")).click(); 
		    Thread.sleep(2000);
			screenshot("C:\\Users\\DELL\\Downloads\\anusha\\src\\test\\resources\\screenshot\\naukri.png");

			}
			driver.close();
		}
		
		//To take screenshot
		public void screenshot(String path) throws IOException
		{
			TakesScreenshot ts=((TakesScreenshot)driver);
			File Source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Source, new File(path));
		}
		
	}



