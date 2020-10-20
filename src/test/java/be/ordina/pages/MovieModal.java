package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MovieModal {
    private final WebDriver chromeDriver;
    private WebDriverWait wait;

    private By btnWatchlist = By.xpath("//button[@class='ActionButton-iconActionButton-2ry8hd ActionButton-actionButton-2LOxoL Button-button-3A5jB3 Link-link-2ew_DK Button-button-3A5jB3 Link-link-2ew_DK Button-default-23k-Yy Button-medium-2d_jtE Link-default-1uNM9i     ']");
    private By btnPlayed = By.xpath("//button[@class='ActionButton-iconActionButton-2ry8hd ActionButton-actionButton-2LOxoL Button-button-3A5jB3 Link-link-2ew_DK Button-button-3A5jB3 Link-link-2ew_DK Button-default-23k-Yy Button-medium-2d_jtE Link-default-1uNM9i     ']");

    public MovieModal(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        this.wait = new WebDriverWait(chromeDriver, 10);
    }

    public void addMovieToWatchList(){
        wait.until(ExpectedConditions.elementToBeClickable(btnWatchlist));
        chromeDriver.findElement(btnWatchlist).click();
    }

    public void markAsPlayed(){
        wait.until(ExpectedConditions.elementToBeClickable(btnPlayed));
        chromeDriver.findElement(btnPlayed).click();
    }
}
