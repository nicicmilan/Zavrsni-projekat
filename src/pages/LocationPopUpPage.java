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
		return driver.findElement(By.xpath("//input[@id='locality_keyword']"));
	}
	public WebElement getSelectLocation() {
		return driver.findElement(By.xpath("//*[@class='location-selector']"));
	}
	
	public WebElement getCloseBtn() {
		return driver.findElement(By.className("close-btn"));
	}
	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[text()='"+ locationName + "']"));
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
	
	public void setLocation(String locationName) throws InterruptedException {
		this.getKeyWord().click();
		Thread.sleep(1500);
		this.getLocationItem(locationName).click();
		js.executeScript("arguments[0].click();", this.getSubmit());
	}
	
	public void closeDialog() {
		js.executeScript("arguments[0].click();", this.getCloseBtn());
	}
	
}
