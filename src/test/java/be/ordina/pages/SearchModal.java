package be.ordina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchModal {
    private final WebDriver chromeDriver;
    private WebDriverWait wait;

    private By tbSearch = By.xpath("//input[@class='QuickSearchInput-searchInput-3m6naA']");
    private By textSearch = By.xpath("//div[@class='QuickSearchResults-container-3IlHhN  Scroller-scroller-3GqQcZ Scroller-vertical-VScFLT']");

    private By btnSearchResult = By.xpath("//a[@title='Aspe']");

    public SearchModal(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        this.wait = new WebDriverWait(chromeDriver, 10);
    }

    public void searchVideo(String search){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tbSearch));

        WebElement elSearch =chromeDriver.findElement(tbSearch);
        elSearch.sendKeys(search);
        elSearch.submit();
    }

    public void selectSearchResult(){
    wait.until(ExpectedConditions.elementToBeClickable(btnSearchResult));
    chromeDriver.findElement(btnSearchResult).click();

    }

    public String searchContainer() {
        wait.until(ExpectedConditions.elementToBeClickable(textSearch));
        String message = chromeDriver.findElement(textSearch).getText();
        return message;
    }
}
