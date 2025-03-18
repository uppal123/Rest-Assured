package com.poojauppal.Ex07_TestNG_Practice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testng_Parameter {
    @Parameters ("browser")
    @Test
    public void demo1(String value) {
        System.out.println("Test case 1");

        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Start the Chrome browser");
        }
        if (value.equalsIgnoreCase("firefox")){
            System.out.println("Start the Firefox browser");
        }
    }

}
