package AmazonPOM.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;

import AmazonPOM.base.projectSpecificmethod;

public class AmazonHomePage extends projectSpecificmethod {
	
	public AmazonHomePage searchMobile(String MobileName) {
		driver.findElementById("twotabsearchtextbox").sendKeys(MobileName,Keys.ENTER);
		return this;
		}	
	

	public AmazonHomePage findFirstMobprice() {
		String firstmobilePrice = driver.findElementByXPath("(//span[text()='9,999'])[1]").getText();
		System.out.println("Price of the First Search result:"+ firstmobilePrice);
		return this;
	}
  public AmazonHomePage clickFirstMob() {
	  
	  driver.findElementByXPath("(//span[text() [contains (., 'Samsung Galaxy M30')]])[5]").click();
	  return this;
  }
  
  public AmazonSamsungGalaxyPage getNextWindow() {
	  
	  
	  windowSwitch( 1);
		return new AmazonSamsungGalaxyPage();
	  
	  
  }



  }

