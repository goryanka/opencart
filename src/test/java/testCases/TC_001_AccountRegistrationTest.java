package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"Regression", "Master"})
	void test_account_Registration() throws InterruptedException 
	{
		logger.debug("Application bugs");
		logger.info("***Starting TC_001_AccountRegistrationTest***");
		try {
		 HomePage hPage = new HomePage(driver);
		 
		 hPage.clickMyAccountLink();
		 logger.info("Clicked on My Account Link");
		 
		 hPage.clickRegisterLink();	
		 logger.info("Clicked on Register Link");
		
		 AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
		 logger.info("Providing Customer data");
			
		 registrationPage.setFirstName(randomString().toUpperCase());
			
		 registrationPage.setLastName(randomString().toUpperCase());
			
		 registrationPage.setEmail(randomString() + "@gmail.com"); //randomly generated the email
			
		 registrationPage.setPhone(randomNumber());
		 
		 String password = randomAlphaNumeric();
		 registrationPage.setPassword(password);
		 registrationPage.setpasswordConfirm(password);
		
		 registrationPage.clickPrivacyPolicy();
			
		 registrationPage.clickContinue();
		 logger.info("Clicked on Continue");
			
		 String confirmMsg= registrationPage.getConfirmationMsg();
		 logger.info("Validating Expected Message");
		 Assert.assertEquals(confirmMsg, "Your Account Has Been Created!", "Not getting expected message");
		}
		catch (Exception e) {
			
			logger.error("Test failed");
			Assert.fail();
		}
		 logger.info("***Finished Testing***");
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
