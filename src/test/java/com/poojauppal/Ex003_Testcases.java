package com.poojauppal;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Ex003_Testcases {
    String pincode;
    @Test
    @Description("TC_1 Verify that given pincode gives 200")
    public void test_GET_Positivecase_TC1 () {
        //pincode= "110070";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" +"110070")
                .when()
                    .get()
                    .then().log().all().statusCode(200);
    }
    @Test
    @Description("TC_2 Verify that Invalid pincode gives error")
    public void test_GET_Negativecase_Tc2() {
    RestAssured
            .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" +"@")
            .when()
                .get()
            .then()
                .log().all().statusCode(200);
    }

    @Test
    @Description("TC_3 Verify that Invalid pincode gives error")
    public void test_GET_Negativecase_Tc3() {
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" +"-1")
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);
    }

    @Test
    @Description("TC_4 Verify that Invalid pincode gives error")
    public void test_GET_Negativecase_Tc4() {
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" +" ")
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);
    }

}
