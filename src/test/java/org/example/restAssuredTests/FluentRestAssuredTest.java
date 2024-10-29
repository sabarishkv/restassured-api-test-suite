package org.example.restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class FluentRestAssuredTest {
    //String validURl = "https://reqres.in/api/users?page=2";

    String validURl = "https://reqres.in/api/users/2";

    @Test
    public void fluentTest() {

        RestAssured.get(validURl)
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare").contentType(ContentType.JSON);

    }

}
