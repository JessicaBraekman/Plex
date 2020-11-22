package be.ordina.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoviePage {
    private final WebDriver driver;
    private WebDriverWait wait;

    //User
    private By btnUser = By.xpath("*[@id='id-10']");
    private By btnAccount = By.xpath("a[@href='#!/settings/account']");

    //Search
    private By tbSearch = By.xpath("//input[@class='QuickSearchInput-searchInput-3m6naA']");
    private By textSearch = By.xpath("//a[@class='QuickSearchPlaceholderLink-placeholder-1Wxzp6 QuickSearchPlaceholderLink-isPlaceholderSelected-rDCpKm Link-link-2n0yJn Link-default-2XA2bN     ']");

    private By btnSearchResult;
    private By textSearchFound = By.xpath("//div[@class='PrePlayLeftTitle-leftTitle-3RWvGy']");

    //Button to stream
    private By btnPlayMovie = By.xpath("//*[@id=\"content\"]/div/div/div[3]/div[2]/div[1]/div[3]/div/div[2]/div/div/div[1]/div/a");

    //Button to pause
    private By btnPauseMovie = By.xpath("//button[@title='Pause']");

    //Add Movie to WatchList buttons
    private By btnWatchlist = By.xpath("//button[@class='ActionButton-iconActionButton-2ry8hd ActionButton-actionButton-2LOxoL Button-button-3A5jB3 Link-link-2ew_DK Button-button-3A5jB3 Link-link-2ew_DK Button-default-23k-Yy Button-medium-2d_jtE Link-default-1uNM9i     ']");

    //Mark Movie as played buttons
    private By btnMarkAsPlayed = By.xpath("//*[@id='plex-icon-toolbar-mark-played-560']");
    private By btnMarkAsUnPlayed = By.xpath("//*[@id='plex-icon-toolbar-mark-unplayed-560']");
    private By btnPlayedConfirmation = By.xpath("/html/body/div[2]/div/div/div/div[3]/div/button[2]/span[2]");


    //Constructor
    public MoviePage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    /*
     * Go to userAccount
     */
    public void goToAccount(){
        wait.until(ExpectedConditions.elementToBeClickable(btnUser));
        driver.findElement(btnUser).click();
    }

    /*
     * Search for a Video
     */
    public void searchVideo(String search){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tbSearch));
        btnSearchResult = By.xpath("//a[@title='"+search+"']");
        driver.findElement(tbSearch).sendKeys(search);
    }

    /*
     * Select the video
     */
    public void selectSearchResult(){
        wait.until(ExpectedConditions.elementToBeClickable(btnSearchResult));
        driver.findElement(btnSearchResult).click();
    }

    /*
     * Return the confirmation that the video has been found
     */
    public String searchFound(){
        wait.until(ExpectedConditions.elementToBeClickable(textSearchFound));
        String message = driver.findElement(textSearchFound).getText();
        return message;
    }

    /*
     * Start playing the video
     */
    public void playVideo(){
        wait.until(ExpectedConditions.elementToBeClickable(btnPlayMovie));
        driver.findElement(btnPlayMovie).click();
    }

    public String MovieIsPlaying(){
        wait.until(ExpectedConditions.elementToBeClickable(btnPauseMovie));
        String message = driver.findElement(btnPauseMovie).getAttribute("title");
        return message;
    }

    /*
     * add to Watchlist
     */
    public void addMovieToWatchList(){
        wait.until(ExpectedConditions.elementToBeClickable(btnWatchlist));
        driver.findElement(btnWatchlist).click();
    }

    public String checkIfAddedOrRemovedFromWatchList(){
        wait.until(ExpectedConditions.elementToBeClickable(btnWatchlist));
        String check = driver.findElement(btnWatchlist).getAttribute("data-qa-id");
        return check;
    }

    /*
     * Mark the video as played
     */
    public void markAsPlayed(){
        wait.until(ExpectedConditions.elementToBeClickable(btnMarkAsPlayed));
        driver.findElement(btnMarkAsPlayed).click();

        wait.until(ExpectedConditions.elementToBeClickable(btnPlayedConfirmation));
        driver.findElement(btnPlayedConfirmation).click();
    }

    public void unMarkAsPlayed(){
        wait.until(ExpectedConditions.elementToBeClickable(btnMarkAsUnPlayed));
        driver.findElement(btnMarkAsUnPlayed).click();

        wait.until(ExpectedConditions.elementToBeClickable(btnPlayedConfirmation));
        driver.findElement(btnPlayedConfirmation).click();
    }

    public String checkIfMarkedAsPlayed(){
        wait.until(ExpectedConditions.elementToBeClickable(btnMarkAsUnPlayed));
        String message = driver.findElement(btnMarkAsUnPlayed).getAttribute("id");
        System.out.println(message);
        return message;
    }

    public String checkUnMarkedAsPlayed(){
        wait.until(ExpectedConditions.elementToBeClickable(btnMarkAsPlayed));
        String message = driver.findElement(btnMarkAsPlayed).getAttribute("id");
        System.out.println(message);
        return message;
    }
}
