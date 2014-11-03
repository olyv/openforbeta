package com.mycompany.openforbeta.tests;

import com.mycompany.openforbeta.pages.BasePage;
import com.mycompany.openforbeta.pages.SignUpPage;
import com.mycompany.openforbeta.utils.PropReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * contains tests for signup functionality
 */
public class SignUpTest extends BaseTest
{
    @Test
    public void testEmptyCaptcha()
    {
        String login = PropReader.getStringPropValue("user.login.notregistered");
        String password = PropReader.getStringPropValue("user.password.notregistered");
        String email = PropReader.getStringPropValue("user.email.notregistered");

        BasePage basePage = new BasePage(getDriver());
        basePage.getUrl("http://www.openforbeta.com/");
        SignUpPage signUpPage = basePage.openSignUpPage();
        signUpPage.enterUserCredentials(login, password, email);
        Assert.assertEquals(signUpPage.getResultMessage(), SignUpPage.WRONG_CAPTCHA, "Error message is different from expected");
    }

    @Test
    public void testSignupExistentUser()
    {
        String login = PropReader.getStringPropValue("user.login.registered");
        String password = PropReader.getStringPropValue("user.password.registered");
        String email = PropReader.getStringPropValue("user.email.registered");

        BasePage basePage = new BasePage(getDriver());
        basePage.getUrl("http://www.openforbeta.com/");
        SignUpPage signUpPage = basePage.openSignUpPage();
        signUpPage.enterUserCredentials(login, password, email);
        Assert.assertEquals(signUpPage.getResultMessage(), SignUpPage.ALREADY_TAKEN_USERNAME, "Error message is different from expected");
    }
}
