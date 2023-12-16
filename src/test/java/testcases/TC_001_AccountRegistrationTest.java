package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

@Test
void test_account_Registration() {
	
	 logger.debug("**** Application logs ****");
	 logger.info(" **** Starting TC_001_AccountRegisterTest ****");
try {
	HomePage hp=new HomePage(driver);
	hp.clickMyaccount();
    logger.info("Clicked on Myaccount link");
	hp.clickRegister();
    logger.info("Clicked on Register link");
	
	 AccountRegistrationPage ac=new AccountRegistrationPage(driver);
	 logger.info("Providing the Customer Data");
	ac.setFirstName(randomString());
		
	ac.setLastName(randomString());
		
	ac.setEmail(randomString()+"@gmail.com");

	//ac.setTelephone(randomNumber());
	
	String password=randomAlphaNumeric();
	
	ac.setPassword(password);
		
	
	//ac.setconfirmPassword(password);
	
	ac.setNewsLetter();
	ac.setPrivacyPolicy();
	ac.clickContinue();
	logger.info("Validating Expected message");
String conmsg=ac.getConfimationmsg();
assertEquals(conmsg,"Your Account Has Been Created!" );

}catch(Exception e) {
	Assert.fail();
	 logger.info("Test Failed");
}
logger.info("****  TC_001_AccountRegisterTest completed****");


}
}
