package com.saucedemo.TestCases.CartFunctionality;

import com.microsoft.playwright.Locator;
import com.saucedemo.Base.BaseTest;
import com.saucedemo.TestCases.Authentication.LoginValidTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddProductsToCart extends BaseTest {

    @Test
    public static void addProductToCart(){
        LoginValidTest.testLoginAsStandardUser();

        String productName = page.locator("#item_4_title_link").textContent();
        page.locator("#add-to-cart-sauce-labs-backpack").click();

        Locator navigateToCart = page.locator("#shopping_cart_container");
                navigateToCart.click();

        String productAddedToCart = page.locator(".inventory_item_name").textContent();

        assertEquals(productAddedToCart, productName);
    }
}
