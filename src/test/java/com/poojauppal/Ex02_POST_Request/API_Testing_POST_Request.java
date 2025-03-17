package com.poojauppal.Ex02_POST_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Testing_POST_Request {
    @Test
    @Description ("TC2- Verify that Booking is created")
    public void Post_positiveCase() {
        String payload = "{\n" +
                "    \"firstname\" : \"Pinky\",\n" +
                "    \"lastname\" : \"Uppal\",\n" +
                "    \"totalprice\" : 4890,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-03-16\",\n" +
                "        \"checkout\" : \"2025-03-19\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : [\"Dinner\", \"Lunch\"]\n" +
                "}\n";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/");
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        Response response = r.when().log().all().post();

        ValidatableResponse vr = response.then().log().all().statusCode(200);



    }
}
