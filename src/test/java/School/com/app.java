package School.com;

import java.net.MalformedURLException;
import org.testng.Assert;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class app {
	public static void main(String[] args) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capabilities=new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appium:automationName", "UIAutomator2");
		capabilities.setCapability("appium:deviceName", "81c06b36ddee");
		capabilities.setCapability("appPackage", "com.track.genie");
		capabilities.setCapability("appActivity","com.track.genie.track_genie_phase_2.MainActivity");

		URL url=new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver driver = new AndroidDriver(url, capabilities);
		System.out.println("Application opened");
		
		//allow notification tab
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
		Thread.sleep(4000);
		//sending school id
		WebElement element =driver.findElement(By.xpath("//android.widget.EditText"));
		element.sendKeys("1");
		//			String actualText = element.getAttribute("value");       
		//	        Assert.assertEquals(actualText, "1","Hello track genie");
		Thread.sleep(4000);
		//click continue button
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Continue\"]")).click();
		Thread.sleep(4000);
		//skip 
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Skip\"]")).click();
		Thread.sleep(4000);
		//continue
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Continue\"]")).click();
		Thread.sleep(4000);
		//map and all permission

		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")).click();
		Thread.sleep(4000);
		//bus driver
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Bus Driver\"]")).click();
		Thread.sleep(4000);
		//continue
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Continue\"]")).click();
		Thread.sleep(4000);
		//username
		WebElement username= driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]"));
		username.sendKeys("HVS005");
		Thread.sleep(4000);
		//password
		WebElement password= driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
		password.click();
		password.sendKeys("password");
		Thread.sleep(4000);
		//scroll
		TouchAction touchAction = new TouchAction(driver);
		// Adjust the coordinates according to your requirement
		touchAction.press(PointOption.point(100, 500)).moveTo(PointOption.point(100, 300)).release().perform();
		Thread.sleep(3000);

		//login
		WebElement succes=driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Login\"]"));
		succes.click();
		WebElement homeScreenElement = null;
        try {
            homeScreenElement = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View"));
            Assert.assertTrue(homeScreenElement.isDisplayed(), "Login was successful.");
            System.out.println("Login successful.");
        } catch (Exception e) {
            Assert.fail("Login failed. Home screen element not found.");
        }
       

		Thread.sleep(4000);
		//resume trip
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Resume Trip\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"0/2\"]")).click();
//		List<MobileElement> studentsList = driver.findElements(By.xpath("//android.view.View[@content-desc=\"0/2\"]"));
//
//        // Iterate over each student and scan them
//        for (MobileElement student : studentsList) {
//            student.click(); // Click on the student to scan
//            // Wait for the scan process to complete
//            // Add your validation or further actions here
//            System.out.println("Scanned student: " + student.getText());
//        }
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\"Scan\"])[1]")).click();
		
//		boolean pickFromHome = false; // Set to true if picking from home, false if picking from school
//
//        // Select the appropriate checkbox based on the condition
//        if (pickFromHome) {
//            WebElement checkboxHome = driver.findElement(By.xpath("//android.widget.RadioButton[@content-desc=\"Picking from home\"]"));
//            checkboxHome.click();
//        } else {
//            WebElement checkboxSchool = driver.findElement(By.xpath("//android.widget.RadioButton[@content-desc=\"Dropped to School\"]"));
//            checkboxSchool.click();
//        }
//	}
		WebElement checkbox1 = driver.findElement(By.xpath("//android.widget.RadioButton[@content-desc=\"Picking from home\"]"));
        String checkbox1Text = checkbox1.getText();
        System.out.println("Text after clicking button: " + checkbox1Text);

        // Select the appropriate option based on the text
        if (checkbox1Text.equals("Picking from home")) {
            checkbox1.click();
            System.out.println("Selected picking from home");
        } else {
            WebElement checkbox2 = driver.findElement(By.xpath("//android.widget.RadioButton[@content-desc=\"Dropped to School\"]"));
            checkbox2.click();
            System.out.println("Selected picking from school");
        }

}
}
