package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationAndLoginModal {
    private final WebDriver chromeDriver;
    private WebDriverWait wait;

    private By tbEmail = By.xpath("//*[@id='email']");
    private By tbPassword = By.xpath("//*[@id='password']");

    private By btnLaunch = By.xpath("//a[@class='launch button']");

    public RegistrationAndLoginModal(WebDriver chromeDriver) {
        this.chromeDriver=chromeDriver;
        this.wait = new WebDriverWait(chromeDriver, 10);
    }

    public void registrationOrLogin(String email, String password){
        chromeDriver.findElement(tbEmail).sendKeys(email);

        WebElement elPassword =chromeDriver.findElement(tbPassword);
        elPassword.sendKeys(password);
        elPassword.submit();
    }

    public void goToHome(){
        wait.until(ExpectedConditions.elementToBeClickable(btnLaunch));
        chromeDriver.findElement(btnLaunch).click();
    }
}
