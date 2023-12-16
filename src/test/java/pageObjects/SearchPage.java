package pageObjects;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}	
	
		@FindBy(xpath="//*[@id='content']//div[5]//img")
		List<WebElement> searchProductslist;
		
		@FindBy(xpath="//div[@id='content']//h1")
		WebElement searchResultHeadingText;
	    
		
		@FindBy(xpath="//input[@id='input-quantity']")
		WebElement txtquantity;
		
		@FindBy(xpath="//button[@id='button-cart']")
		WebElement btnaddToCart;
		
		@FindBy(xpath="//div[contains(text(),'Success: You have added')]")
		WebElement cnfMsg;
		
		
	    //Actions methods
		
		public boolean isProductExist(String productName)
		{
			boolean flag=false;
			for(WebElement product:searchProductslist)
			{				
				if(product.getAttribute("title").equals(productName))
				{
				flag=true;
				break;
				}
			}
			
			return flag;
		
		}
		
		public void selectProduct(String productName)
		{
			for(WebElement product:searchProductslist)
			{				
				if(product.getAttribute("title").equals(productName))
				{try {
					product.click();
				}catch(Exception e){
					
				}
				}
			}
		
		}
		
		public void setQuantity(String qty)
		{
			txtquantity.clear();
			txtquantity.sendKeys(qty);
		}
		
		public void addToCart()
		{
			btnaddToCart.click();
		}
		
		public boolean checkConfMsg()
		{
			try
			{
			return cnfMsg.isDisplayed();
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		
		
		
		public String searchText() {
			return (searchResultHeadingText.getText());
		}

	
}




