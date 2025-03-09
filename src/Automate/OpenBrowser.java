package Automate;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;

public class OpenBrowser {
	
	private static WebDriver driver;
	
	//Code for Google Chrome driver 
	public static WebDriver getChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\teja sree\\eclipse-workspace\\AutomateWebsite920618\\drivers\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		return driver;		
	}
	
	//Code for Microsoft Edge driver
	public static WebDriver getEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver","C:\\Users\\teja sree\\eclipse-workspace\\AutomateWebsite920618\\drivers\\msedgedriver.exe");
		driver=new EdgeDriver();
		return driver;
	}
	
	//Code for Firefox driver
	public static WebDriver getFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\teja sree\\eclipse-workspace\\AutomateWebsite920618\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		return driver;
	}

}


