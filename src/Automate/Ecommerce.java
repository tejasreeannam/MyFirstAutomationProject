package Automate;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecommerce 
{
	static WebDriver driver;
	String baseURL="http://automationpractice.com/index.php",message;
	int choice;	
	static String data[] = null;	
	
	
		public void selectBrowser() 
		{   
			System.out.println("Select the browser number:  1.Google Chrome  2.Microsoft Edge 3.Firefox");
			try (Scanner sc = new Scanner(System.in))
			{
			int choice=sc.nextInt();
			if(choice==1)
			{
				System.out.println("Google Chrome");
				driver=OpenBrowser.getChromeBrowser();
			}
			else if(choice==2)
			{
				System.out.println("Microsoft Edge");
				driver=OpenBrowser.getEdgeBrowser();
			}
			else if(choice==3)
			{
				System.out.println("Firefox");
				driver=OpenBrowser.getFirefoxBrowser();
			}
			else
			{
				System.out.println("Enter a valid choice (1 or 2 or 3)");
				
			}
		}catch(Exception e)
		 {
			e.printStackTrace();
		 }
	}	
	
	
	public WebDriver launchUrl()
	{
		driver.manage().window().maximize();
		
		driver.get(baseURL);
		return driver;
	}
	
	
	public void newUserLogin()
	{
		driver.findElement(By.className("login")).click();
		
		driver.findElement(By.id("email_create")).sendKeys("tejasreereddy507@gmail.com");
		
		driver.findElement(By.name("SubmitCreate")).click();
	}
	
	public void setFormValues()
	{
		String gender="Miss";
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 if (gender=="Mr")
		{
		 	driver.findElement(By.cssSelector("#id_gender1")).click();
		}
		else
		{
		 	driver.findElement(By.cssSelector("#id_gender2")).click();
		}
			
		driver.findElement(By.name("customer_firstname")).sendKeys("Annam");
		
		driver.findElement(By.name("customer_lastname")).sendKeys("Tejasree");
		
		driver.findElement(By.name("passwd")).sendKeys("123456");
		
	    Select select1=new Select(driver.findElement(By.name("days")));
		select1.selectByValue("13");
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		Select select2=new Select(driver.findElement(By.id("months")));
		select2.selectByValue("8");
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		Select select3=new Select(driver.findElement(By.name("years")));
		select3.selectByValue("1999");
		
		driver.findElement(By.name("company")).sendKeys("CTS");
		
		driver.findElement(By.name("address1")).sendKeys("4/32/a,new maruthinagar");
		driver.findElement(By.name("address2")).sendKeys("thirumala Residency");
		
		driver.findElement(By.name("city")).sendKeys("Hyderabad");
		
		Select select4=new Select(driver.findElement(By.name("id_state")));
		select4.selectByVisibleText("Alabama");
		
		driver.findElement(By.name("postcode")).sendKeys("54321");
		
		driver.findElement(By.name("other")).sendKeys("Testing the website");
		
	    driver.findElement(By.name("phone")).sendKeys("7997191189");
	    driver.findElement(By.name("phone_mobile")).sendKeys("9010536903");  
	}
	
	public void registerAccount()
	{
		driver.findElement(By.name("submitAccount")).click();
		
		driver.findElement(By.className("info-account")).getText();
		System.out.println("\nNew User account is created");
	}
	
	public void selectProduct()
	{
		Actions action=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver,60);
	
		WebElement findStyle = driver.findElement(By.xpath("//a[@title='Women']"));		
		action.moveToElement(findStyle).build().perform();
		WebElement findTshirt=driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
		wait.until(ExpectedConditions.elementToBeClickable(findTshirt));
		findTshirt.click();

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		WebElement findProduct=driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]"));
	
		
		WebElement findMore=driver.findElement(By.xpath("//span[contains(text(),'More')]"));
		action.moveToElement(findProduct).click(findMore).build().perform();	
	
		driver.findElement(By.xpath("//a[@class='btn btn-default button-plus product_quantity_up']")).click();
		
		Select select5=new Select(driver.findElement(By.name("group_1")));
		
		
		select5.selectByVisibleText("L");
		
		
		driver.findElement((By.id("color_14"))).click();
		
	
		driver.findElement(By.name("Submit")).click();
			
		WebElement proceed=driver.findElement(By.cssSelector("a[title='Proceed to checkout'] span"));	
		wait.until(ExpectedConditions.elementToBeClickable(proceed));
		proceed.click();
		
		driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']")).click();		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);		
		
		
		driver.findElement(By.name("processAddress")).click();		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);		
		driver.findElement(By.name("cgv")).click();
		
		
		driver.findElement(By.name("processCarrier")).click();		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);

		
		System.out.println("\nPayment Options: \n 1) Pay by bank wire  2) Pay by check");	
		
		
		if("Pay by bank wire".equalsIgnoreCase("Pay by bank wire"))
		 {
			System.out.println("\nPaying by bank wire...");
			
			
			driver.findElement(By.xpath("//a[@title='Pay by bank wire']")).click();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//span[normalize-space()='I confirm my order']")).click();
			
			message=driver.findElement(By.xpath("//strong[contains(text(),'complete')]")).getText();
			System.out.println("\n"+message);
		 }
		else
		 {
			System.out.println("\nPaying by check...");
			
			driver.findElement(By.xpath("//a[@title='Pay by check.']")).click();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//span[normalize-space()='I confirm my order']")).click();
			
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
			message=driver.findElement(By.xpath("//p[contains(text(),'complete')]")).getText();
			System.out.println("\n"+message);
		}
	}
	
	//Close the browser
	public void closeBrowser()
	{
		driver.close();
	}
		
	public static void main(String[] args) throws IOException 
	{
		Ecommerce ecommerce=new Ecommerce();
		ecommerce.selectBrowser();
		ecommerce.launchUrl();	
		ecommerce.newUserLogin();
		ecommerce.setFormValues();				
		ecommerce.registerAccount();		
		ecommerce.selectProduct();
		ecommerce.closeBrowser();
		System.out.println("\nTest case successfull ");
	}
}
