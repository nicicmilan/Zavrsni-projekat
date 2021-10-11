package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}
	public WebElement getProfileUserBtn() {
		return driver.findElement(By.xpath("//*[contains(@class,'user-trigger-active')]"));
	}
	public WebElement getMyAcc() {
		return driver.findElement(By.linkText("My Account"));
	}
	public WebElement getLogout() {
		return driver.findElement(By.linkText("Logout"));
	}
	
	// metoda
	public void logoutUser() {
		js.executeScript("arguments[0].click();", this.getProfileUserBtn());
		wait.until(ExpectedConditions.elementToBeClickable(this.getLogout()));
		js.executeScript("arguments[0].click();", this.getLogout());
	}
}
