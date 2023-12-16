package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

//Elements 
	
//@FindBy(xpath="//h2[text()='My Account']")
//WebElement msgHeading;

@FindBy(xpath="//a[text()='Account']")
WebElement breadcrumbtext;

@FindBy(linkText="Logout")
WebElement lnkLogout;

//Actions methods 
public Boolean isMyAccountPageExists() // MyAccount Page heading display status

{
	
	try {
	return (breadcrumbtext.isDisplayed());
	}catch(Exception e) {
	return (false); 
	}
}
public void clickLogout() {
	lnkLogout.click();
	
}	


}
