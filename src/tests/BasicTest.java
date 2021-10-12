package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.TakesScreenshot;


public abstract class BasicTest {
		
		protected WebDriver driver;
		protected WebDriverWait wait;
		protected JavascriptExecutor js;
		protected String baseUrl = "http://demo.yo-meals.com";
		String email = "customer@dummyid.com";
		String password = "12345678a";
		String baseURL = "http://demo.yo-meals.com/";
		
		@BeforeMethod
		public void beforeMethod() {
			System.setProperty("webdriver.chrome.driver",  
	                "driver-lib\\chromedriver.exe");
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver,30);
			driver.manage().window().maximize();
			this.js = (JavascriptExecutor) driver;
		}
		
		
		@AfterMethod
		public void afterTest(ITestResult result) throws IOException, InterruptedException {
			 
			if (result.getStatus() == ITestResult.FAILURE) {
				File ss = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
				String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss'.png'").format(new Date());
				File save = new File ("screenshots/" + fileName);
				FileHandler.copy(ss, save);
				Thread.sleep(1500);
				this.driver.quit();
			}
			else {
			this.driver.quit();
			}
		}
}
