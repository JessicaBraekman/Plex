package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoviePage {
    private final WebDriver chromeDriver;
    private WebDriverWait wait;

    //Search
    private By tbSearch = By.xpath("//input[@class='QuickSearchInput-searchInput-3m6naA']");
    private By textSearch = By.xpath("//a[@class='QuickSearchPlaceholderLink-placeholder-1Wxzp6 QuickSearchPlaceholderLink-isPlaceholderSelected-rDCpKm Link-link-2n0yJn Link-default-2XA2bN     ']");

    private By btnSearchResult;
    private By textSearchFound = By.xpath("//div[@class='PrePlayLeftTitle-leftTitle-3RWvGy']");

    //Button to stream
    private By btnPlayMovie = By.xpath("//*[@id='content']/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[1]/div/a");

    //Add Movie to WatchList & Mark as played buttons
    private By btnWatchlist = By.xpath("//button[@class='ActionButton-iconActionButton-2ry8hd ActionButton-actionButton-2LOxoL Button-button-3A5jB3 Link-link-2ew_DK Button-button-3A5jB3 Link-link-2ew_DK Button-default-23k-Yy Button-medium-2d_jtE Link-default-1uNM9i     ']");
    private By btnPlayed = By.xpath("//button[@class='ActionButton-iconActionButton-2ry8hd ActionButton-actionButton-2LOxoL Button-button-3A5jB3 Link-link-2ew_DK Button-button-3A5jB3 Link-link-2ew_DK Button-default-23k-Yy Button-medium-2d_jtE Link-default-1uNM9i     ']");

    //Constructor
    public MoviePage(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        this.wait = new WebDriverWait(chromeDriver, 10);
    }

    /*
     * Search for a Video
     */
    public void searchVideo(String search){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tbSearch));
        btnSearchResult = By.xpath("//a[@title='"+search+"']");
        chromeDriver.findElement(tbSearch).sendKeys(search);
    }

    /*
     * Select the video
     */
    public void selectSearchResult(){
        wait.until(ExpectedConditions.elementToBeClickable(btnSearchResult));
        chromeDriver.findElement(btnSearchResult).click();
    }

    /*
     * Return the confirmation that the video has been found
     */
    public String searchFound(){
        wait.until(ExpectedConditions.elementToBeClickable(textSearchFound));
        String message = chromeDriver.findElement(textSearchFound).getText();
        return message;
    }

    /*
     * Start playing the video
     */
    public void playVideo(){
        wait.until(ExpectedConditions.elementToBeClickable(btnPlayMovie));
        chromeDriver.findElement(btnPlayMovie).click();
    }

    /*
     * add to Watchlist
     */
    public void addMovieToWatchList(){
        wait.until(ExpectedConditions.elementToBeClickable(btnWatchlist));
        chromeDriver.findElement(btnWatchlist).click();
    }

    /*
     * Mark the video as played
     */
    public void markAsPlayed(){
        wait.until(ExpectedConditions.elementToBeClickable(btnPlayed));
        chromeDriver.findElement(btnPlayed).click();
    }
}
