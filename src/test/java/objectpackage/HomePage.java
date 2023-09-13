package objectpackage;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.*;
import basepackage.BasePage;

public class HomePage extends BasePage {

	JavascriptExecutor executor = (JavascriptExecutor)driver;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
	Actions action = new Actions(driver);
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "(//a[normalize-space()='Professional Services'])[1]") WebElement btn_profservices;
	@FindBy(xpath = " //a[normalize-space()='Get a free consultation']") WebElement btn_consultation;
	@FindBy(xpath = "(//a[normalize-space()='Learning'])[1]") WebElement btn_learning;
	@FindBy(xpath = "(//a[normalize-space()='Free Courses'])[1]") WebElement drpdwn_freecources;
	
	public void servicesTab()
	{
		btn_profservices.click();
		btn_consultation.click();
	}
	
	public void learningTab()
	{
		action.moveToElement(btn_learning).perform();
		drpdwn_freecources.click();
	}
}
