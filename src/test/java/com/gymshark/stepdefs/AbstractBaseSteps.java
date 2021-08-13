package com.gymshark.stepdefs;

import com.gymshark.core.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gymshark.core.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class AbstractBaseSteps {

    private WebDriverManager webDriverManager;
    private WebDriver webDriver;

    public AbstractBaseSteps() {
        this.webDriverManager = WebDriverManager.getInstance();
    }

    public WebDriver getWebDriver() {
        if (this.webDriver == null) {
            this.webDriver = webDriverManager.getWebDriver();
        }
        return this.webDriver;
    }

    public String getTestEndpoint() {
        return WebDriverFactory.getInstance().getTestEndpoint();
    }

    public void closeCookies() {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 15);

        WebElement cookiesBanner = wait.until(visibilityOfElementLocated(
                By.cssSelector("div[id*=\"onetrust-banner\"]")));

        WebElement acceptBtn = cookiesBanner.findElement(By.cssSelector("button[id*=\"onetrust-accept\"]"));
        wait.until(elementToBeClickable(acceptBtn));

        new Actions(getWebDriver()).moveToElement(acceptBtn).click(acceptBtn).build().perform();
        wait.until(invisibilityOf(cookiesBanner));
    }
}
