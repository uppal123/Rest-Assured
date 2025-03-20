package com.poojauppal.Ex08_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG {

    @Test
    public void test_HardAssert () {
        System.out.println("Start of a program");
        Boolean ismarried = true;
        Assert.assertEquals("Pooja", "pooja");
        System.out.println("End of a program");
    }

    @Test
    public void test_StartAssert() {
        System.out.println("Start of the Program");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(false);
        System.out.println("End of the Program");
        sa.assertAll(); //cz of asserAll(), it will run complete program
    }
}
