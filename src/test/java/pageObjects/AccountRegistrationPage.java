package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	//constructor
	public AccountRegistrationPage(WebDriver driver) {
	 super(driver);//here we got the driver instance 
	 //and we are passing it to the super class constructor   	
	}


	//elements 

	@FindBy(id="input-firstname")
	WebElement txtFirstname;

	@FindBy(id="input-lastname")
	WebElement txtLastname;

	@FindBy(id="input-email")
	WebElement txtEmail;

	@FindBy(id="input-telephone")
	WebElement txtTelephone;


	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(id="input-confirm")
	WebElement txtconfirmPassword;

	@FindBy(xpath="//input[@id='input-newsletter']")
	WebElement txtNewsletter;

	@FindBy(name="agree")
	WebElement chkPolicy;

	@FindBy(xpath="//button[@class='btn btn-primary' and text()='Continue']")
	WebElement continuebtn;
	////h1[normalize-space()='Your Account Has Been Created!']
	@FindBy(xpath="//div[@id='content']//h1[text()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	//Action methods
	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}
	public void setLastName(String lname) {
		 txtLastname.sendKeys(lname);	
	}
	public void setEmail(String email) {
		 txtEmail.sendKeys(email);
	}

	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);

	}
	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);
		
	}
	public void setconfirmPassword(String pass) {
		txtconfirmPassword.sendKeys(pass);
	}
	public void setNewsLetter() {
		txtNewsletter.click();
	}
	public void setPrivacyPolicy() {
		chkPolicy.click();
	}
	public void clickContinue() {
		 continuebtn.click();
	}

	public String getConfimationmsg() {
		try {
			return msgConfirmation.getText();	
			}catch(Exception e) {
				return e.getMessage();
				
			}
		}
		
	}


