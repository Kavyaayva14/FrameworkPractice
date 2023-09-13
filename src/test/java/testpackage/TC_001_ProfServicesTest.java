package testpackage;

import org.testng.annotations.Test;

import basepackage.BaseClass;
import objectpackage.HomePage;
import objectpackage.FillFormPage;
import objectpackage.DataDrivenTest;

public class TC_001_ProfServicesTest extends BaseClass{
	
	@Test(priority=1)
	public void test_profservices() 
	{
		logger.debug("application logs................");
		logger.info("Starting TC_001_ProfServicesTest");
		logger.info("Choosing Professional Tab");
		
		HomePage homePage = new HomePage(driver);
		homePage.servicesTab();
		logger.info("Free Consultation form is opened");
	}
	
	@Test(priority=2)
	public void test_fillForm() throws InterruptedException
	{
		
		FillFormPage fillFormPage = new FillFormPage(driver);
		
		logger.info("Filling in the form.....");
		fillFormPage.fillName(rb.getString("name"));
		fillFormPage.fillEmail(rb.getString("email"));
		fillFormPage.fillJob(randomString());
		fillFormPage.fillCompany(randomString());
		fillFormPage.fillMessage(randomString());
		
		logger.info("Handling the captcha.....");
		fillFormPage.handlereCaptcha();
		fillFormPage.formSubmit();
		
		logger.info("Form submission is done");
		logger.info("***** Execution Completed *****");
	}
	
	//@Test(priority=2)
	public void test_dataDriven() throws InterruptedException
	{
		DataDrivenTest dataDrivenTest = new DataDrivenTest(driver);
		dataDrivenTest.fillFormDetails();
	}
}
