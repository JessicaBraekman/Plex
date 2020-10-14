package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver chromeDriver;
    private WebDriverWait wait;

    private By btnSignUp = By.xpath("//a[@class='signup button']");
    private By btnSignIn = By.xpath("//a[@class='signin']");

    private By textSignUpConfirmation = By.xpath("");
    private By textLoginConfirmation = By.xpath("");

    public HomePage(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        this.wait = new WebDriverWait(chromeDriver, 10);
    }

    public void clickSignUp(){
        chromeDriver.findElement(btnSignUp).click();
    }

    public void clickSignIn(){
        chromeDriver.findElement(btnSignIn).click();
    }
}
