package Day13_projectDesign;

import pages.AmazonPage;
import utils.Driver;
import utils.PropertiesReader;

public class AmazonTest {

	public static void main(String[] args) {
		
		
		// We need to create an object of AmazonPage to use the elements 
		
		AmazonPage amazonPage = new AmazonPage(); 
		
		//Go to amazon.com    
		Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));
		
		//click on sign in 
		// using the AmazonPage Object
		amazonPage.SignInLink.click();
		
		
		//verify that you are on the sign in page (either by sign-in text or email field).

		if(amazonPage.SignInText.isDisplayed()) {
			System.out.println("We are on Sign In page");
		}else {
			System.out.println("We are NOT on Sign In page");
		}
		
		//navigate back, and navigate forward
		Driver.getDriver().navigate().back();
		Driver.getDriver().navigate().forward();
		
		//verify that you are on the sign in page (either by sign-in text or email field).
		if(amazonPage.SignInPageEmail.isDisplayed()) {
			System.out.println("We are on Sign In page for 2nd time");
		}else {
			System.out.println("We are NOT on Sign In page for 2nd time");
		}
		//click on create new account
		amazonPage.createAccountBtn.click();
		
		//verify you are on new account create page.
		if (amazonPage.CreateAccountPageText.isDisplayed()) {
			System.out.println("We are on Create account page");
		}else {
			System.out.println("We are Not on Create account page");
		}
		
		//navigate back, verify you are on the sign-in page
		Driver.getDriver().navigate().back();
		if(amazonPage.SignInPageEmail.isDisplayed()) {
			System.out.println("We are on Sign In page for 3rd time");
		}else {
			System.out.println("We are NOT on Sign In page for 3rd time");
		}
		
		//navigate forward, verify you are on the create account page
		Driver.getDriver().navigate().forward();
		if (amazonPage.CreateAccountPageText.isDisplayed()) {
			System.out.println("We are on Create account page for 2md time");
		}else {
			System.out.println("We are Not on Create account page for 2nd time ");
		}
		//click on the Continue button without filling the form
		amazonPage.accountPageContinueBtn.click();
		
		//verify error messages displayed and get text to verify
		String emailOrPhoneErrorMessage= PropertiesReader.getProperty("emailOrPhoneErrorMessage"); 
		
		if (amazonPage.accountPage_EmailErrorMessage.getText().trim().equals(emailOrPhoneErrorMessage)) {
			System.out.println("Email Error message is correct");
		}else {
			System.out.println("Email Error message is not correct");
		}
		
		String passwordErrorMessage= PropertiesReader.getProperty("passwordErrorMessage"); 
		
		if (amazonPage.accountPage_PasswordErrorMessage.getText().trim().equals(passwordErrorMessage)) {
			System.out.println("passowrd Error message is correct");
		}else {
			System.out.println("passowrd message is not correct");
		}
		
		
		Driver.quitDriver();

	}

}
