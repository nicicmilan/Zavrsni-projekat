package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}
	public WebElement getFirstNameField() {
		return driver.findElement(By.xpath("//*[@name='user_first_name']"));
	}
	public WebElement getLastNameField() {
		return driver.findElement(By.xpath("//*[@name='user_last_name']"));
	}
	public WebElement getAddressField() {
		return driver.findElement(By.xpath("//*[@name='user_address']"));
	}
	public WebElement getPhoneField() {
		return driver.findElement(By.xpath("//*[@name='user_phone']"));
	}
	public WebElement getZipField() {
		return driver.findElement(By.xpath("//*[@name='user_zip']"));
	}
	public WebElement getUploadBtn() {
		return driver.findElement(By.xpath("//a[@title='Uplaod']"));
	}
	public WebElement getRemoveBtn() {
		return driver.findElement(By.xpath("//a[@title='Remove']"));
	}
	
	public WebElement getSaveBtn() {
		return driver.findElement(By.xpath("(//input[@name='btn_submit'])[1]"));
	}
	
	 // metode
	public void getCountry(String country) throws InterruptedException {
		WebElement countryElement = driver.findElement(By.xpath("//*[@id='user_country_id']"));
		Select countrySelect = new Select(countryElement);
		countrySelect.selectByVisibleText(country);
		Thread.sleep(1500);
	}
	public void getState(String state) throws InterruptedException {
		WebElement stateElement = driver.findElement(By.xpath("//*[@id='user_state_id']"));
		Select stateSelect = new Select(stateElement);
		stateSelect.selectByVisibleText(state);
		Thread.sleep(1500);
	}
	public void getCity(String city) throws InterruptedException {
		WebElement cityElement = driver.findElement(By.xpath("//*[@id='user_city']"));
		Select citySelect = new Select(cityElement);
		citySelect.selectByVisibleText(city);
		Thread.sleep(1500);
	}
	
	public void uploadImage(String image) throws InterruptedException {
		js.executeScript("arguments[0].click();", this.getUploadBtn());
		Thread.sleep(3000);
		WebElement input = driver.findElement(By.xpath("//*[@id='form-upload']/input"));
		input.sendKeys(image);
	}
	public void removeImage() {
		js.executeScript("arguments[0].click();", this.getRemoveBtn());
	}
	
	public void updateProfileInfo(String firstName, String lastName, String address, String phone, String zipCode,
			String country, String state, String city) throws InterruptedException{
		this.getFirstNameField().clear();
		this.getLastNameField().clear();
		this.getAddressField().clear();
		this.getPhoneField().clear();
		this.getZipField().clear();
		
		this.getFirstNameField().sendKeys(firstName);
		this.getLastNameField().sendKeys(lastName);
		this.getAddressField().sendKeys(address);
		this.getPhoneField().sendKeys(phone);
		this.getZipField().sendKeys(zipCode);
		this.getCountry(country);
		this.getState(state);
		this.getCity(city);
		this.getSaveBtn().click();
		
	}
	
}
