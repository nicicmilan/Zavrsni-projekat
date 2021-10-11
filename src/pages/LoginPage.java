package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}
	public WebElement getLoginBtn() {
		return driver.findElement(By.linkText("Login"));
	}
	public WebElement getEmailField() {
		return driver.findElement(By.name("username"));
	}
	public WebElement getPasswordField() {
		return driver.findElement(By.name("password"));
	}
	public WebElement getSubmitBtn() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	public void typeCredentials() {
		this.getEmailField().sendKeys("customer@dummyid.com");
		this.getPasswordField().sendKeys("12345678a");
		this.getSubmitBtn().click();
	}
	
	
	
}
