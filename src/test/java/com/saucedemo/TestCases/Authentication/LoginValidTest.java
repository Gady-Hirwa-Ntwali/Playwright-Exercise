package com.saucedemo.TestCases.Authentication;

import com.saucedemo.Base.BaseTest;
import com.saucedemo.ReusableMethods.LoginMethod;
import com.saucedemo.Utilities.UserCredentials;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;


public class LoginValidTest extends BaseTest {

    @Test
    public static void testLoginAsStandardUser(){
        String user = UserCredentials.STANDARD_USER.getUsername();
        String pass = UserCredentials.STANDARD_USER.getPassword();
        LoginMethod.login(user, pass);
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testLoginAsLockedOutUser(){
        String user = UserCredentials.LOCKED_OUT_USER.getUsername();
        String pass = UserCredentials.LOCKED_OUT_USER.getPassword();
        LoginMethod.login(user, pass);
        assertEquals(page.locator("h3").innerText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void testLoginAsProblemUser(){
        String user = UserCredentials.PROBLEM_USER.getUsername();
        String pass = UserCredentials.PROBLEM_USER.getPassword();
        LoginMethod.login(user, pass);
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");

    }

    @Test
    public void testLoginAsPerformanceGlitchUser(){
        String user = UserCredentials.PERFORMANCE_GLITCH_USER.getUsername();
        String pass = UserCredentials.PERFORMANCE_GLITCH_USER.getPassword();
        LoginMethod.login(user, pass);
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testLoginAsErrorUser(){
        String user = UserCredentials.ERROR_USER.getUsername();
        String pass = UserCredentials.ERROR_USER.getPassword();
        LoginMethod.login(user, pass);
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testLoginAsVisualUser(){
        String user = UserCredentials.VISUAL_USER.getUsername();
        String pass = UserCredentials.VISUAL_USER.getPassword();
        LoginMethod.login(user, pass);
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");

    }
}
