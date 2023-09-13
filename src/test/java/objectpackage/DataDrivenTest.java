package objectpackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.ExcelUtils;


public class DataDrivenTest extends HomePage{

	public DataDrivenTest (WebDriver driver)
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
	

	String file = System.getProperty("user.dir")+"\\testdata\\DataInput.xlsx";
	
	public void fillFormDetails() throws InterruptedException
	{
		
	try {
		int rows = ExcelUtils.getRowCount(file, "Sheet1");
		
		//for(int i=1;i<=rows;i++)
		//{
			//read data from excel
			String name = ExcelUtils.getCellData(file, "Sheet1", 1, 0);
			String email = ExcelUtils.getCellData(file, "Sheet1", 2, 1);
			String job = ExcelUtils.getCellData(file, "Sheet1", 3, 2);
			String company = ExcelUtils.getCellData(file, "Sheet1", 4, 3);
			String message = ExcelUtils.getCellData(file, "Sheet1", 5, 4);
			
			//pass data to app
			txt_name.sendKeys(name);
			txt_email.sendKeys(email);
			txt_job.sendKeys(job);
			txt_company.sendKeys(company);
			txt_message.sendKeys(message);
			
			executor.executeScript("arguments[0].scrollIntoView(true);",btn_submit);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frm_captcha));
			
			btn_checkbox.click();
			wait.until(ExpectedConditions.invisibilityOf(frm_img));
			
			driver.switchTo().defaultContent();
			Thread.sleep(50);
	
			
			wait.until(ExpectedConditions.elementToBeClickable(btn_submit));
	        executor.executeScript("arguments[0].click();",btn_submit);
	        action.moveByOffset(539 , 593).click().build().perform();
	        
		//}
		
	}catch(IOException e)
	{
		e.printStackTrace();
	}	
	}
	
	
	
}

//String expected = ExcelUtils.getCellData(file, "Sheet1", i, 4);

