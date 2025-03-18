package com.poojauppal.Ex07_TestNG_Practice;

import org.testng.annotations.Test;

public class Testng_enabled_alwaysrun {

    @Test(enabled = false)
    public void test01() {
        System.out.println("tc 1");
    }

    @Test(alwaysRun = true, enabled = false)
    public void test02() {
        System.out.println("tc 2");
    }

    @Test (enabled = true)
    public void test03() {
        System.out.println("tc 3");
    }

    @Test
    public void test04() {
        System.out.println("tc 4");
    }
}
