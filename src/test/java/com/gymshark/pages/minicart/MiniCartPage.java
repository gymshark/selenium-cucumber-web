package com.gymshark.pages.minicart;

import com.gymshark.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class MiniCartPage extends BasePage {

    public static String miniCartSelector = "div[id=\"minicart\"]";

    public MiniCartPage(WebDriver driver) {
        super(driver);
    }

    public static MiniCartPage getMiniCartPage(WebDriver driver) {
        return new MiniCartPage(driver);
    }

    public void assertBagContainsAddedItems(int expectedValue) {
        WebElement yourBagElement = waitUntilVisibilityOfElement(miniCartSelector);

        List<WebElement> itemsInBag = yourBagElement.findElements(
                By.cssSelector("div[class*=\"grid__item\"]"));

        assertEquals(itemsInBag.size(), expectedValue);
    }

    public void clickCheckoutBtn() {
        driver.findElement(By.cssSelector("button[name=\"checkout\"]")).click();
    }

    public void closeMiniCart() {
        driver.findElement(By.cssSelector("button[id=\"minicart-close\"]")).click();
    }

    public void waitUntilInvisibilityOfMiniCart() {
        waitUntilVisibilityOfElement(miniCartSelector);
    }

}
