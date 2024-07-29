package org.example.helpers;

import org.example.pageobject.HomePage;
import org.example.pageobject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static org.example.helpers.Properties.WEBDRIVER_PROPERTY;

public class BaseTestWithLogin implements SetupPage {

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected WebDriver driver;

    //--ниже реализация паттерна Strategy, для этого создан интерфейс SetupPage
    @BeforeClass
    @Override
    public void setup() {
        System.setProperty(WEBDRIVER_PROPERTY, ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage.loginFromProperties();
    }

    @AfterClass
    @Override
    public void tearDown() {
        driver.quit();
    }
}
