package POC;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyProduct {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver ();
		driver.get("http://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("twotabsearchtextbox").sendKeys("Samsung Galaxy M30",Keys.ENTER);
		String firstmobilePrice = driver.findElementByXPath("(//span[text()='9,999'])[1]").getText();
		System.out.println("Price of the First Search result:"+ firstmobilePrice);
		driver.findElementByXPath("(//span[text() [contains (., 'Samsung Galaxy M30')]])[5]").click();
		Set<String> allWindowsSet= driver.getWindowHandles();
		List<String> windowsList= new ArrayList<String>();
		windowsList.addAll(allWindowsSet);
		driver.switchTo().window(windowsList.get(1));
		
		String deliveryDate = driver.findElementByXPath("(//div[@id='ddmDeliveryMessage']//following-sibling::span)[1]").getText();
		System.out.println("The Delivery date is "+deliveryDate);
		
		driver.findElementByXPath("//input[@title='Add to Shopping Cart']").click();
		
		driver.switchTo().window(windowsList.get(1));
		
		String productAddedMessage = driver.findElementByXPath("//h1[text() [contains (.,'Added to Cart')]]").getText();
		
		if (productAddedMessage.equals("Added to Cart"))
		{
			System.out.println(" The procuct added successfully");
		}else
		{
			System.out.println(" The product not added successfully");
		
		}
		
		driver.findElementByXPath("//a[text() [contains (.,'Proceed to Buy')]][1]").click();
		driver.switchTo().window(windowsList.get(1));
		driver.findElementById("continue").click();
		String ErrorMessage = driver.findElementByXPath("//div[text() [contains (.,'Enter your')]]").getText();
		
		if (ErrorMessage.equals ("Enter your email or mobile phone number"))
		{
			System.out.println(" The Error Message displayed is:"  +ErrorMessage);
		}else {
			System.out.println("The Error message not displayed");
		}
	}

}
