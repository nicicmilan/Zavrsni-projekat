package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopUpPage extends BasicPage {

	public LocationPopUpPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}
	
	public WebElement getKeyWord() {
		return driver.findElement(By.id("locality_keyword"));
	}
	public WebElement getSelectLocation() {
		return driver.findElement(By.xpath("//*[@class='location-selector']"));
	}
	
	public WebElement getCloseBtn() {
		return driver.findElement(By.className("close-btn"));
	}
	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	public WebElement getLocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}
	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	// metode

	public void openDialog() {
		this.getSelectLocation().click();
	}
	
	public void setLocation(String locationName) {
		this.getKeyWord().click();
		String dataValue = this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1];", this.getLocationInput(), dataValue);
		js.executeScript("arguments[0].click();", this.getSubmit());
	}
	public void closeDialog() {
		this.getCloseBtn().click();
	}
	
}
