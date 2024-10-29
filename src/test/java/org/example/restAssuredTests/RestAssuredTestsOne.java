package org.example.restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredTestsOne {


    @Test
    public void sampleApiTest() {

        RestAssured
                .get("https://reqres.in/api/users/2") //invoked Get method on RestAssured class
                .then()
                .statusCode(200);

        //Rest Assured follows Fluent Interface design.
        //Fluent interface is just a method of designing object-oriented API's in a easy to read fashion

    }
    @Test
    public  void peekTest(){

        Response response =
                RestAssured
                        .get("https://reqres.in/api/users/2");

        response.peek();

    }

    @Test
    public  void prettyPeekTest(){

        Response response =
                RestAssured
                        .get("https://reqres.in/api/users/2");

        response.prettyPeek();

    }

    @Test
    public  void printTest(){

        Response response =
                RestAssured
                        .get("https://reqres.in/api/users/2");

        response.print();

    }
    @Test
    public  void prettyPrintTest(){

        Response response =
                RestAssured
                        .get("https://reqres.in/api/users/2");

        response.prettyPrint();

    }

    @Test
    public  void assertPeekTest(){

        Response response =
                RestAssured
                        .get("https://reqres.in/api/users/2");

        Assert.assertTrue(response.peek() instanceof Response);
        Assert.assertEquals(response.getStatusCode(),200);

//        "Make sure the response is a valid Response object."
//        Why do this?
//        Verify that the response is not null or malformed.
//        Ensure that the response can be further processed or asserted.


    }
}


//    print()
//	          1. Prints response body
//            2. Can't use response again (consumed)
//            3. No return value
//     peek()
//
//            1. Looks at response without touching it
//            2. Can still use response (not consumed)
//            Returns response details