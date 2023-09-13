package objectpackage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.*;

public class FillFormPage extends HomePage{
	
	public FillFormPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id = "control-0") WebElement txt_name;
	@FindBy(id = "control-1") WebElement txt_email;
	@FindBy(id = "control-2") WebElement txt_job;
	@FindBy(id = "control-3") WebElement txt_company;
	@FindBy(id = "control-4") WebElement txt_message;
	@FindBy(xpath = "//iframe[@title='reCAPTCHA']") WebElement frm_captcha;
	
	@FindBy(xpath = "//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox']")
	WebElement btn_checkbox;
	
	@FindBy(xpath = "//div[@class='rc-imageselect-desc-wrapper']")
	WebElement frm_img;
	
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement btn_submit;

	
	public void fillName(String name)
	{
		txt_name.sendKeys(name);
	}
	
	public void fillEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void fillJob(String job)
	{
		txt_job.sendKeys(job);
	}
	
	public void fillCompany(String company)
	{
		txt_company.sendKeys(company);
	}
	
	public void fillMessage(String message)
	{
		txt_message.sendKeys(message);
	}
	
	public void handlereCaptcha() throws InterruptedException
	{
		
		executor.executeScript("arguments[0].scrollIntoView(true);",btn_submit);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frm_captcha));
		
		btn_checkbox.click();
		wait.until(ExpectedConditions.invisibilityOf(frm_img));
		
		driver.switchTo().defaultContent();
		Thread.sleep(50);
	}
	
	public void formSubmit()
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(btn_submit));
		
        executor.executeScript("arguments[0].click();",btn_submit);
        
        //Point loc = btn_submit.getLocation();
        //System.out.println(loc);
       
        action.moveByOffset(539 , 593).click().build().perform(); 
	}
	
}

