package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	
	@Test(groups = {"Sanity","Master"})
	public void test_login() throws InterruptedException {
		
		logger.info("***Starting TC_002_LoginTest***");
	try {
		
		HomePage hPage = new HomePage(driver);
		
		hPage.clickMyAccountLink();
		logger.info("Clicked on My Account Link");
		hPage.clickLogin();
		logger.info("Clicked on Login Link");
		
		LoginPage lPage = new LoginPage(driver);
		
		lPage.setEmail(rsBundle.getString("email")); //email from config properties file
		
	    lPage.setPassword(rsBundle.getString("password"));
	    
	 // explicit wait - to wait for the login button to be click-able
	   // WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
	 // explicit wait - to wait for the login button to be click-able
	    lPage.clickLogin();
	    
	    MyAccountPage myAcc = new MyAccountPage(driver);
	    boolean target_page = myAcc.isMyAccountPageHeadingExist();
	    
	    Assert.assertEquals(target_page, true, "Invalid login data");
	
		}
		catch (Exception e) {
			
			Assert.fail();
		}
		
		logger.info("***Finished TC_002_LoginTest***");
	}
	

}
