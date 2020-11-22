package be.ordina.web;

import be.ordina.web.browser.browserGetter;
import be.ordina.web.pages.HomePage;
import be.ordina.web.pages.MoviePage;
import be.ordina.web.pages.RegistrationAndLoginModal;
import be.ordina.web.utils.SeleniumUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Test for Plex in Chrome.
 */
public class EdgeTest
{
    private be.ordina.web.browser.browserGetter browserGetter = new browserGetter();
    private WebDriver driver;
    private WebDriverWait wait;

    private String email;
    private String password = "PlexTest!";
    private String movie = "Bonanza";

    private HomePage homePage;
    private RegistrationAndLoginModal registrationAndLoginModal;
    private MoviePage moviePage;
/*
    @Before
    public void setUp(){
        driver = browserGetter.getEdgeDriver();
       // driver.get("https://www.plex.tv/nl/");


        homePage = new HomePage(driver);
        registrationAndLoginModal = new RegistrationAndLoginModal(driver);
        moviePage = new MoviePage(driver);
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void successfulRegistration()  {
        email = getRandomEmail()+"@mailinator.com";
        registration(email);

        String message = homePage.getSuccessRegistrationMessage();
        System.out.println(message);

        assertTrue(message.contains("Home"));

        try {
            SeleniumUtils.screenshot(driver, "Edge_SuccessfulRegistration");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void unSuccessfulRegistration(){
        email = "test@test.com";
        registration(email);

        String message = homePage.getUnSuccessRegistrationMessage();
        assertTrue(message.contains("E-mail is al in gebruik"));
        try {
            SeleniumUtils.screenshot(driver, "Edge_UnSuccessFulRegistration");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void SuccessFullLogin(){
        email = "PlexTester1@mailinator.com";;
        login(email);

        String message = registrationAndLoginModal.getSuccessLoginMessage();
        assertTrue(message.contains("Starten"));
        try {
            SeleniumUtils.screenshot(driver, "Edge_SuccessFullLogin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void unSuccessFullLogin(){
        email = "test@test.be";
        login(email);

        String message = homePage.getUnSuccessRegistrationMessage();
        assertTrue(message.contains("De gebruikersnaam of wachtwoord is onjuist"));
        try {
            SeleniumUtils.screenshot(driver, "Edge_UnSuccessFullLogin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successfulStreaming() {
        email = "PlexTester1@mailinator.com";
        login(email);

        registrationAndLoginModal.goToHome();

        moviePage.playVideo();
        String message = moviePage.MovieIsPlaying();
        assertTrue(message.contains("Pause"));


        try {
            SeleniumUtils.screenshot(driver, "Edge_SuccesFullStreaming");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successfullSearch(){
        email = "PlexTester1@mailinator.com";
        login(email);
        registrationAndLoginModal.goToHome();
        searchAMovie();

        String title = moviePage.searchFound();
        assertTrue(title.contains(movie));

        try {
            SeleniumUtils.screenshot(driver, "Edge_SuccessFullSearch");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successfullAddToWatchlist(){
        email = "PlexTester1@mailinator.com";
        login(email);
        registrationAndLoginModal.goToHome();

        searchAMovie();
        addMovieToWatchList();

        String addedToWatchList = moviePage.checkIfAddedOrRemovedFromWatchList();
        assertTrue(addedToWatchList.contains("preplay-removeFromWatchlist"));

        try {
            SeleniumUtils.screenshot(driver, "Edge_SuccessFullAddToWatchList");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successfullRemovedFromWatchlist(){
        email = "PlexTester1@mailinator.com";
        login(email);
        registrationAndLoginModal.goToHome();

        searchAMovie();
        addMovieToWatchList();

        String addedToWatchList = moviePage.checkIfAddedOrRemovedFromWatchList();
        assertTrue(addedToWatchList.contains("preplay-addToWatchlist"));

        try {
            SeleniumUtils.screenshot(driver, "Edge_SuccessFullRemovedFromWatchList");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successfullMarkAsPlayed(){
        email = "PlexTester1@mailinator.com";
        login(email);

        registrationAndLoginModal.goToHome();

        searchAMovie();
        markAMovieAsPlayed();

        String addedToWatchList = moviePage.checkIfMarkedAsPlayed();
        assertTrue(addedToWatchList.contains("plex-icon-toolbar-mark-unplayed-560"));

        try {
            SeleniumUtils.screenshot(driver, "Edge_SuccessFullMarkAsPlayed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successfullUnMarkAsPlayed(){
        email = "PlexTester1@mailinator.com";
        login(email);

        registrationAndLoginModal.goToHome();

        searchAMovie();
        unMarkAMovieAsPlayed();

        String addedToWatchList = moviePage.checkUnMarkedAsPlayed();
        assertTrue(addedToWatchList.contains("plex-icon-toolbar-mark-played-560"));

        try {
            SeleniumUtils.screenshot(driver, "Edge_SuccessFullUnMarkAsPlayed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * getRanomEmail
     * Generates an random e-email string for the registation
     * @return random string
     *//*
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
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // homePage.clickAccept();

        homePage.clickSignIn();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.switchTo().frame("fedauth-iFrame");

        registrationAndLoginModal.registrationOrLogin(email, password);
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

    public void unMarkAMovieAsPlayed(){ moviePage.unMarkAsPlayed();}
*/
}