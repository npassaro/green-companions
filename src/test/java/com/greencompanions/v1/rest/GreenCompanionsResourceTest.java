package com.greencompanions.v1.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class GreenCompanionsResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/green-companions/1")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}