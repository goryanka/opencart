package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(id = "input-email")
	WebElement txtEmailLogin;
	
	@FindBy(xpath  = "//input[@id='input-password']")
	WebElement txtPasswordLogin;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnLogin;
	
	
	public void setEmail(String email) {
		txtEmailLogin.sendKeys(email);
		
	}
	public void setPassword(String password) {
		txtPasswordLogin.sendKeys(password);
		
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
