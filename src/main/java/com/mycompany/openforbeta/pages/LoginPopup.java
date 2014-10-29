package com.mycompany.openforbeta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPopup
{
    @FindBy(name = "lusername")
    private WebElement userNameField;

    @FindBy(name = "lpassword")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public LoginPopup(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void loginUser(String username, String password)
    {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
    }
}
