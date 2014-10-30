package com.mycompany.openforbeta.tests;

import com.mycompany.openforbeta.pages.BasePage;
import com.mycompany.openforbeta.pages.common.LoginPageObject;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 *  contains tests for login functionality
 */
public class LoginTest extends BaseTest
{
    @Test
    public void testLogin()
    {
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.getUrl("http://www.openforbeta.com/");
        LoginPageObject loginForm = basePage.openLoginPopup();
        loginForm.loginUser("asd", "asd");
    }
}
