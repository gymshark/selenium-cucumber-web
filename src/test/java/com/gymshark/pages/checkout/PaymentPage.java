package com.gymshark.pages.checkout;

import com.gymshark.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PaymentPage extends BasePage {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public static PaymentPage getPaymentPage(WebDriver driver) {
        return new PaymentPage(driver);
    }

    public void assertPaymentBreadCrumbIsActive() {
        Assert.assertEquals("PAYMENT", getActiveBreadcrumb());
    }
}
