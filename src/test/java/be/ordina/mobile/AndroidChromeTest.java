package be.ordina.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;


public class AndroidChromeTest {
    AndroidDriver driver;
    WebDriverWait wait;
    String email;
/*
    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");

        capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.plexapp.android");
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.plexapp.plex.activities.SplashActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver =new AndroidDriver(url, capabilities);
        wait = new WebDriverWait(driver, 20);
    }

    @After
    public void tearDown() {
      //  driver.quit();
    }

    @Test
    public void SuccessFullLogin(){
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("com.plexapp.android:id/upsell_signup_button")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Navigate up")));
        driver.findElementByAccessibilityId("Sign up").click();

        //Navigate up
        /*driver.findElementByXPath("com.plexapp.android:id/upsell_signup_button").click();
//com.plexapp.android:id/upsell_signin
        driver.findElementByXPath("com.plexapp.android:id/continue_with_email").click();

        driver.findElementByXPath("com.plexapp.android:id/textinput_placeholder").sendKeys("PlexTester1@mailinator.com");
        driver.findElementByXPath("com.plexapp.android:id/password").sendKeys("PlexTest!");
        driver.findElementByXPath("com.plexapp.android:id/buttonSignUp").click();
        driver.findElementByAccessibilityId("Sign up").click();¨/

        //com.plexapp.android:id/action_bar_title

        /*email = "PlexTester1@mailinator.com";;
        login(email);

        String message = registrationAndLoginModal.getSuccessLoginMessage();
        assertTrue(message.contains("Starten"));
        try {
            SeleniumUtils.screenshot(driver, "Chrome_SuccessFullLogin");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
/*
    public String getRandomEmail(){
        // create a string of uppercase and lowercase characters and numbers
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        // combine all strings
        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 10;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphaNumeric.length());

            // get character specified by index
            // from the string
            char randomChar = alphaNumeric.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String randomString = sb.toString();

        return  randomString;


    }

    public void login(String email){
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // homePage.clickAccept();

        homePage.clickSignIn();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.switchTo().frame("fedauth-iFrame");

        registrationAndLoginModal.registrationOrLogin(email, password);
    }


}
*/