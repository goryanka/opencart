package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	//Elements
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myAccountLink;
	
	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	@FindBy(linkText = "Login")
	WebElement loginLink;
	
	
	//Action Methods
	public void clickMyAccountLink() {
		myAccountLink.click();
		}
	public void clickRegisterLink() {
		registerLink.click();
	}
	
	public void clickLogin() {
		loginLink.click();
	}
	
	
	
	

}
