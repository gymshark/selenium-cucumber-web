package com.gymshark.pages.checkout;

import com.gymshark.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends BasePage {

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public static ShippingPage getShippingPage(WebDriver driver){
        return new ShippingPage(driver);
    }

    public void waitUntilVisibilityOfShippingMethod() {
        waitUntilVisibilityOfElement("div[data-step=\"shipping_method\"]");
    }
}
