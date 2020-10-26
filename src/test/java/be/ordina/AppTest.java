package be.ordina;

import be.ordina.browser.browserGetter;
import be.ordina.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private browserGetter browserGetter = new browserGetter();
    private WebDriver driver;
    private WebDriverWait wait;

    private String email;
    private String password = "PlexTest!";
    private String movie = "Bonanza";

    private HomePage homePage;
    private RegistrationAndLoginModal registrationAndLoginModal;
    private MoviePage moviePage;

    @Before
    public void setUp(){
        driver = browserGetter.getChromeDriver();
   //     driver = browserGetter.getFireFoxDriver();
        driver.get("https://www.plex.tv/nl/");


        homePage = new HomePage(driver);
        registrationAndLoginModal = new RegistrationAndLoginModal(driver);
        moviePage = new MoviePage(driver);
    }

    @After
    public void tearDown(){
        driver.close();
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
        moviePage.playVideo();
    }

    @Test
    public void successfullSearch(){
        email = "PlexTester1@mailinator.com";
        login(email);
       searchAMovie();

       String title = moviePage.searchFound();
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
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //homePage.clickAccept();

        homePage.clickSignUp();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.switchTo().frame("fedauth-iFrame");

        registrationAndLoginModal.registrationOrLogin(email, password);
    }

    public void login(String email){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.clickAccept();

        homePage.clickSignIn();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.switchTo().frame("fedauth-iFrame");

        registrationAndLoginModal.registrationOrLogin(email, password);

        registrationAndLoginModal.goToHome();
    }

    public void searchAMovie(){
        moviePage.searchVideo(movie);
        moviePage.selectSearchResult();
    }

    public void addMovieToWatchList(){
        moviePage.addMovieToWatchList();
    }

    public void markAMovieAsPlayed(){
        moviePage.markAsPlayed();
    }
}
