package com.saucedemo.TestCases.ProductBrowsing;

import com.microsoft.playwright.Locator;
import com.saucedemo.Base.BaseTest;
import com.saucedemo.TestCases.Authentication.LoginValidTest;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class ProductDetailTest extends BaseTest {

    @Test
    public void productDetailTest(){
        LoginValidTest.testLoginAsStandardUser();

        Locator product = page.locator(".inventory_item_name")
                .filter(new Locator.FilterOptions().setHasText("Sauce Labs Backpack"));
        product.click();

        String productDetailTitle = page.locator(".inventory_details_name.large_size").textContent();

        assertEquals("Sauce Labs Backpack", productDetailTitle);
    }
}
