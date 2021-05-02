package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BuyProduct {
	
	static String browser;
	static WebDriver driver;
	static WebElement element;
	
    public static void main(String []args)
    {
    	setBrowser();
    	setBrowserConfig();
    	runTest();
    	
    }
    
    public static void setBrowser() {
    	browser="Chrome";
    }
    
    public static void setBrowserConfig() {
    	if(browser.contains("Firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        	 driver = new FirefoxDriver();
    	}
    	else
    	if(browser.contains("Chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
    		 driver = new ChromeDriver();
    	}
    	
    }
    
    
    public static void runTest() {
    	// Go to site
    	driver.get("http://automationpractice.com/");
    	String actualTitle = driver.getTitle();
    	
    	// Site Title
    	System.out.println(actualTitle);
    	
    	if(actualTitle.contentEquals("My Store"))
    	{
    		System.out.println("Test Passed");
    		
    		// Select category Woman
        	driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
       
        	// Select Product
        	driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")).click();
        	// Refresh
        	driver.navigate().refresh();
        	// View my shopping cart
        	driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/b")).click();
        	// Proceed to checkout
        	driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
        	// Login
        	driver.findElement(By.id("email")).sendKeys("informatica.live@gmail.com");
        	driver.findElement(By.id("passwd")).sendKeys("password");
        	driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        	
        	// Proceed to checkout
        	driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();
        	
        	//Select Terms of service
        	driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
        	// Proceed to checkout
        	driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
        	
        	//Pay by bank wire
        	driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
        	
        	// I confirm my order
        	driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
        	
        	// Verify if my order is complete
        	String confirmation = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText();
        	
        	if (confirmation.equals("Your order on My Store is complete."))
        	{
        		System.out.println("Test Passed");
        	}
        	else
        		System.out.println("Test Failed");
        	
        	driver.close();
    	}
    	else
    		System.out.println("Test Failed");
    }
    
}
