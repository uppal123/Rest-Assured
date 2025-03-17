package com.poojauppal.Ex03_Token_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Testing_Token_Request {
    @Test
    @Description ("TC3- Verify the auth token is generated")
    public void Token_creation() {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("auth/");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        Response response = r.when().log().all().post();

        ValidatableResponse vr = response.then()
                                    .log().all().statusCode(200);


    }
}
