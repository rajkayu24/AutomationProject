package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_005_Adv_searchTest extends BaseClass{
public SearchPage sp;

@Test(priority=0)
public void test_search() {
logger.info(" Starting TC_003_LoginDataDrivenTest ");

HomePage hp=new HomePage(driver);

hp.enterProductName("MacBook Air");
logger.info("Enter product name into search box");
hp.clickSearch();
logger.info(" clicked on  search button ");
}



@Test(priority=1)
	public void test_searchtextheading() {
		sp=new SearchPage(driver);
		logger.info(" capturing actualText ");
		       String actualText=sp.searchText();
		       logger.info(" verifying searched text");
		       Assert.assertEquals(actualText,"Search - MacBook Air");
	 }

@Test(priority=2)
public void test_searchedProductname() {
	sp=new SearchPage(driver);
	  
	boolean searchresult = sp.isProductExist("MacBook Air");
	 logger.info(" checked searched product exist or not");
	  System.out.println(searchresult);
	Assert.assertEquals(searchresult, true);
	 logger.info(" verifying searchresult ");
	     sp.selectProduct("MacBook Air");
	 logger.info(" selected produtct and clicked ");
}
}
