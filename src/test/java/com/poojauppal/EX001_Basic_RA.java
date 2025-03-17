package com.poojauppal;

import io.restassured.RestAssured;

import java.util.Scanner;

public class EX001_Basic_RA {
    public static void main(String[] args) {
        // Gherkins Syntax
        // Given() -> Pre Req. - URL, Headers, Auth, Body....
        // When() -> HTTP method? - GET/POST/PUT/PATCH, DELETE...
        // Then() -> Validation -> 200 oK, firstname == PRAMOD

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter pincode");
        String pincode = sc.nextLine();

        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/"+pincode)
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);
    }
}
