package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StreamVideoModal {
    private final WebDriver chromeDriver;
    private WebDriverWait wait;

    private By tbEmail = By.xpath("//*[@id='email']");
    private By tbPassword = By.xpath("//*[@id='password']");

    private By btnPlayMovie = By.xpath("//*[@id='content']/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[1]/div/a");

    public StreamVideoModal(WebDriver chromeDriver){this.chromeDriver = chromeDriver;}

    public void playVideo(){
        wait.until(ExpectedConditions.elementToBeClickable(btnPlayMovie));
        chromeDriver.findElement(btnPlayMovie).click();
    }

}
