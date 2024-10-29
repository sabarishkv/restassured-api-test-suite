package org.example.restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.http.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredAssertion {

//    String validURl = "https://reqres.in/api/users?page=2";

    String validURl = "https://reqres.in/api/users/2";


    @Test
    public void newResponseTest(){


        Response response = RestAssured.get(validURl);


        response.prettyPeek();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK");
        Assert.assertEquals(response.getContentType(),"application/json; charset=utf-8");


    }


    @Test
    public void newResponseTestAndBody(){
        Response response = RestAssured.get(validURl);

        ResponseBody responseBody = response.getBody();

        responseBody.prettyPeek();

        Assert.assertTrue(responseBody.asString().contains("Weaver"));
        Assert.assertTrue(responseBody.asString().contains("janet.weaver@reqres.in"));
    }


    @Test
    public void newHeadersTest(){
        Response response = RestAssured.get(validURl);

        Headers headers = response.getHeaders();


        Assert.assertTrue(headers.hasHeaderWithName("Server"));
        Assert.assertTrue(headers.hasHeaderWithName("Content-Type"));

        Assert.assertEquals(headers.get("Server").getValue(),"cloudflare");



    }
}

