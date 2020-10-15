package be.ordina;


import be.ordina.pages.HomePage;
import be.ordina.pages.LoginModal;
import be.ordina.pages.RegistrationModal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private WebDriver chromeDriver;
    private WebDriverWait wait;

    private String email = getRandomEmail()+"@mailinator.com";
    private String password = "PlexTest!";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.plex.tv/nl/");
        chromeDriver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        // chromeDriver.close();
    }

    @Test
    public void successfulRegistration() throws InterruptedException {
        HomePage homePage = new HomePage(chromeDriver);
        RegistrationModal registrationModal = new RegistrationModal(chromeDriver);

        homePage.clickSignUp();
        chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        chromeDriver.switchTo().frame("fedauth-iFrame");

        registrationModal.registration(email, password);

        String message =homePage.getSuccessMessage();
        assertTrue(message.contains("Home"));
    }

    @Test
    public void successfulStreaming() throws InterruptedException {
        HomePage homePage = new HomePage(chromeDriver);
        LoginModal loginModal = new LoginModal(chromeDriver);

        homePage.clickSignIn();

        loginModal.login(email, password);

    }

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
}
