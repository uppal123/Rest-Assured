package com.poojauppal.Ex06_DELETE_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Testing_Delete_Request {
    @Test
    @Description ("TC6- Verify that Booking is able to delete")
    public void delete_Booking() {
        String bookingid = "305";
        String token = "2d9f8490b6f6283";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("booking/" +bookingid);
        r.cookie("token", token);
        r.contentType(ContentType.JSON);

        Response response = r.when().log().all().delete();

        ValidatableResponse vr = response.then().log().all().statusCode(201);

    }
}
