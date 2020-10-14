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

import static org.junit.Assert.assertEquals;


/**
 * Unit test for simple App.
 */

public class PlexSignUpTest {

    private WebDriver chromeDriver;
    private WebDriverWait wait;


    /**
     * Rigorous Test :-)
     */
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

        wait = new WebDriverWait(chromeDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='signup button']")));
        WebElement signUpBtn = chromeDriver.findElement(By.xpath("//a[@class='signup button']"));
        signUpBtn.click();

       // wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fedauth-iFrame"));
        Thread.sleep(3000);
        chromeDriver.switchTo().frame("fedauth-iFrame");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='email']")));

        WebElement emailInput = chromeDriver.findElement(By.xpath("//*[@id='email']"));
        String email = "plexieTester999@mailinator.com";
        emailInput.sendKeys(email);

        WebElement passwordInput = chromeDriver.findElement(By.xpath("//*[@id='password']"));
        passwordInput.sendKeys("plexTester4");
        passwordInput.submit();

        Thread.sleep(7000);

        wait.until(ExpectedConditions.elementToBeClickable(By.className("NavBarAccountButton-avatarContainer-2fU5S_")));
        WebElement profile = chromeDriver.findElement(By.className("NavBarAccountButton-avatarContainer-2fU5S_"));
        profile.click();

        WebElement menu = chromeDriver.findElement(By.className("MenuHeader-menuHeader-1zqcoT"));
        assertEquals(menu.getText(), email.toUpperCase());

     /*   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[4]/div/div/div[1]/div/div/div/div[1]/a/div[2]/div")));
        WebElement home = chromeDriver.findElement(By.className("/html/body/div[1]/div[4]/div/div/div[1]/div/div/div/div[1]/a/div[2]/div"));

        assertEquals(home.getText(), "HOME");*/
    }
}
