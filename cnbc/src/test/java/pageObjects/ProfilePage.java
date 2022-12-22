package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	// Elements
	
			@FindBy(xpath = "//button[normalize-space()='MY ACCOUNT']")
			WebElement btnMyAccount;

			@FindBy(xpath = "//a[normalize-space()='Profile']")
			WebElement btnProfile;

			@FindBy(xpath = "//input[@id='firstname']")
			WebElement txtFirstName;

			@FindBy(xpath = "//input[@id='lastname']")
			WebElement txtLastName;
			
			@FindBy(xpath = "//button[normalize-space()='Save Changes']")
			WebElement btnSaveChanges;
			
			@FindBy(xpath = "//input[@name='oldPassword']")
			WebElement txtOldPassword;
			
			@FindBy(xpath = "//input[@name='newPassword']")
			WebElement txtNewPassword;
			
			@FindBy(xpath = "//input[@name='newPasswordConfirmation']")
			WebElement txtConfirmPassword;
			
			@FindBy(xpath = "//input[@name='signup']")
			WebElement btnSubmit;
			
			@FindBy(xpath = "//div[@class='ProfileForm-successMessage']")
			WebElement msgConfirmation;
			
			
			
			public void myAccount() {
				btnMyAccount.click();

			}
			
			public void profile() {
				btnProfile.click();

			}
			
				
			
			public void setFirstName(String firstname) {
				
				txtFirstName.sendKeys(firstname);

			}
			          
           
           
			public void setLastName(String lasttname) {
				
				txtLastName.sendKeys(lasttname);

			}
			
			public void saveChanges() {
				btnSaveChanges.click();

			}
			
			public void setOldPassword(String oldpassword) {
				txtOldPassword.sendKeys(oldpassword);

			}
			
			public void setNewPassword(String newpassword) {
				txtNewPassword.sendKeys(newpassword);

			}
			
			public void setConfirmPassword(String confirmpassword) {
				txtConfirmPassword.sendKeys(confirmpassword);

			}
			
			public void submit() {
				btnSubmit.click();

			}
			
			public boolean isMyAccountPageExists() {
				try {
				return(btnMyAccount.isDisplayed());
				}catch (Exception e) {
					return(false);
				}
				
			}
			
			public String getConfirmationMsg() {
				try {
					return (msgConfirmation.getText());
				} catch (Exception e) {
					return (e.getMessage());

				}

			}

}
