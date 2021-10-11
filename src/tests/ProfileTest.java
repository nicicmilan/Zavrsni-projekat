package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AuthPage;
import pages.LocationPopUpPage;
import pages.LoginPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public class ProfileTest extends BasicTest {
	@Test
	public void profileTest() throws InterruptedException, IOException {
		driver.get(this.baseURL + "/guest-user/login-form");
		Thread.sleep(2000);
		// import pages
		LocationPopUpPage locationPopUp = new LocationPopUpPage(driver, wait, js);
		LoginPage login = new LoginPage(driver, wait, js);
		NotificationSystemPage notificationSystem = new NotificationSystemPage(driver, wait, js);
		ProfilePage profile = new ProfilePage(driver, wait, js);
		AuthPage auth = new AuthPage(driver, wait, js);
		locationPopUp.closeDialog();
		Thread.sleep(1500);
		login.typeCredentials();
		Thread.sleep(1000);
		Assert.assertTrue(notificationSystem.getMsg().contains("Login Successfull"),
				"[ERROR]: Login message was not displayed.");
		driver.navigate().to(baseURL + "/member/profile");
		Thread.sleep(1500);
		profile.updateProfileInfo("Milan", "Nicic", "Pera Peric 1a", "063524213", "18000", "United Kingdom", "Birmingham", "Rubery");
		Thread.sleep(2000);
		Assert.assertTrue(notificationSystem.getMsg().contains("Setup Successful"),
				"[ERROR]: Setup successful message was not displayed.");
		auth.logoutUser();
		Thread.sleep(2000);
		Assert.assertTrue(notificationSystem.getMsg().contains("Logout Successfull!"),
				"[ERROR]: Logout message was not displayed.");
		Thread.sleep(2000);
		}
	
		@Test
		public void editProfilePicture() throws InterruptedException {
			driver.get(this.baseURL + "/guest-user/login-form");
			Thread.sleep(2000);
			LocationPopUpPage locationPopUp = new LocationPopUpPage(driver, wait, js);
			LoginPage login = new LoginPage(driver, wait, js);
			NotificationSystemPage notificationSystem = new NotificationSystemPage(driver, wait, js);
			ProfilePage profile = new ProfilePage(driver, wait, js);
			AuthPage auth = new AuthPage(driver, wait, js);
			locationPopUp.closeDialog();
			Thread.sleep(1500);
			login.typeCredentials();
			Assert.assertTrue(notificationSystem.getMsg().contains("Login Successfull"),
					"[ERROR]: Login message was not displayed.");
			driver.navigate().to(baseURL + "/member/profile");
			Thread.sleep(1500);
			profile.uploadImage("C:\\Users\\Milan\\Downloads\\joker.jpg");
			Thread.sleep(3000);
			Assert.assertTrue(notificationSystem.getMsg().contains("Profile Image Uploaded Successfully"),
					"[ERROR]: Upload successfully message was not displayed.");
			notificationSystem.notificationInvisible();
			profile.removeImage();
			Thread.sleep(2000);
			Assert.assertTrue(notificationSystem.getMsg().contains("Profile Image Deleted Successfully"),
					"[ERROR]: Upload successfully message was not displayed.");
			notificationSystem.notificationInvisible();
			auth.logoutUser();
			Thread.sleep(2000);
			Assert.assertTrue(notificationSystem.getMsg().contains("Logout Successfull!"),
					"[ERROR]: Logout message was not displayed.");
			Thread.sleep(2000);
			
		}
	}

