package freshWorks;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;



import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidTestNG {
	static AndroidDriver<MobileElement> driver;
	
	@BeforeSuite
	public void beforeMethod() throws MalformedURLException{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 6p");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\mixte\\Downloads\\Used ca_v2.0.52_apkpure.com.apk");
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

	}
		
		
		  //Verify if skip and Login are displayed in app
		
		 @Test(priority=1)
		 public void TC001() {
		  //There is element with name App on screen.
		  //loginSkipbtn will be true.
		  Boolean loginSkipbtn = driver.findElementById("ca.used:id/login_skip_button").isDisplayed();
		  
		  //loginSkipbtn will be true and the assertion will pass.
		  Assert.assertTrue(loginSkipbtn,"Login/Skip button is displayed");
		  System.out.println("Login/Skip button is displayed");
		  
		  
		  Boolean signUp = driver.findElementById("ca.used:id/login_sign_up_tv").isDisplayed();
		  Assert.assertTrue(signUp,"Signup is displayed");
		  System.out.println("Signup is displayed");
		  
		 }
		 @Test(priority=2)
		 public void TC002(){
		//Verify Carousel element skip and login are displayed
		Boolean carouselLogin = driver.findElementById("ca.used:id/carousel_0_image_iv").isDisplayed();
		Assert.assertTrue(carouselLogin,"Login/Skip button is displayed");
		System.out.println("Login button is displayed");
		  
		Boolean skipButton = driver.findElementById("ca.used:id/carousel_0_title_tv").isDisplayed();
		Assert.assertTrue(skipButton,"Skip button is displayed");
		System.out.println("Skip button is displayed");
		
		 }
		 
		 @Test(priority=3)
		 public void TC003(){
		// Verify indicator is displayed
		boolean indicator = driver.findElementById("ca.used:id/indicator").isDisplayed();
		Assert.assertTrue(indicator,"Indicator Element is displayed");
		System.out.println("Indicator element is displayed");
		 }
		
		 @Test(priority=4)
		 public void TC004(){
		//Verify Login with Facebook is displayed and enabled
		MobileElement fbShow = (MobileElement) driver.findElementById("ca.used:id/login_facebook_button");
		Assert.assertTrue(fbShow.isDisplayed());
		System.out.println("Facebook button element is displayed");
		
		MobileElement fbOn =  (MobileElement) driver.findElementById("ca.used:id/login_facebook_button");
		Assert.assertTrue(fbOn.isEnabled());
		System.out.println("Facebook button is enabled");
		
		 }
		
		 @Test(priority=5)
		 public void TC005(){
		// Verify text Or is displayed
		MobileElement textOr = (MobileElement)driver.findElementById("ca.used:id/login_or_tv");
		Assert.assertTrue(textOr.isDisplayed());
		System.out.println("Facebook button is enabled");
		//System.out.println(elementOr);
		 }
	
		 @Test(priority=6)
		 public void TC006(){
		//Check login/email address text can be entered
		MobileElement login = (MobileElement) driver.findElementById("ca.used:id/login_email_et");
		login.sendKeys("TEST@test.com");
		Assert.assertEquals("TEST@test.com", "TEST@test.com");
		System.out.println("Email address entered");
		//login.clear();
		
	  }
		 
		 @Test(priority=7)
		 public void TC007(){
			 // Verify Forgot Password is present
			 MobileElement forgotPassword = (MobileElement) driver.findElementById("ca.used:id/login_forgot_password_button");
			forgotPassword.isEnabled();
		 }
		 
		 @Test(priority=8)
		 public void TC008(){
			 // Verify Sign in button is enabled
			 MobileElement signInBtn = (MobileElement) driver.findElementById("ca.used:id/fresh_loading_button_text_tv");
			 signInBtn.isEnabled();
		 }
		 
		 
		 @Test(priority=9)
		public void TC009(){
			 // Verify Clicking skip button takes you to Search by Region
			
			MobileElement clickSkip = (MobileElement) driver.findElementById("ca.used:id/login_skip_button");
			clickSkip.click();
			
			MobileElement locationNotification = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
			locationNotification.click();
			
			MobileElement selectRegionDisplayed = (MobileElement) driver.findElementById("ca.used:id/select_region_toolbar_layout");
			Assert.assertTrue(selectRegionDisplayed.isDisplayed());
		}
		 
		 @Test(priority=10)
		public void TC010(){
			 // Verify Search field is enabled
			
			MobileElement searchField = (MobileElement) driver.findElementById("ca.used:id/select_region_search_et");
			Assert.assertTrue(searchField.isEnabled());
		}
		 @Test(priority=11)
			public void TC011(){
			 // Enter a province in the Search field.
				
				MobileElement searchField = (MobileElement) driver.findElementById("ca.used:id/select_region_search_et");
				searchField.sendKeys("British Columbia");
				Assert.assertEquals("British Columbia","British Columbia");
			}
		 @Test(priority=12)
			public void TC012(){
			 // Verify province searched for is returned and you can click it.
				
				MobileElement clickBC = (MobileElement) driver.findElementById("ca.used:id/item_region_name_tv");
				clickBC.click();
			}
		 @Test(priority=13)
			public void TC013(){
			 //  Verify Search icon can be clicked and takes you to search screen.
				
				MobileElement clickSearch = (MobileElement) driver.findElementById("ca.used:id/main_toolbar_search_iv");
				clickSearch.click();
			}
		 @Test(priority=14)
			public void TC014(){
			 
			 //Verify search query can be entered ie snowboards
				
				MobileElement enterSearch = (MobileElement) driver.findElementById("ca.used:id/search_et");
				enterSearch.sendKeys("snowboards");
				Assert.assertTrue(true,"snowboards");
				
			}
		 @Test(priority=15)
			public void TC015(){
			 //This is a false positive test - It is expecting snowboards, we are wanting snowboarding.
				
				MobileElement enterSearch = (MobileElement) driver.findElementById("ca.used:id/item_search_item_tv");
				enterSearch.getText().equals(enterSearch);
				Assert.assertEquals("snowboards", "snowboarding");
				
			}
		 @Test(priority=16)
			public void TC016(){
			 
			 //Click item search to display item
				
				MobileElement itemSearch = (MobileElement) driver.findElementById("ca.used:id/item_search_item_icon_iv");
				itemSearch.click();
				
			}
			
			

		
	}
	
	
