package com.saucedemo.TestCases.CheckoutFlow;

import com.microsoft.playwright.Locator;
import com.saucedemo.Base.BaseTest;
import com.saucedemo.TestCases.CartFunctionality.AddProductsToCart;
import org.testng.annotations.Test;

import static com.saucedemo.TestCases.CartFunctionality.AddProductsToCart.addProductToCart;

public class CheckoutTest extends BaseTest {
    @Test
    public void checkoutTest(){
        addProductToCart();

        Locator continueToCheckout = page.locator("#checkout");
        continueToCheckout.click();

        Locator firstName = page.locator("#first-name");
        firstName.fill("am not");
        Locator lastName = page.locator("#last-name");
        lastName.fill("human");
        Locator zipcode = page.locator("#postal-code");
        zipcode.fill("0000");

        Locator continueToReport = page.locator("#continue");
        continueToReport.click();
    }
}
