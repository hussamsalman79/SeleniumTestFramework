package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class AmazonPage {
	
	// constructor using the class name 
	 public AmazonPage() {
		 PageFactory.initElements(Driver.getDriver(), this);
		 
	 }
	 
	 @FindBy(linkText = "Sign in Securely")
	 public WebElement SignInLink; 
	 
	 @FindBy(xpath ="//h1[contains(text(), 'Sign in')]")
	 public WebElement SignInText; 
	 
	 @FindBy(xpath="//input[@id = 'ap_email']")
	 public WebElement SignInPageEmail; 
	 
	 @FindBy(xpath="//input[@id = 'continue']")
	 public WebElement signInPageContinueBtn; 
	 
	 @FindBy(xpath="//a[@id = 'createAccountSubmit']")
	 public WebElement createAccountBtn; 
	 
	 @FindBy (xpath="//h1[contains(text(), 'Create account')]")
	 public WebElement CreateAccountPageText; 
	 
	 @FindBy (xpath ="//input[@id='continue']")
	 public WebElement accountPageContinueBtn; 
	 
	 @FindBy (xpath="//div[contains(text(), 'Enter your name')]")
	 public WebElement accountPage_NameErrorMessage;
	 
	 @FindBy (xpath="//div[contains(text(), 'Enter your email or mobile phone number')]")
	 public WebElement accountPage_EmailErrorMessage;
	 
	 @FindBy (xpath="//div[contains(text(), 'Minimum 6 characters required')]")
	 public WebElement accountPage_PasswordErrorMessage;
	 
	 
}
