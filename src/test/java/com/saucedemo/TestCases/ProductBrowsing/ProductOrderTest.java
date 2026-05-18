package com.saucedemo.TestCases.ProductBrowsing;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;
import com.saucedemo.Base.BaseTest;
import com.saucedemo.TestCases.Authentication.LoginValidTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ProductOrderTest extends BaseTest {

    @Test
    public void orderNameAToZ(){
        LoginValidTest.testLoginAsStandardUser();

        List<String> uiNames = page.locator(".inventory_item_name").allInnerTexts();
        System.out.println(uiNames);

        List<String> expectedNames = new ArrayList<>(uiNames);
        Collections.sort(expectedNames);
        System.out.println(expectedNames);


        Locator dropdown = page.locator(".product_sort_container");
        dropdown.selectOption(new SelectOption().setValue("az"));

        assertEquals(uiNames, expectedNames);
    }

    @Test
    public void orderNameZToA(){
        LoginValidTest.testLoginAsStandardUser();

        List<String> uiNames = page.locator(".inventory_item_name").allInnerTexts();
        System.out.println(uiNames);

        List<String> expectedNames = new ArrayList<>(uiNames);
        expectedNames.sort(Collections.reverseOrder());
        System.out.println(expectedNames);

        Locator dropdown = page.locator(".product_sort_container");
        dropdown.selectOption(new SelectOption().setValue("za"));

        List<String> uiNamesAfterSort = page.locator(".inventory_item_name").allInnerTexts();
        System.out.println(uiNamesAfterSort);

        assertEquals(expectedNames, uiNamesAfterSort);

    }

    @Test
    public void orderProductPriceHighToLow(){
        LoginValidTest.testLoginAsStandardUser();
        List<String> uiPrices = page.locator(".inventory_item_price").allInnerTexts();
        System.out.println(uiPrices);

        List<Double> actualPrice = new ArrayList<>();
        for(String s : uiPrices){
            actualPrice.add(Double.parseDouble(s.replace("$", "")));
        }
        actualPrice.sort(Collections.reverseOrder());
        System.out.println(actualPrice);

        Locator dropdown = page.locator(".product_sort_container");
        dropdown.selectOption(new SelectOption().setValue("hilo"));
        List<String> uiPricesAfterSort = page.locator(".inventory_item_price").allInnerTexts();
        List<Double> actualPriceAfterSort = new ArrayList<>();
        for(String s : uiPricesAfterSort){
            actualPriceAfterSort.add(Double.parseDouble(s.replace("$", "")));
        }
        System.out.println(actualPriceAfterSort);
        assertEquals(actualPriceAfterSort, actualPrice);
    }

    @Test
    public void orderProductPriceLowToHigh(){
        LoginValidTest.testLoginAsStandardUser();
        List<String> uiPrices = page.locator(".inventory_item_price").allInnerTexts();
        System.out.println(uiPrices);

        List<Double> actualPrice = new ArrayList<>();
        for(String s : uiPrices){
            actualPrice.add(Double.parseDouble(s.replace("$", "")));
        }
        Collections.sort(actualPrice);
        System.out.println(actualPrice);
 
        Locator dropdown = page.locator(".product_sort_container");
        dropdown.selectOption(new SelectOption().setValue("lohi"));
        List<String> uiPricesAfterSort = page.locator(".inventory_item_price").allInnerTexts();
        List<Double> actualPriceAfterSort = new ArrayList<>();
        for(String s : uiPricesAfterSort){
            actualPriceAfterSort.add(Double.parseDouble(s.replace("$", "")));
        }
        System.out.println(actualPriceAfterSort);
        assertEquals(actualPriceAfterSort, actualPrice);
    }
}