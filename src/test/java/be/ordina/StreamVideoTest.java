package be.ordina;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Unit test for simple App.
 */

public class StreamVideoTest {

    private WebDriver chromeDriver;
    private WebDriverWait wait;


    /**
     * Rigorous Test :-)
     */
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JeBk\\Documents\\AquaTraining\\Downloads\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.plex.tv/nl/");
        chromeDriver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        // chromeDriver.close();
    }

    @Test
    public void successfulStreaming() throws InterruptedException {
        wait = new WebDriverWait(chromeDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"plex-site-container\"]/div[3]/div[2]/div[2]/div/div[1]/ul/li[1]/a")));
        WebElement signUpBtn = chromeDriver.findElement(By.xpath("//*[@id=\"plex-site-container\"]/div[3]/div[2]/div[2]/div/div[1]/ul/li[1]/a"));
        signUpBtn.click();

        Thread.sleep(2000);
        chromeDriver.switchTo().frame("fedauth-iFrame");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='email']")));

        WebElement emailInput = chromeDriver.findElement(By.xpath("//*[@id='email']"));
        emailInput.sendKeys("plexTester14@mailinator.com");

        WebElement passwordInput = chromeDriver.findElement(By.xpath("//*[@id='password']"));
        passwordInput.sendKeys("plexTester4");
        passwordInput.submit();

        Thread.sleep(100000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"plex-site-container\"]/div[3]/div[2]/div[2]/div/div[1]/ul/li[2]/a")));
        WebElement goToHome = chromeDriver.findElement(By.xpath("//*[@id=\"plex-site-container\"]/div[3]/div[2]/div[2]/div/div[1]/ul/li[2]/a"));
        goToHome.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[1]/div/a")));
        WebElement playMovie = chromeDriver.findElement(By.xpath("//*[@id='content']/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[1]/div/a"));
        playMovie.click();

    }
}
