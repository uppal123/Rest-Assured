package com.poojauppal.Ex05_Patch_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Testing_PATCH_Request {
    @Test
    @Description ("TC5- Verify that Booking is partially updated")
    public void Partial_Update() {
        String token = "fadb5dee7e89e95";
        String bookingid = "1460";
        String payload = "{\n" +
                "  \"firstname\": \"Shikha\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.body(payload).log().all();

        Response response = r.when().log().all().patch();

        ValidatableResponse vr = response.then().log().all().statusCode(200);

    }
}
