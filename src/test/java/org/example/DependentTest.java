package org.example;

import com.google.common.base.Verify;
import org.example.helpers.BaseTestWithLogin;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.example.helpers.Issues.ERROR_MESSAGE_HARD_ASSERT;
import static org.example.helpers.Issues.ERROR_MESSAGE_SOFT_ASSERT;

public class DependentTest extends BaseTestWithLogin {

    private static final String FIRST_ELEMENT_WRONG = "Sauce Labs New Backpack";
    private static final String FIRST_ELEMENT = "Sauce Labs Backpack";

    @Test(dependsOnMethods = {"hardAssertTest"})
    @Ignore
    public void softAssertTest() {
        String getFirstElement = homePage.getFirstItem();
        Verify.verify(getFirstElement.equals(FIRST_ELEMENT), ERROR_MESSAGE_SOFT_ASSERT);
    }

    @Test
    @Ignore
    public void softAssertSecondTest() {
        String getFirstElement = homePage.getFirstItem();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getFirstElement.equals(FIRST_ELEMENT), ERROR_MESSAGE_SOFT_ASSERT);
    }

    @Test
    @Ignore
    public void hardAssertTest() {
        String getFirstElement = homePage.getFirstItem();
        Assert.assertEquals(getFirstElement, FIRST_ELEMENT_WRONG, ERROR_MESSAGE_HARD_ASSERT);
    }
}
