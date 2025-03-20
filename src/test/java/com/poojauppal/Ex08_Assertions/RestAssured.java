package com.poojauppal.Ex08_Assertions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RestAssured {

    RequestSpecification r;
    Response respose;
    ValidatableResponse vr;

   @Test
    public void test_POST() {
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

        r= io.restassured.RestAssured.given();
         r.baseUri("https://restful-booker.herokuapp.com/");
         r.basePath("/booking/");
         r.contentType(ContentType.JSON);
         r.body(payload).log().all();

        respose = r.when().post();

        vr= respose.then().log().all().statusCode(200);

        //firstname = "Pinky, lastname = uppal, booking id not null
        vr.body("booking.firstname", Matchers.equalTo("Pooja"));
        vr.body("booking.lastname", Matchers.equalTo("Uppal"));
        vr.body("bookingid", Matchers.notNullValue());



    }
}
