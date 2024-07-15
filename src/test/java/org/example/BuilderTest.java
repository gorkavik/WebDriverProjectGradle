package org.example;

import org.example.helpers.ConfProperties;
import org.example.pageobject.HomePage;
import org.example.pageobject.LoginPage;
import org.example.pageobject.LoginPageBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.helpers.Properties.WEBDRIVER_PROPERTY;

public class BuilderTest {

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected WebDriver driver;
    private static final String ERROR_MESSAGE_AFTER_LOGIN = "Пользователь не вошел";

    private static String expectedHomePageTitle = "Products";

    @BeforeTest
    public void setup() {
        System.setProperty(WEBDRIVER_PROPERTY, ConfProperties.getPropertyChrome());
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }


    @Test
    public void builderExampleTest() {
        LoginPageBuilder loginPageCreated = new LoginPageBuilder
                .Builder()
                .inputLogin(ConfProperties.getLogin())
                .inputPass(ConfProperties.getPassword())
                .build();
        loginPageCreated.clickLoginBtn();

        String getPageTitle = homePage.getPageTitle();
        Assert.assertEquals(getPageTitle, expectedHomePageTitle, ERROR_MESSAGE_AFTER_LOGIN);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
