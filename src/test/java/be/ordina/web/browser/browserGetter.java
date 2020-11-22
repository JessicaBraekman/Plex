package be.ordina.web.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.System.setProperty;

public class browserGetter {

    public WebDriver getChromeDriver() {
        setProperty("webdriver.chrome.driver", "src/test/resources/browsers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.plex.tv/nl/");
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getFireFoxDriver() {

        setProperty("webdriver.gecko.driver", "src/test/resources/browsers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.plex.tv/nl/");
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getEdgeDriver(){
        setProperty("webdriver.edge.driver", "src/test/resources/browsers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.plex.tv/nl/");
        driver.manage().window().maximize();
        return driver;
    }
}
