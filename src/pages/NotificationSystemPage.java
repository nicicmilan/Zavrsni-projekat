package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {

	public NotificationSystemPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}

	public WebElement getElementMsg() {
		return driver.findElement(By.xpath("//*[contains(@class, 'system_message')]"));
	}
	public String getMsg() {
		return this.getElementMsg().getText();
	}
	
	public void notificationInvisible() {
		WebElement systemMessage = driver.findElement(By.xpath("//*[contains(@class, 'system_message')]"));
		wait.until(ExpectedConditions.attributeToBe(systemMessage, "style", "display: none;"));
	}
}
