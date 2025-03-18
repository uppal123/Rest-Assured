package com.poojauppal.Ex07_TestNG_Practice;

import org.testng.annotations.Test;

public class Testng_dependsON {
    @Test
    public void serverStart () {
        System.out.println("Server is running");
    }
    @Test(dependsOnMethods = "serverStart")
    public void run_T1 () {
        System.out.println("T1");
    }
    @Test(dependsOnMethods = "serverStart")
    public void run_T2() {
        System.out.println("T2");
    }
}
