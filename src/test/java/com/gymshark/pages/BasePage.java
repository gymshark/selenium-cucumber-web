package com.gymshark.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5, 1000);
        PageFactory.initElements(driver, this);
    }

    protected Actions actions() {
        return new Actions(driver);
    }

    protected void moveToElement(WebElement element) {
        new Actions(driver).moveToElement(element).build().perform();
    }

    protected void threadSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void waitForTextToBePresentInElement(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    protected void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected WebElement waitUntilVisibilityOfElement(String selector) {
        return wait.until(visibilityOfElementLocated(By.cssSelector(selector)));
    }

    protected List<WebElement> waitUntilVisibilityOfAllElements(String selector) {
        return wait.until(visibilityOfAllElementsLocatedBy(By.cssSelector(selector)));
    }

    protected String getActiveBreadcrumb() {
        return wait.until(visibilityOfElementLocated(By.cssSelector("nav[aria-label=\"Breadcrumb\"]" +
                " li[aria-current] span:nth-of-type(2)"))).getText();
    }

    public ArrayList<WebElement> checkAvailableSizesViaQuickAdd(WebElement item) {
        ArrayList<WebElement> availableSizeSelections = new ArrayList<>();

        List<WebElement> sizes = item.findElements(
                By.cssSelector("div[class*=\"Styles__Sizes\"] button"));

        for (WebElement size : sizes) {
            if (size.findElements(By.cssSelector("svg[class*=\"Strikethrough\"]")).size() == 0) {
                availableSizeSelections.add(size);
            }
        }
        return availableSizeSelections;
    }

    public void clickContinueBtn() {
        waitUntilVisibilityOfElement("button[id=\"continue_button\"]").click();
    }

}
