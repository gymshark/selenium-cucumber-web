package com.gymshark.pages.checkout;

import com.gymshark.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class InformationPage extends BasePage {

    public InformationPage(WebDriver driver) {
        super(driver);
    }

    public static InformationPage getInformationPage(WebDriver driver) {
        return new InformationPage(driver);
    }

    public void waitUntilInformationFieldsHaveLoaded() {
        waitUntilVisibilityOfElement("div[class=\"main__content\"]");
    }

    public void populateContactAndShippingInformationFields() {
        String[] fields = {"Email", "First name", "Last name", "Address Line 1",
                "City", "Postcode", "Phone"};

        HashMap<String, String> info = new HashMap<>();
        info.put("Email", "testuser0@gymshark.com");
        info.put("First name", "Test");
        info.put("Last name", "User0");
        info.put("Address Line 1", "12 Test Avenue");
        info.put("City", "Testerhampton");
        info.put("Postcode", "B90 8AJ");
        info.put("Phone", "01234567");

        threadSleep(2000);

        for (String f : fields) {
                WebElement field = driver.findElement(By.cssSelector("input[placeholder=\"" + f + "\"]"));
                actions().moveToElement(field).click(field).sendKeys(info.get(f)).build().perform();
            }
    }
}
