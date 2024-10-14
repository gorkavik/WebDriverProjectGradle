package org.example;

import org.example.helpers.BaseTestNoLogin;
import org.example.helpers.ConfProperties;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.example.helpers.Issues.ERROR_MESSAGE_AFTER_LOGIN;

public class LoginParametrizedTest extends BaseTestNoLogin {

    private static String expectedHomePageTitle = "Products";

    //--ниже пример использования паттерна DataProvider
    @DataProvider(name = "credentials")
    public Object[][] loginData() {
        return new Object[][]{{"standard_user", "secret_sauce"}, {"problem_user", "secret_sauce"}};
    }

    @Test(dataProvider = "credentials")
    public void validLoginParametrizedTest(String username, String password) {
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage.loginWithParameters(username, password);

        String getPageTitle = homePage.getPageTitle();
        Assert.assertEquals(getPageTitle, expectedHomePageTitle, ERROR_MESSAGE_AFTER_LOGIN);
    }
}