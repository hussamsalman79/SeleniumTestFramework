package Day13_projectDesign;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AmazonPage;
import utils.Driver;
import utils.PropertiesReader;

public class firstTestNG {

	@Test
	public void AmazonTest() {
		AmazonPage amazonPage = new AmazonPage();

		// Go to amazon.com
		Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));

		// click on sign in
		// using the AmazonPage Object
		amazonPage.SignInLink.click();
		Assert.assertTrue(amazonPage.SignInText.isDisplayed());
		System.out.println("We are at the SignIn page");

		// navigate back, and navigate forward
		Driver.getDriver().navigate().back();
		Driver.getDriver().navigate().forward();

		// verify that you are on the sign in page (either by sign-in text or email
		Assert.assertTrue(amazonPage.SignInPageEmail.isDisplayed());
		System.out.println("We are at the SignIn page, 2nd time");
		
		// click on create new account
		amazonPage.createAccountBtn.click();

		// verify you are on new account create page.		
		Assert.assertTrue(amazonPage.CreateAccountPageText.isDisplayed());
		System.out.println("We are at the create accoubt page");

		// navigate back, verify you are on the sign-in page
		Driver.getDriver().navigate().back();
		Assert.assertTrue(amazonPage.SignInPageEmail.isDisplayed());
		System.out.println("We are on the signIn page, 3rd time");

		// navigate forward, verify you are on the create account page
		Driver.getDriver().navigate().forward();
		Assert.assertTrue(amazonPage.CreateAccountPageText.isDisplayed());
		System.out.println("We are at the create accoubt page, 2nd time");
		
		
		// click on the Continue button without filling the form
		amazonPage.accountPageContinueBtn.click();
		String actualNameMsg = amazonPage.accountPage_NameErrorMessage.getText().trim(); 
		Assert.assertEquals(actualNameMsg, "Enter your email");
		
		// verify error messages displayed and get text to verify
		String emailOrPhoneErrorMessage = PropertiesReader.getProperty("emailOrPhoneErrorMessage");
		String actualEmailMsg = amazonPage.accountPage_EmailErrorMessage.getText().trim(); 
		Assert.assertEquals(actualEmailMsg, emailOrPhoneErrorMessage);
		
		String PasswordMsg = PropertiesReader.getProperty("passwordErrorMessage"); 
		Assert.assertEquals(actualEmailMsg, PasswordMsg);
		

		Driver.quitDriver();

	}

}
