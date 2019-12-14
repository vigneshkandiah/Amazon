package AmazonPOM.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AmazonPOM.base.projectSpecificmethod;
import AmazonPOM.pages.AmazonHomePage;

public class AmazonPOCTestcase extends projectSpecificmethod {
	
	@BeforeTest
	public void setData() {
		excelFileName = "MobileName";
	}
	@Test (dataProvider = "fetchData")
	public void buyProduct(String mobileName) {
		new AmazonHomePage().searchMobile(mobileName).findFirstMobprice().clickFirstMob().getNextWindow().verifyDeliveryDate().addtocart().verifyProductAdded().proceedToBuy();
	}
	
	
	
	}


