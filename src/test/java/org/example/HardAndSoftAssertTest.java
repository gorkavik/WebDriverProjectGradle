package org.example;

import com.google.common.base.Verify;
import org.example.helpers.BaseTestWithLogin;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAndSoftAssertTest extends BaseTestWithLogin {

    private static final String ERROR_MESSAGE_HARD_ASSERT = "Hard assert error - не совпадает";
    private static final String ERROR_MESSAGE_SOFT_ASSERT = "Soft assert error - не совпадает";
    private static final String FIRST_ELEMENT_WRONG = "Sauce Labs New Backpack";
    private static final String FIRST_ELEMENT = "Sauce Labs Backpack";

    @Test
    public void softAssertTest() {
        String getFirstElement = homePage.getFirstItem();
        Verify.verify(getFirstElement.equals(FIRST_ELEMENT), ERROR_MESSAGE_SOFT_ASSERT);
        System.out.println("Continue soft assert test");
    }

    @Test
    public void softAssertSecondTest() {
        String getFirstElement = homePage.getFirstItem();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getFirstElement.equals(FIRST_ELEMENT), ERROR_MESSAGE_SOFT_ASSERT);
        System.out.println("Continue soft assert second test");
    }

    @Test
    public void hardAssertTest() {
        String getFirstElement = homePage.getFirstItem();
        Assert.assertEquals(getFirstElement, FIRST_ELEMENT_WRONG, ERROR_MESSAGE_HARD_ASSERT);
        System.out.println("Continue hard assert test");
    }
}
