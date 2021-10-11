package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}
	public WebElement favouriteBtn() {
		return driver.findElement(By.xpath("//*[contains(@class,'favourite')]"));
	}
	public WebElement getQty() {
		return driver.findElement(By.xpath("//*[@name='product_qty']"));
	}
	public WebElement getAddToCart() {
		return driver.findElement(By.xpath("//*[contains(@class,'js-proceedtoAddInCart')]"));
	}
	public void addMealToCart(String quantity) {
		this.getQty().sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		this.getQty().sendKeys(quantity);
		js.executeScript("arguments[0].click();", this.getAddToCart());
	}
	
	public void favouriteMeal() {
		js.executeScript("arguments[0].click();", this.favouriteBtn());
	}
	
}
