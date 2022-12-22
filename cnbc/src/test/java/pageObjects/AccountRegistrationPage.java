package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Elements
		
		@FindBy(xpath = "//input[@name='email']")
		WebElement txtEmail;

		@FindBy(xpath = "//input[@name='password']")
		WebElement txtPassword;

		@FindBy(xpath = "//span[@class='Checkboxes-checkmark']")
		WebElement chkdPolicy;

		@FindBy(xpath = "//button[normalize-space()='Create Free Account']")
		WebElement btnContinue;
		
		@FindBy(xpath = "//p[@class='Confirmation-text']")
		WebElement msgConfirmation;

					

		public void setEmail(String email) {
			txtEmail.sendKeys(email);

		}

		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);

		}

		public void setPrivacyPolicy() {
			chkdPolicy.click();

		}

		public void clickContinue() {
			btnContinue.click();

		}

		public String getConfirmationMsg() {
			try {
				return (msgConfirmation.getText());
			} catch (Exception e) {
				return (e.getMessage());

			}

		}
		

		
}