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
        String login = PropReader.getStringPropValue("user.login.notregistered");
        String password = PropReader.getStringPropValue("user.password.notregistered");

        BasePage basePage = new BasePage(getDriver());
        basePage.getUrl("http://www.openforbeta.com/");
        LoginPageObject loginForm = basePage.openLoginPopup();
        loginForm.loginUser(login, password);
        Assert.assertEquals(loginForm.getWrongLoginMessage(), LoginPageObject.WRONG_LOGIN_MESSAGE, "Error message is different from expected");
    }

    @Test
    public void testValidLogin()
    {
        String login = PropReader.getStringPropValue("user.login.registered");
        String password = PropReader.getStringPropValue("user.password.registered");

        BasePage basePage = new BasePage(getDriver());
        basePage.getUrl("http://www.openforbeta.com/");
        LoginPageObject loginForm = basePage.openLoginPopup();
        loginForm.loginUser(login, password);
        Assert.assertEquals(basePage.getLoggdInUsername(), login, "User name is different from expected");
        basePage.logoutUser(getDriver());
    }
}
