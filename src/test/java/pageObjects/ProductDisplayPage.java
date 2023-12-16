package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductDisplayPage extends BasePage{

	public ProductDisplayPage(WebDriver driver) {
		super(driver);
		
	}
//Elements 
@FindBy(xpath="//h1[text()='iMac']")
WebElement productname;

@FindBy(xpath="//div[@class='col-sm'][2]//ul[1]//li[1]")
WebElement prodbrand;

@FindBy(xpath="//div[@class='col-sm'][2]//ul[1]//li[2]")
WebElement prodCode;

@FindBy(xpath="//div[@class='col-sm'][2]//ul[1]//li[3]")
WebElement prodAvail;

@FindBy(xpath="//div[@class='col-sm'][2]//ul[2]//li[1]")
WebElement prodPrice;

@FindBy(xpath="//input[@id='input-quantity']")
WebElement prodQuantity;

@FindBy(xpath="//button[@id='button-cart']")
WebElement addcartbtn;

@FindBy(xpath="//span[normalize-space()='Shopping Cart']")
WebElement shoppingCartoption;



public String captureProductDisplayName() {
	String productnme =  productname.getText();
return productnme;
}

public String getproductbrand() {
	String prdbrand = prodbrand.getText();
	return prdbrand;
}

public String getproductCode() {
	String prdcode = prodCode.getText();
	return prdcode;
}

public String getproductAvail() {
	String prdavail = prodAvail.getText();
	return prdavail;
}

public String getproductPrice() {
	String prdprice = prodPrice.getText();
	return prdprice;
}

public void setproductQuantity(String qty) {
	 prodQuantity.clear();
	 prodQuantity.sendKeys(qty);
}

public void clickOnAddCartBtn() {
	addcartbtn.click();
}



public void clickShoppingCartOption() {
	shoppingCartoption.click();
}


}
