package com.poojauppal.Ex04_PUT_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Testing_PUT_Request {
    @Test
    @Description ("TC4- Verify the booking is updated")
    public void Update_booking() {
        String token = "acfe519ea73e69d";
        String payload = "{\n" +
                "    \"firstname\" : \"Pooja\",\n" +
                "    \"lastname\" : \"Uppal\",\n" +
                "    \"totalprice\" : 20022,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-03-14\",\n" +
                "        \"checkout\" : \"2025-03-15\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : [\"Breakfast\", \"Dinner\"]\n" +
                "}";
        String bookingid = "2081";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/" +bookingid);
        r.cookie("token",token);
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        Response response = r.when().log().all().put();

        ValidatableResponse vr = response.then().log().all().statusCode(200);

    }
}
