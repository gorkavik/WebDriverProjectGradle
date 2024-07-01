package org.example.helpfiles;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    public Object[][] loginData() {
        return new Object[][]{{"standard_user", "secret_sauce"}, {"problem_user", "secret_sauce"}};
    }

}
