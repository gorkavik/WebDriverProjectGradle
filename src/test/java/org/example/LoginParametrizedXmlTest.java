package org.example;

import org.example.helpfiles.BaseTestNoLogin;
import org.example.helpfiles.ConfProperties;
import org.example.helpfiles.HomePage;
import org.example.helpfiles.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginParametrizedXmlTest extends BaseTestNoLogin {

    private static final String ERROR_MESSAGE_AFTER_LOGIN = "Пользователь не вошел";
    private static final String WEBDRIVER_PROPERTY = "webdriver.chrome.driver";

    public static LoginPage loginPage;
    public static HomePage homePage;
    public static WebDriver driver;
    private static String expectedHomePageTitle = "Products";

    @Test
    @Parameters({"paramNameLogin", "paramNamePassword"})
    public static void validLoginParametrizedTest(String username, String password) {
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage.loginWithParameters(username, password);

        String getPageTitle = homePage.getPageTitle();
        Assert.assertEquals(getPageTitle, expectedHomePageTitle, ERROR_MESSAGE_AFTER_LOGIN);
    }
}
