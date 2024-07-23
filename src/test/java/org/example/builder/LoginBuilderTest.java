package org.example.builder;

import org.example.helpers.ConfProperties;
import org.example.pageobject.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.helpers.Issues.ERROR_MESSAGE_AFTER_LOGIN;
import static org.example.helpers.Properties.WEBDRIVER_PROPERTY;

public class LoginBuilderTest {

    protected LoginPageWithBuilder loginPageWithBuilder;
    protected HomePage homePage;
    protected WebDriver driver;

    private static String expectedHomePageTitle = "Products";

    @BeforeTest
    public void setup() {
        System.setProperty(WEBDRIVER_PROPERTY, ConfProperties.getPropertyChrome());
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void builderExampleTest() {
        loginPageWithBuilder = new LoginPageWithBuilder.Builder(driver)
                .inputLogin(ConfProperties.getLogin())
                .inputPass(ConfProperties.getPassword())
                .build();
        loginPageWithBuilder.clickLoginBtn();
        String getPageTitle = homePage.getPageTitle();

        Assert.assertEquals(getPageTitle, expectedHomePageTitle, ERROR_MESSAGE_AFTER_LOGIN);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
