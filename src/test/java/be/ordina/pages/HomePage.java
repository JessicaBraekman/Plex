package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver chromeDriver;
    private WebDriverWait wait;

    private By btnSignUp = By.xpath("//a[@class='signup button']");
    private By btnSignIn = By.xpath("//a[@class='signin']");

    private By textLoginConfirmation = By.xpath("//div[@class='SourceSidebarLink-title-1lgRT2 SidebarLink-title-2vaAAn']");
    private By textLoginFailed = By.xpath("//span[@class='zxQoh']");

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

    public String getSuccessMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(textLoginConfirmation));
        String message = chromeDriver.findElement(textLoginConfirmation).getText();
        return message;
    }

    public String getUnSuccessMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(textLoginFailed));
        String message = chromeDriver.findElement(textLoginFailed).getText();
        return message;
    }
}
