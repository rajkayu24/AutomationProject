package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		
	}

	//Elements 
	@FindBy(xpath="//h1[normalize-space()='Shopping Cart (20.00kg)']")
	WebElement shoppingcartheading;
	
	@FindBy(xpath="//input[@name='quantity']")
	WebElement shopcrtpagequantity;
	
	//Actions Methods
	

	public String getshoppincartheading() {
		String shpngcrt = shoppingcartheading.getText();
		return shpngcrt;
	}
	public String getshopcartQuantity() {
		String shopQnty = shopcrtpagequantity.getText();
		
		return shopQnty;
		
	}
}
