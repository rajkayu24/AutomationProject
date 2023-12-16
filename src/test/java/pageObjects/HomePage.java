package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);//invoke parent class constructor
	
	}
	
	//Elements 
	
	@FindBy(xpath="//span[@class='d-none d-md-inline' and text()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(xpath="//a[@class='dropdown-item' and text()='Register']")
	WebElement lnkRegister;

	@FindBy(linkText="Login")
	WebElement lnkLogin;
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchbox;
	@FindBy(xpath="//button[@class='btn btn-light btn-lg']")
	WebElement searchbtn;


	//Actions methods
	public void clickMyaccount() {
		lnkMyaccount.click();
	}
	public void clickRegister() {
		lnkRegister.click();
	}
	public void clickLogin() {
		lnkLogin.click();
	}
	public void enterProductName(String productname) {
		searchbox.sendKeys(productname);
		
	}
	public void clickSearch() {
		searchbtn.click();
		
	}

	}



