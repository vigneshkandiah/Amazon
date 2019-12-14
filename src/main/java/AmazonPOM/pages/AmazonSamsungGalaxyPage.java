package AmazonPOM.pages;

import AmazonPOM.base.projectSpecificmethod;

public class AmazonSamsungGalaxyPage extends projectSpecificmethod{
	
	public AmazonSamsungGalaxyPage verifyDeliveryDate() {
		
		String deliveryDate = driver.findElementByXPath("(//div[@id='ddmDeliveryMessage']//following-sibling::span)[1]").getText();
		System.out.println("The Delivery date is "+deliveryDate);
		return this;
	}
	
	public AmazonShoppingCartPage addtocart() {
		
		driver.findElementByXPath("//input[@title='Add to Shopping Cart']").click();
		windowSwitch( 1);
		return new AmazonShoppingCartPage();
	}

	
}
