package testpackage;

import org.testng.annotations.Test;

import basepackage.BaseClass;
import objectpackage.HomePage;
import objectpackage.LearningPage;

public class TC_002_LearningTest extends BaseClass {

	@Test(priority=1)
	public void test_learning()
	{
		logger.info("Starting TC_002_LearningTest");
		logger.info("Choosing Learning Tab");
		HomePage homePage = new HomePage(driver);
		homePage.learningTab();
	}
	
	@Test(priority=2)
	public void test_signin()
	{
		logger.info("Sign in");
		LearningPage learningPage = new LearningPage(driver);
		learningPage.signIn();
		learningPage.fillEmail(randomAlphaNumeric()+"@gmail.com");
		learningPage.fillPassword(randomAlphaNumeric());
		
		logger.info("Click submit");
		learningPage.submit();
		logger.info("Capturing the error....");
		learningPage.captureError();
		
		logger.info("Error Captured");
		logger.info("***** Execution Completed *****");
	}
	
}
