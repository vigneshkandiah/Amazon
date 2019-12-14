package AmazonPOM.pages;

import AmazonPOM.base.projectSpecificmethod;

public class AmazonSignInpage extends projectSpecificmethod{
	
	public AmazonSignInpage clickContinue() {
		
		windowSwitch( 1);
		driver.findElementById("continue").click();
		return this;
		
	}

	public AmazonSignInpage verifyErrorMessage()
	{
String ErrorMessage = driver.findElementByXPath("//div[text() [contains (.,'Enter your')]]").getText();
		
		if (ErrorMessage.equals ("Enter your email or mobile phone number"))
		{
			System.out.println(" The Error Message displayed is:"  +ErrorMessage);
		}else {
			System.out.println("The Error message not displayed");
		}
		return this;
	}
	
}
