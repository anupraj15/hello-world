package Actiondemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actiondemo {
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","F:\\cjc Project\\Automation testing\\software\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		//Title of web page
		String title=driver.getTitle();
		System.out.println("Title of Amazon web page is:"+title);
		//Current Url 
		String url=driver.getCurrentUrl();
		System.out.println("Current url is:"+url);
		//Number of hyperlinks on webpage
		List<WebElement> ls=driver.findElements(By.tagName("a"));
		int count=ls.size();
		System.out.println("The number of hyperlinks on webpage are:"+count);
		
		//doubleclick
		
		WebElement youramazon=driver.findElement(By.id("nav-your-amazon"));
		Actions action= new Actions(driver);
		action.doubleClick(youramazon).build().perform();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title1=driver.getTitle();
		System.out.println("title of web page is:"+title1);
		
		driver.navigate().back();
		
		//Right click
		WebElement amazonpay=driver.findElement(By.linkText("Amazon Pay"));
		Actions action1=new Actions(driver);
		Action rightclick=action1.contextClick(amazonpay).build();
		rightclick.perform();
		
		
		//MoveToElement
		Thread.sleep(5000);
		
		WebElement signin=driver.findElement(By.xpath("//span[@class='nav-line-1'][.='Hello, Sign in']"));
		//WebElement signin=driver.findElement(By.id("nav-link-yourAccount"));
		Actions action2=new Actions(driver);
		action2.moveToElement(signin).build().perform();
		//action2.perform();
			
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='nav-text'][.='Your Orders']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
		
		WebElement email=driver.findElement(By.id("ap_email"));
		
		boolean act_flag=email.isDisplayed();
		if(act_flag==true)
		{
			driver.findElement(By.id("ap_email")).sendKeys("suvidyapawaskar@gmail.com");
		}
		
		driver.navigate().back();
		driver.close();
		
		
		

	}

}


