package com.gymshark.pages.search;

import com.gymshark.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public static SearchPage getSearchPage(WebDriver driver) {
        return new SearchPage(driver);
    }

    public void searchForItem(String item) {
        driver.findElement(By.cssSelector("button[class*=\"Styles__Search\"]")).click();
        WebElement searchField = waitUntilVisibilityOfSearchBar();

        moveToElement(searchField);
        actions().click(searchField).sendKeys(item).build().perform();
    }

    public List<WebElement> getSearchResults() {
        return waitUntilVisibilityOfAllElements("div[class*=\"Styles__Grid\"] article");
    }

    public WebElement waitUntilVisibilityOfSearchBar() {
        return waitUntilVisibilityOfElement("div[class*=\"Styles__SearchBarWrapper\"]");
    }

    public void moveToProduct(WebElement item) {
        threadSleep(2000);
        actions().moveToElement(item).build().perform();
    }

    public void selectAvailableSizeViaQuickAdd(int item) {
        WebElement searchResult = getSearchResults().get(item);

        actions().moveToElement(searchResult).build().perform();
        checkAvailableSizesViaQuickAdd(searchResult).get(0).click();
    }
}
