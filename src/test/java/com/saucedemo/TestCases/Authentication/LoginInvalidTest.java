package com.saucedemo.TestCases.Authentication;

import com.saucedemo.Base.BaseTest;
import com.saucedemo.ReusableMethods.LoginMethod;
import com.saucedemo.Utilities.UserCredentials;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class LoginInvalidTest extends BaseTest {

    @Test
    public void testLoginWithInvalidUserName(){
        String user = "dskljfoklds";
        String pass = UserCredentials.STANDARD_USER.getPassword();
        LoginMethod.login(user, pass);
        assertEquals(page.locator("h3").innerText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void testLoginWithInvalidPassWord(){
        String user = UserCredentials.STANDARD_USER.getUsername();
        String pass = "dlkfj";
        LoginMethod.login(user, pass);
        assertEquals(page.locator("h3").innerText(), "Epic sadface: Username and password do not match any user in this service");
    }
}
