package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Web Elements
	
	@FindBy(xpath = "//a[normalize-space()='Create free account']")
	WebElement lnkMyaccount;
	
	@FindBy(xpath = "//a[normalize-space()='SIGN IN']")
	WebElement lnkLogin;
	
	/*
	 * @FindBy(xpath = "//input[@name='email']") WebElement txtEmail;
	 * 
	 * @FindBy(xpath = "//input[@name='password']") WebElement txtPass;
	 * 
	 * @FindBy(xpath = "//button[normalize-space()='Sign In']") WebElement
	 * btnSignIn;
	 */
	
	
	// Action Methods
	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	
	public void clickSignIn() {
		lnkLogin.click();
	}
	
	/*
	 * public void setEmail(String email) { txtEmail.sendKeys(email); }
	 * 
	 * public void setPass(String pass) { txtPass.sendKeys(pass); }
	 * 
	 * public void clickLogin() { btnSignIn.click(); }
	 */

}
