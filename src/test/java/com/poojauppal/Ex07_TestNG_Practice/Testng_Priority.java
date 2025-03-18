package com.poojauppal.Ex07_TestNG_Practice;

import org.testng.annotations.Test;

public class Testng_Priority {

    @Test (priority = 1)
    public void test_run() {
        System.out.println("I am running first");
    }

    @Test (priority = 3)
    public void test_run2() {
        System.out.println("I am running third");
    }
    @Test(priority = 2)
    public void test_run3() {
        System.out.println("I am running second");
    }
}
