package com.mycompany.openforbeta.tests;

import com.mycompany.openforbeta.pages.*;
import com.mycompany.openforbeta.pages.common.*;
import com.mycompany.openforbeta.utils.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *  contains tests for login functionality
 */
public class LoginTest extends BaseTest
{
    @Test
    public void testInvalidLogin()
    {
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.getUrl("http://www.openforbeta.com/");
        LoginPageObject loginForm = basePage.openLoginPopup();
        loginForm.loginUser(PropertyReader.getStringPropertyValue("user.login.invalid"), "notValidPassword");
        Assert.assertEquals(loginForm.getWrongLoginMessage(),  LoginPageObject.WRONG_LOGIN_MESSAGE, "Error message is different from expected");
    }
}
