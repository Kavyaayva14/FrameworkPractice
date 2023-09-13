package objectpackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LearningPage extends HomePage{

	public LearningPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Sign In']") WebElement btn_signin;
	@FindBy(xpath = "(//input[@id='user[email]'])[1]") WebElement txt_email;
	@FindBy(xpath = "(//input[@id='user[password]'])[1]") WebElement txt_password;
	@FindBy(xpath = "//button[normalize-space()='Sign in']") WebElement btn_submit;
	@FindBy(xpath = "//li[normalize-space()='Invalid email or password.']") WebElement txt_error;
	
	public void signIn()
	{
		btn_signin.click();
	}
	
	public void fillEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void fillPassword(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void submit()
	{
		btn_submit.click();
		wait.until(ExpectedConditions.elementToBeClickable(btn_submit));
		executor.executeScript("arguments[0].click();",btn_submit);
		
        //action.moveByOffset(467 , 500).click().build().perform(); 
	}
	
	public void captureError()
	{
		wait.until(ExpectedConditions.visibilityOf(txt_error));
		System.out.println(txt_error.getText());
	}
}
