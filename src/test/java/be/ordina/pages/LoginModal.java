package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginModal {
    private final WebDriver chromeDriver;

    private By tbEmail = By.xpath("//*[@id='email']");
    private By tbPassword = By.xpath("//*[@id='password']");

    public LoginModal(WebDriver chromeDriver) {
        this.chromeDriver=chromeDriver;
    }


    public void login(String email, String password){
        chromeDriver.findElement(tbEmail).sendKeys(email);

        WebElement elPassword =chromeDriver.findElement(tbPassword);
        elPassword.sendKeys(password);
        elPassword.submit();
    }
}
