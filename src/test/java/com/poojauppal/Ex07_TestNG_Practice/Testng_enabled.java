package com.poojauppal.Ex07_TestNG_Practice;

import org.testng.annotations.Test;

public class Testng_enabled {

    @Test(enabled = false)
    public void test01(){
        System.out.println("tc1");
    }

    @Test(enabled = true)
    public void test02() {
        System.out.println("tc2");
    }
}
