package com.poojauppal;

import io.restassured.RestAssured;

public class Ex002_multiple_testcases {
    public static void main(String[] args) {
        String pincode;

        pincode = "-1";
        RestAssured
                .given()
                        .baseUri("https://api.zippopotam.us")
                        .basePath("/IN/" +pincode)
                .when()
                        .get()
                .then()
                        .log().all().statusCode(200);

        pincode= "@";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" +pincode)
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);

        pincode= " ";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" +pincode)
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);

        pincode= "";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" +pincode)
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);


    }
}
