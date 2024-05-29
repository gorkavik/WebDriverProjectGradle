package org.example;

import com.google.common.base.Verify;
import org.example.helpfiles.ConfProperties;
import org.example.helpfiles.HomePage;
import org.example.helpfiles.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HardAndSoftAssertTest {
    private static final String ERROR_MESSAGE_HARD_ASSERT = "Hard assert error - не совпадает";
    private static final String ERROR_MESSAGE_SOFT_ASSERT = "Soft assert error - не совпадает";
    private static final String WEBDRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String FIRST_ELEMENT = "Sauce Labs New Backpack";

    public static LoginPage loginPage;
    public static HomePage homePage;
    public static WebDriver driver;

    @BeforeTest
    public static void setup() {
        System.setProperty(WEBDRIVER_PROPERTY, ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
    }

    @Test
    public static void softAssertTest()  {
        String getFirstElement = homePage.getFirstItem();
        Verify.verify(getFirstElement.equals("Sauce Labs Backpack"),ERROR_MESSAGE_SOFT_ASSERT);
        System.out.println("Continue soft assert test");
    }
    @Test
    public static void hardAssertTest()  {
        String getFirstElement = homePage.getFirstItem();
        Assert.assertEquals(FIRST_ELEMENT, getFirstElement, ERROR_MESSAGE_HARD_ASSERT );
        System.out.println("Continue hard assert test");
    }

    @AfterTest
    public static void tearDown() {
        driver.quit(); }

}
