package testcases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_007_AddToCartPageTest extends BaseClass{

	public 	SearchPage sp;
	@Test(priority=0)
	public void test_search() {
		logger.info(" Starting TC_006_ProductDisplayPageTest ");

		HomePage hp=new HomePage(driver);

		hp.enterProductName("iMac");
		logger.info("Enter product name into search box");
		hp.clickSearch();
		logger.info(" clicked on  search button ");
		}

	
	
}
