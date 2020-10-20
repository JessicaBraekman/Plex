package be.ordina;


import be.ordina.pages.*;
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

    private HomePage homePage;
    private RegistrationAndLoginModal registrationAndLoginModal;
    private StreamVideoModal streamVideoModal;
    private SearchModal searchModal;
    private MovieModal movieModal;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.plex.tv/nl/");
        chromeDriver.manage().window().maximize();

        homePage = new HomePage(chromeDriver);
        registrationAndLoginModal = new RegistrationAndLoginModal(chromeDriver);
        streamVideoModal = new StreamVideoModal(chromeDriver);
        searchModal = new SearchModal(chromeDriver);
        movieModal = new MovieModal(chromeDriver);
    }

    @After
    public void tearDown(){
        // chromeDriver.close();
    }

    @Test
    public void successfulRegistration() throws InterruptedException {
        email = getRandomEmail()+"@mailinator.com";
        registration(email);

        String message = homePage.getSuccessMessage();
        assertTrue(message.contains("Home"));
    }

    @Test
    public void unSuccessfulRegistration(){
        email = "test@test.com";
        registration(email);

        String message = homePage.getUnSuccessMessage();
        assertTrue(message.contains("E-mail is al in gebruik"));
    }

    @Test
    public void unSuccessFullLogin(){
        email = "test@test.be";
        login(email);

        String message = homePage.getUnSuccessMessage();
        assertTrue(message.contains("De gebruikersnaam of wachtwoord is onjuist"));
    }

    @Test
    public void successfulStreaming() throws InterruptedException {
        email = "PlexTester1@mailinator.com";
        login(email);

        registrationAndLoginModal.goToHome();
        streamVideoModal.playVideo();
    }

    @Test
    public void successfullSearch(){
        email = "PlexTester1@mailinator.com";
        login(email);
       searchAMovie();

       String title = searchModal.searchFound();
       assertTrue(title.contains(movie));
    }

    @Test
    public void successfullAddToWatchlist(){
        email = "PlexTester1@mailinator.com";
        login(email);
        searchAMovie();
        addMovieToWatchList();
    }

    @Test
    public void successfullMarkAsPlayed(){
        email = "PlexTester1@mailinator.com";
        login(email);
        searchAMovie();
        markAMovieAsPlayed();
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

    public  void registration(String email){
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.clickAccept();

        homePage.clickSignUp();
        chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        chromeDriver.switchTo().frame("fedauth-iFrame");

        registrationAndLoginModal.registrationOrLogin(email, password);
    }

    public void login(String email){
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.clickAccept();

        homePage.clickSignIn();
        chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        chromeDriver.switchTo().frame("fedauth-iFrame");

        registrationAndLoginModal.registrationOrLogin(email, password);

        registrationAndLoginModal.goToHome();
    }

    public void searchAMovie(){
        searchModal.searchVideo(movie);
        searchModal.selectSearchResult();
    }

    public void addMovieToWatchList(){
        movieModal.addMovieToWatchList();
    }

    public void markAMovieAsPlayed(){
        movieModal.markAsPlayed();
    }
}
