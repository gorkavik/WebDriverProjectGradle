package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewClass {

    @Test
    public void testHardAssert() {
        int a = 2;
        int b = 3;

        Assert.assertEquals(a+b, 5);
        Assert.assertTrue(a>b);
    }

    @Test
    public void testSoftAssert() {
        int a = 5;
        int b = 3;

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(a+b, 8,"a+b");
        System.out.println("jshfkshksdjhk");
        softAssert.assertTrue(a<b,"a<b");
        System.out.println("kdjhfgkdhg");
        softAssert.assertAll();
    }
}