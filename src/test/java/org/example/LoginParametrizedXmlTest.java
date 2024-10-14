package org.example;

import org.example.helpers.BaseTestNoLogin;
import org.example.helpers.ConfProperties;
import org.example.pageobject.HomePage;
import org.example.pageobject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.example.helpers.Issues.ERROR_MESSAGE_AFTER_LOGIN;

public class LoginParametrizedXmlTest extends BaseTestNoLogin {

    public static LoginPage loginPage;
    public static HomePage homePage;
    public static WebDriver driver;
    private static String expectedHomePageTitle = "Products";

    @Test
    @Parameters({"paramNameLogin", "paramNamePassword"})
    public void validLoginParametrizedTest(String username, String password) {
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage.loginWithParameters(username, password);

        String getPageTitle = homePage.getPageTitle();
        Assert.assertEquals(getPageTitle, expectedHomePageTitle, ERROR_MESSAGE_AFTER_LOGIN);
    }
}
