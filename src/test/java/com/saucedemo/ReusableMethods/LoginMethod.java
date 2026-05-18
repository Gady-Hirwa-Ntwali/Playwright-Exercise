package com.saucedemo.ReusableMethods;
import com.saucedemo.Base.BaseTest;

public class LoginMethod extends BaseTest {

    public static void login(String user, String pass) {
        page.getByPlaceholder("Username").fill(user);
        page.getByPlaceholder("Password").fill(pass);
        page.locator("#login-button").click();
    }

}
