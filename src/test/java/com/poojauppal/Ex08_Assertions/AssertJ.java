package com.poojauppal.Ex08_Assertions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.assertj.core.api.Assertions.*;

public class AssertJ {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public  void test_Post(){
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

        response = r.when().post();

        vr= response.then().log().all().statusCode(200);

        //till here it is same as rest assured assertion
        //case 1- extract() - Direct Extraction
       int  bookingId = response.then().extract().path("bookingid");
       String  firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        //TestNG assertions
        //hard assert
        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname,"Pinky");
        Assert.assertEquals(lastname, "Uppal");

        //soft assert
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(firstname, "Pooja");
        sa.assertAll();

        //AssertJ assertion
        assertThat(bookingId).isNotNull().isNotNegative().isNotZero();
        assertThat(firstname).isEqualTo("Pinky").isNotBlank().isNotEmpty().isNotNull();
    }
}
