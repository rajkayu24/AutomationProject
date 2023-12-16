package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchProductTest extends BaseClass{
	public 	SearchPage sp;
@Test(priority=0)
public void test_search() {
	logger.info(" Starting TC_003_LoginDataDrivenTest ");

HomePage hp=new HomePage(driver);

hp.enterProductName("iMac");
logger.info("Enter product name into search box");
hp.clickSearch();
logger.info(" clicked on  search button ");
}


@Test(priority=1)
public void test_searchtextheading() {
	sp=new SearchPage(driver);
	logger.info(" capturing actualText ");
	       String actualText=sp.searchText();
	       logger.info("verifying searched text");
	       
	       Assert.assertEquals(actualText,"Search - iMac");
 }


@Test(priority=2)
public void test_searchedProductname() {
	sp=new SearchPage(driver);
	boolean searchresult = sp.isProductExist("iMac");
	Assert.assertEquals(searchresult, true);
	sp.selectProduct("iMac");
}
//div[@class='description']//h4//a
}