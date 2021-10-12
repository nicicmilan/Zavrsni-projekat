package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopUpPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public class MealItemTest extends BasicTest {

	@Test(priority = 1)
	public void mealItemTest() throws InterruptedException {
		driver.get(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(1500);
		LocationPopUpPage locationPopUp = new LocationPopUpPage(driver, wait, js);
		NotificationSystemPage notificationSystem = new NotificationSystemPage(driver, wait, js);
		MealPage meal = new MealPage(driver, wait, js);
		locationPopUp.closeDialog();
		Thread.sleep(1500);
		meal.addMealToCart("2");
		Thread.sleep(2000);
		Assert.assertTrue(notificationSystem.getMsg().contains("The Following Errors Occurred:"),
				"[ERROR]: Error message was not displayed.");
		Assert.assertTrue(notificationSystem.getMsg().contains("Please Select Location"),
				"[ERROR]: Please Select Location message was not displayed.");
		Thread.sleep(1500);
		locationPopUp.openDialog();
		Thread.sleep(1500);
		locationPopUp.setLocation("City Center - Albany");
		Thread.sleep(1500);
		meal.addMealToCart("3");
		meal.getAddToCart().click();
		Thread.sleep(2000);
		Assert.assertTrue(notificationSystem.getMsg().contains("Meal Added To Cart"),
				"[ERROR]: Meal Added message was not displayed.");
}
	@Test(priority = 2)
	public void addMealToFavourite() throws InterruptedException {
		driver.get(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(1500);
		LoginPage login = new LoginPage(driver, wait, js);
		LocationPopUpPage locationPopUp = new LocationPopUpPage(driver, wait, js);
		NotificationSystemPage notificationSystem = new NotificationSystemPage(driver, wait, js);
		MealPage meal = new MealPage(driver, wait, js);
		locationPopUp.closeDialog();
		Thread.sleep(1000);
		meal.favouriteMeal();
		Thread.sleep(1500);
		Assert.assertTrue(notificationSystem.getMsg().contains("Please login first!"),
				"[ERROR]:Please login message was not displayed.");
		driver.navigate().to(baseURL + "guest-user/login-form");
		login.typeCredentials();
		driver.navigate().to(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		meal.favouriteMeal();
		Thread.sleep(2000);
		Assert.assertTrue(notificationSystem.getMsg().contains("Product has been added to your favorites."),
				"[ERROR]:Product hasn't been added to your favourites.");
	}
	@Test(priority=3)
	public void clearCart() throws InterruptedException, IOException {
		LocationPopUpPage locationPopUp = new LocationPopUpPage(driver, wait, js);
		MealPage meal = new MealPage(driver, wait, js);
		NotificationSystemPage notificationSystem = new NotificationSystemPage(driver, wait, js);
		CartSummaryPage cart = new CartSummaryPage(driver, wait, js);
		SoftAssert sa = new SoftAssert();
		driver.get(baseURL + "meals");
		locationPopUp.setLocation("City Center - Albany");
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetMeal = wb.getSheet("Meals");
		for (int i = 1; i <= sheetMeal.getLastRowNum(); i++) {
			String obrok = sheetMeal.getRow(i).getCell(0).getStringCellValue();
			driver.navigate().to(obrok);
			Thread.sleep(2000);
			meal.addMealToCart("1");
			Thread.sleep(3000);
			Assert.assertTrue(notificationSystem.getMsg().contains("Meal Added To Cart"),
					"[ERROR]: Meal Added message was not displayed.");
		}
		sa.assertAll();
		cart.clearAll();
		Thread.sleep(2000);
		Assert.assertTrue(notificationSystem.getMsg().contains("All meals removed from Cart successfully"),
				"[ERROR]: Meals removed message was not displayed.");
	}
	
	
	
}
