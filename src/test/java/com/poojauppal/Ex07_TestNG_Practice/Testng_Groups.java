package com.poojauppal.Ex07_TestNG_Practice;

import org.testng.annotations.Test;

public class Testng_Groups {

    @Test (groups = {"smoke", "P0"})
    public void test_smoke() {
        System.out.println("TC 1- smoke");
        System.out.println("TC 7 - regression");
    }

    @Test(groups = {"regression", "sanity", "P0"})
    public void test_regression () {
        System.out.println("TC 2 - regression");
        System.out.println("TC 4 - sanity");
    }

    @Test (groups = {"sanity", "smoke", "regression"})
    public void test_sanity () {
        System.out.println("Tc 3- sanity");
        System.out.println("TC 6 - smoke");
        System.out.println("TC 5 - regression");
    }

}
