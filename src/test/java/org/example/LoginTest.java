package org.example;

import org.example.helpfiles.ConfProperties;
import org.example.helpfiles.HomePage;
import org.example.helpfiles.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    private static final String ERROR_MESSAGE_AFTER_LOGIN = "Пользователь не вошел";
    private static final String ERROR_MESSAGE_TITLE = "Нет заголовка";
    private static final String WEBDRIVER_PROPERTY = "webdriver.chrome.driver";

    public static LoginPage loginPage;
    public static HomePage homePage;
    public static WebDriver driver;
    private static String expectedHomePageTitle = "Products";

    @BeforeTest
    public static void setup() {
        System.setProperty(WEBDRIVER_PROPERTY, ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public static void titleExist() {
        //--ниже применение Chain of invocations
        Assert.assertTrue(driver.findElement(By.className("login_logo")).getText().contains("Swag Labs"), ERROR_MESSAGE_TITLE);
    }


    @Test
    public static void validLoginTest() {
        loginPage.loginFromProperties();

        String getPageTitle = homePage.getPageTitle();
        Assert.assertEquals(getPageTitle, expectedHomePageTitle, ERROR_MESSAGE_AFTER_LOGIN);
    }

    @AfterTest
    public static void tearDown() {
        driver.quit();
    }
}
