package org.example.helpfiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestNoLogin {

    protected static final String WEBDRIVER_PROPERTY = "webdriver.chrome.driver";

    protected static LoginPage loginPage;
    protected static HomePage homePage;
    protected static WebDriver driver;

    @BeforeTest
    public static void setup() {
        System.setProperty(WEBDRIVER_PROPERTY, ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @AfterTest
    public static void tearDown() {
        driver.quit();
    }
}
