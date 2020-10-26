package be.ordina.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.System.setProperty;

public class browserGetter {

    private WebDriver chromeDriver;

    public WebDriver getChromeDriver() {
        setProperty("webdriver.chrome.driver", "src/test/resources/browsers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getFireFoxDriver() {
        setProperty("webdriver.gecko.driver", "src/test/resources/browsers/geckodriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
