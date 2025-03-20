package com.poojauppal.Ex09_PayloadManagement.Gson;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class Gson_Payload {

    RequestSpecification r;
    ValidatableResponse vr;

    @Test
    public void test_Post() {
        // Step1 - POST
        // URL -> Base URI + base Path
        // HEADER
        // BODY
        // Auth - NO

        // Step 2
        // prepare the Payload ( Object -> JSON String)
        // send the request

        //Step 3
        // Validate Response ( JSON String -> Object)
        // FirstName,
        // Status Code
        // Time Response
    Booking booking = new Booking();
    booking.setFirstname("Pooja");
    booking.setLastname("Uppal");
    booking.setTotalprice(2340);
    booking.setDepositpaid(true);

    Bookingdates bookingdates = new Bookingdates();
    bookingdates.setCheckin("2025-03-22");
    bookingdates.setCheckout("2025-03-25");
    booking.setBookingdates(bookingdates);
    booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        Gson gson = new Gson();
        String jsonBooking = gson.toJson(booking);
        System.out.println(jsonBooking);
//json string will generate which t/f to server

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/");
        r.contentType(ContentType.JSON);
        r.body(jsonBooking).log().all();

        Response response = r.when().post();
        vr = response.then().log().all().statusCode(200);

        // Case 2 - jsonPath.getString("")  JSON Path Extraction
        JsonPath jsonPath = new JsonPath(response.asString());
        String firstname = jsonPath.getString("booking.firstname");
        String lastname = jsonPath.getString("booking.lastname");
        String bookingId = jsonPath.getString("bookingid");

        System.out.println(bookingId);
        System.out.println(firstname);
        System.out.println(lastname);

        assertThat(firstname).isEqualTo("Pooja").isNotNull().isNotEmpty().isNotBlank();
        assertThat(lastname).isEqualTo("Uppal").isNotBlank().isNotEmpty().isNotNull();
        assertThat(bookingId).isNotNull().isNotEmpty();

        String jsonresponse = response.asString();

        // Server - JSONString> Java Object( BookingResponse) - getter to verify

        // Case 3 - DeSer - Extraction
        //  Response - De Ser another Response Class
        BookingResponse bookingResponse = gson.fromJson(jsonresponse,BookingResponse.class);
        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());

        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNegative().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Pooja").isNotEmpty().isNotBlank().isNotNull();
        assertThat(bookingResponse.getBooking().getLastname()).isEqualTo("Uppal").isNotNull().isNotBlank().isNotEmpty();

    }
}
