package be.ordina.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private WebDriverWait wait;

    private By btnAccept = By.xpath("/html/body/div[9]/div/div/div[3]/a[2]");

    private By btnSignUp = By.xpath("//a[@class='signup button']");
    private By btnSignIn = By.xpath("//a[@class='signin']");

    private By textLoginConfirmation = By.xpath("//div[@class='SourceSidebarLink-title-1lgRT2 SidebarLink-title-2vaAAn']");
    private By textLoginFailed = By.xpath("//span[@class='zxQoh']");

    public HomePage(WebDriver chromeDriver){
        this.driver = chromeDriver;
        this.wait = new WebDriverWait(chromeDriver, 10);
    }

    public void clickAccept(){
        wait.until(ExpectedConditions.elementToBeClickable(btnAccept));
        driver.findElement(btnAccept).click();
    }

    public void clickSignUp(){
        driver.findElement(btnSignUp).click();
    }

    public void clickSignIn(){
        driver.findElement(btnSignIn).click();
    }

    public String getSuccessRegistrationMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(textLoginConfirmation));
        String message = driver.findElement(textLoginConfirmation).getText();
        return message;
    }

    public String getUnSuccessRegistrationMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(textLoginFailed));
        String message = driver.findElement(textLoginFailed).getText();
        return message;
    }
}
