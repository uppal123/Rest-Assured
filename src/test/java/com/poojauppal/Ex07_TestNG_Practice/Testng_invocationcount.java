package com.poojauppal.Ex07_TestNG_Practice;

import org.testng.annotations.Test;

public class Testng_invocationcount {

    @Test(invocationCount = 5)  //runs testcase given no. of times
    public void test01() {
        System.out.println("tc1");
    }
}
