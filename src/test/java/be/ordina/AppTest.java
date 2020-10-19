package be.ordina;


import be.ordina.pages.HomePage;
import be.ordina.pages.RegistrationAndLoginModal;
import be.ordina.pages.SearchModal;
import be.ordina.pages.StreamVideoModal;
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

    private String email;
    private String password = "PlexTest!";
    private String movie = "Bonanza";

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
        RegistrationAndLoginModal registrationModal = new RegistrationAndLoginModal(chromeDriver);

      //  chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      //  homePage.clickAccept();

        homePage.clickSignUp();
        chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        chromeDriver.switchTo().frame("fedauth-iFrame");

        email = getRandomEmail()+"@mailinator.com";
        registrationModal.registrationOrLogin(email, password);

        String message = homePage.getSuccessMessage();
        assertTrue(message.contains("Home"));
    }

    @Test
    public void unSuccessfulRegistration(){
        HomePage homePage = new HomePage(chromeDriver);
        RegistrationAndLoginModal registrationModal = new RegistrationAndLoginModal(chromeDriver);

        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.clickAccept();

        homePage.clickSignUp();
        chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        chromeDriver.switchTo().frame("fedauth-iFrame");

        registrationModal.registrationOrLogin("test@test.com", password);

        String message = homePage.getUnSuccessMessage();
        assertTrue(message.contains("E-mail is al in gebruik"));
    }

    @Test
    public void unSuccessFullLogin(){
        HomePage homePage = new HomePage(chromeDriver);
        RegistrationAndLoginModal loginModal = new RegistrationAndLoginModal(chromeDriver);

        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.clickAccept();

        homePage.clickSignIn();
        chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        chromeDriver.switchTo().frame("fedauth-iFrame");

        loginModal.registrationOrLogin("test@test.com", password);

        String message = homePage.getUnSuccessMessage();
        assertTrue(message.contains("De gebruikersnaam of wachtwoord is onjuist"));
    }

    @Test
    public void successfulStreaming() throws InterruptedException {
        RegistrationAndLoginModal LoginModal= new RegistrationAndLoginModal(chromeDriver);
        StreamVideoModal streamVideoModal = new StreamVideoModal(chromeDriver);

        succesFullLogin();

        LoginModal.goToHome();
        streamVideoModal.playVideo();
    }

    @Test
    public void successfullSearch(){
        SearchModal searchModal = new SearchModal(chromeDriver);
        succesFullLogin();
       searchAMovie();

       String title = searchModal.searchFound();
       assertTrue(title.contains(movie));
    }

    @Test
    public void successfullAddToWatchlist(){
        succesFullLogin();
        searchAMovie();

    }

    /**
     * getRanomEmail
     * Generates an random e-email string for the registation
     * @return random string
     */
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

    public void succesFullLogin(){
        HomePage homePage = new HomePage(chromeDriver);
        RegistrationAndLoginModal LoginModal= new RegistrationAndLoginModal(chromeDriver);

        //chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //homePage.clickAccept();

        homePage.clickSignIn();
        chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        chromeDriver.switchTo().frame("fedauth-iFrame");

        email = "PlexTester1@mailinator.com";
        LoginModal.registrationOrLogin(email, password);

        LoginModal.goToHome();
    }

    public void searchAMovie(){
        SearchModal searchModal = new SearchModal(chromeDriver);

        searchModal.searchVideo(movie);
        searchModal.selectSearchResult();
    }
}
