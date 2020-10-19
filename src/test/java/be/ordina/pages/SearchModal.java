package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchModal {
    private final WebDriver chromeDriver;
    private WebDriverWait wait;

    private By tbSearch = By.xpath("//input[@class='QuickSearchInput-searchInput-3m6naA']");
    private By textSearch = By.xpath("//a[@class='QuickSearchPlaceholderLink-placeholder-1Wxzp6 QuickSearchPlaceholderLink-isPlaceholderSelected-rDCpKm Link-link-2n0yJn Link-default-2XA2bN     ']");

    private By btnSearchResult;

    private By textSearchFound = By.xpath("//div[@class='PrePlayLeftTitle-leftTitle-3RWvGy']");

    public SearchModal(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        this.wait = new WebDriverWait(chromeDriver, 10);
    }

    public void searchVideo(String search){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tbSearch));
        btnSearchResult = By.xpath("//a[@title='"+search+"']");
        chromeDriver.findElement(tbSearch).sendKeys(search);
    }

    public void selectSearchResult(){
        wait.until(ExpectedConditions.elementToBeClickable(btnSearchResult));
         chromeDriver.findElement(btnSearchResult).click();

    }

    public String searchFound(){
        wait.until(ExpectedConditions.elementToBeClickable(textSearchFound));
        String message = chromeDriver.findElement(textSearchFound).getText();
        return message;
    }
}
