package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	//driver var
	public WebDriver driver;
	
	//constructor
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);//this method will make available  driver instance to all the webelements
	}
}
