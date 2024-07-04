package org.example;

import org.example.helpfiles.BaseTestNoLogin;
import org.example.helpfiles.ConfProperties;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginParametrizedTest extends BaseTestNoLogin {

    private static final String ERROR_MESSAGE_AFTER_LOGIN = "Пользователь не вошел";

    private static String expectedHomePageTitle = "Products";

    // ниже пример использования паттерна DataProvider
    @DataProvider(name = "credentials")
    public Object[][] loginData() {
        return new Object[][]{{"standard_user", "secret_sauce"}, {"problem_user", "secret_sauce"}};
    }

    @Test(dataProvider = "credentials")
    public static void validLoginParametrizedTest(String username, String password) {
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage.loginWithParameters(username, password);

        String getPageTitle = homePage.getPageTitle();
        Assert.assertEquals(getPageTitle, expectedHomePageTitle, ERROR_MESSAGE_AFTER_LOGIN);
    }
}
