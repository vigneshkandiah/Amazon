package AmazonPOM.pages;

import AmazonPOM.base.projectSpecificmethod;

public class AmazonShoppingCartPage extends projectSpecificmethod{
	
	public AmazonShoppingCartPage verifyProductAdded() {
		windowSwitch( 1);
		
		String productAddedMessage = driver.findElementByXPath("//h1[text() [contains (.,'Added to Cart')]]").getText();
		
		if (productAddedMessage.equals("Added to Cart"))
		{
			System.out.println(" The procuct added successfully");
		}else
		{
			System.out.println(" The product not added successfully");
		
		}
		
		return this;
		
	}
	
	public AmazonShoppingCartPage proceedToBuy() {
		driver.findElementByXPath("//a[text() [contains (.,'Proceed to Buy')]][1]").click();
		return this;
	}
	
	
	}
	


