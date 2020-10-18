package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StreamVideoModal {
    private final WebDriver chromeDriver;
    private WebDriverWait wait;

    private By btnPlayMovie = By.xpath("//*[@id='content']/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[1]/div/a");

    public StreamVideoModal(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        this.wait = new WebDriverWait(chromeDriver, 10);
    }

    public void playVideo(){
        wait.until(ExpectedConditions.elementToBeClickable(btnPlayMovie));
        chromeDriver.findElement(btnPlayMovie).click();
    }

}
