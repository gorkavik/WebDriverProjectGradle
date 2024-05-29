package org.example;

import org.example.helpfiles.ConfProperties;
import org.example.helpfiles.HomePage;
import org.example.helpfiles.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginParametrizedTest {

    private static final String ERROR_MESSAGE_AFTER_LOGIN = "Пользователь не вошел";
    private static final String WEBDRIVER_PROPERTY = "webdriver.chrome.driver";

    public static LoginPage loginPage;
    public static HomePage homePage;
    public static WebDriver driver;
    private static String expectedHomePageTitle = "Products";

    @DataProvider(name = "credentials")
    public Object[][] loginData() {
        return new Object[][]{{"standard_user", "secret_sauce"}, {"problem_user", "secret_sauce"}};
    }

    @BeforeTest
    public static void setup() {
        System.setProperty(WEBDRIVER_PROPERTY, ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();

    }

    @Test(dataProvider = "credentials")
    public static void validLoginParametrizedTest(String username, String password) {
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage.inputLogin(username);
        loginPage.inputPasswd(password);
        loginPage.clickLoginBtn();

        String getPageTitle = homePage.getPageTitle();
        Assert.assertEquals(getPageTitle, expectedHomePageTitle, ERROR_MESSAGE_AFTER_LOGIN);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public static void tearDown() {
        driver.quit();
    }

}
