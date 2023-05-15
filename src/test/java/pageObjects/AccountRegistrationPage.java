package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	//Elemnents
	
	@FindBy(name = "firstname")
	WebElement txtFirstName;
	
	@FindBy(name = "lastname")
	WebElement txtLastName;
	
	@FindBy(name = "email")
	WebElement txtEmail;
	
	@FindBy(name = "telephone")
	WebElement txtPhone;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(name = "confirm")
	WebElement txtPasswordConfirm;

	@FindBy(name ="agree")
	WebElement chkPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	
	//Action Methods
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
		
	}
	
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPhone(String phoneNum) {
		txtPhone.sendKeys(phoneNum);
	}
	
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void setpasswordConfirm(String passConfirm) {
		txtPasswordConfirm.sendKeys(passConfirm);
	}
	public void clickPrivacyPolicy() {
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(chkPolicy)).click();
		chkPolicy.click();
		
	}
	
	public void clickContinue() {
		btnContinue.click();;
	}
	
	public String getConfirmationMsg() {
		
		try {
			return(msgConfirmation.getText());
		}
		catch (Exception e) {
			return(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
