package com.poojauppal.Ex01_GET_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Testing_GET_Request {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description ("TC1- Verify the booking id")
    @Test
    public void GET_positiveCase() {
        String bookingid = "1040";

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/"  +bookingid);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);

    }
}
