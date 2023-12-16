package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_006_ProductDisplayPageTest extends BaseClass{
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
		 logger.info("verifying searched product availability");
		Assert.assertEquals(searchresult, true);
		
		sp.selectProduct("iMac");
		 logger.info("clicked on searched product");
	}
	
	@Test(priority=3)
public void test_productDispalayText() {
		ProductDisplayPage pd=new ProductDisplayPage(driver);
String productdisplayname = pd.captureProductDisplayName();
		Assert.assertEquals(productdisplayname,"iMac");
		 logger.info("verifying searched  product name in product display page");
	}
@Test(priority=4)
public void test_productbrand() {
		ProductDisplayPage pd=new ProductDisplayPage(driver);
		String actaulbrand = pd.getproductbrand();
		Assert.assertEquals(actaulbrand,"Brand: Apple");
		 logger.info("verified product band");
}
		// Brand: Apple
//Product Code: Product 14
//Availability: In Stock

@Test(priority=5)
public void test_productCode() {
		ProductDisplayPage pd=new ProductDisplayPage(driver);
		String actaulcode = pd.getproductCode();
		Assert.assertEquals(actaulcode,"Product Code: Product 14");
		 logger.info("verified product code");
}	

@Test(priority=6)
public void test_producAvail() {
		ProductDisplayPage pd=new ProductDisplayPage(driver);
		String actaulavail = pd.getproductAvail();
		Assert.assertEquals(actaulavail,"Availability: In Stock");
		 logger.info("verified product avail");
}	

@Test(priority=7)
public void test_productPrice() {
		ProductDisplayPage pd=new ProductDisplayPage(driver);
		String actaulprice = pd.getproductPrice();
		Assert.assertEquals(actaulprice,"$122.00");
		 logger.info("verified product price");
}	
@Test(priority=8)
public void test_productQuantity() throws InterruptedException {
		ProductDisplayPage pd=new ProductDisplayPage(driver);
		  pd.setproductQuantity("4");
		  logger.info("set product quantity");
		  Thread.sleep(2000);
		  pd. clickOnAddCartBtn();
		  logger.info("clicked on Addtocart button");
		 
		  pd.clickShoppingCartOption();
		  logger.info("clicked on shopping cart option");
		 
}

@Test(priority=9)
public void test_shoppingcartpageheading(){
	ShoppingCartPage  shp=new ShoppingCartPage(driver);
	
	String shpcrtpageHeading= shp.getshoppincartheading(); 
	logger.info("captured shopping cart page heading text");
	System.out.println(shpcrtpageHeading);
		
Assert.assertEquals(shpcrtpageHeading,"Shopping Cart (20.00kg)");
logger.info("verified actualheading with expected shoping cart page heading");

}

@Test(priority=10)
public void getproductQuantity() throws InterruptedException {
	ShoppingCartPage  shp=new ShoppingCartPage(driver);
	
	String  shopcrtpageQnty = shp.getshopcartQuantity();
	
	logger.info("captured quantity on shopping cart page ");
	Thread.sleep(2000);
	//System.out.println(shopcrtpageQnty);//this is anable to captur shopping cart page quantity so that why
	//this test will fail due to application problem.
	
	String expshopcrtpageQntity ="4";
	Assert.assertEquals(shopcrtpageQnty,expshopcrtpageQntity);
	logger.info("verified actual quantity  with expected quantity on shoping cart page");

	
	
	
}

}

			

