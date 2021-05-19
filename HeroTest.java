package Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class HeroTest 
{
	public static void main(String args[]) throws InterruptedException
	{	
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");	
		
		
		String downloadFilePath = "E:\\test";
        HashMap<String, Object>chromePref = new HashMap<String, Object>();
        chromePref.put("download.default_directory", downloadFilePath);
        ChromeOptions option = new ChromeOptions();
        option.setExperimentalOption("prefs", chromePref);
	    
		
		WebDriver driver;
		driver = new ChromeDriver(option);	
		driver.manage().window().maximize();	
		driver.get("http://the-internet.herokuapp.com/");
		
		//File Upload Section
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement element  = driver.findElement(By.xpath("//a[contains(.,'File Upload')]"));
		executor.executeScript("arguments[0].scrollIntoView(true);", element);    
		element.click();
		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\hp\\Pictures\\Screenshots\\download.jpg");
        Thread.sleep(4000);
        driver.findElement(By.id("file-submit")).click();
		
        //File Download with Desired Path Section        
        driver.get("http://the-internet.herokuapp.com/");		
	    driver.findElement(By.xpath("//a[contains(.,'File Download')]")).click();
	    driver.findElement(By.xpath("//a[contains(.,'newfile.xlsx')]")).click();
	    Thread.sleep(4000);
	
		//New Window Section		
	    driver.get("http://the-internet.herokuapp.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(.,'Multiple Windows')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Click Here')]")).click();
	}
}