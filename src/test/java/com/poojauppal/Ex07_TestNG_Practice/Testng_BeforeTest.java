package com.poojauppal.Ex07_TestNG_Practice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng_BeforeTest {
    // PUT Request -
    // 1. getToken
    // 2. getBookingId
    // 3. test_PUT ( which will use the above two methods)
    // 4. closeAllThings
    @BeforeTest
    public void getToken() {
        System.out.println("1");
    }

    @BeforeTest
    public void getBookingId() {
        System.out.println("2");
    }

    @Test
    public void test_PUT() {
        System.out.println("3");
    }

    @AfterTest
    public void closeAllThings() {
        System.out.println("4");
    }
}
