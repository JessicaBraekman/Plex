package be.ordina.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RegistrationAndLoginModal {
    private final WebDriver driver;
    private WebDriverWait wait;

    private By tbEmail = By.xpath("//*[@id='email']");
    private By tbPassword = By.xpath("//*[@id='password']");

    private By btnLaunch = By.xpath("//a[@class='launch button']");

    public RegistrationAndLoginModal(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void registrationOrLogin(String email, String password){
        driver.findElement(tbEmail).sendKeys(email);

        WebElement elPassword = driver.findElement(tbPassword);
        elPassword.sendKeys(password);
        elPassword.submit();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    }

    public void goToHome(){
        wait.until(ExpectedConditions.elementToBeClickable(btnLaunch));
        driver.findElement(btnLaunch).click();
    }

    public String getSuccessLoginMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLaunch));
        String message = driver.findElement(btnLaunch).getText();
        return message;
    }
}
