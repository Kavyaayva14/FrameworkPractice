package basepackage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	
	public Logger logger;
	
	public ResourceBundle rb;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		logger = LogManager.getLogger(this.getClass());
		
		rb = ResourceBundle.getBundle("config");
		
		//WebDriverManager.chromedriver().setup();
		if(br.equals("chrome"))
		{
		    driver = new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
	}
	
	
	@AfterClass
	public void teardown() 
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphanumeric(7);
		return(generatedString);
	}
	
	public String randomNumber()
	{
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return(generatedString2);
	}
	
	public String randomAlphaNumeric()
	{
		String str = RandomStringUtils.randomAlphanumeric(8);
		String num = RandomStringUtils.randomNumeric(3);
		return(str+num);
	}
	
	public String captureScreen(String tname) 
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "//screenshots" + tname + "-" + timeStamp + ".png";
		
		try {
		FileUtils.copyFile(source, new File(destination));
		}catch(Exception e)
		{
			e.getMessage();
		}
		
		return destination;
	}
}
