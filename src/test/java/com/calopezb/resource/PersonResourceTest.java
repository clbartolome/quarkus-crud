package com.calopezb.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PersonResourceTest {

    @BeforeEach
    public void setup() {
        // Clean up or insert test data if needed
    }

    @Test
    public void testCreateAndGetPerson() {
        String json = "{\"name\":\"John Doe\",\"email\":\"john@example.com\"}";

        given()
            .contentType(ContentType.JSON)
            .body(json)
            .when()
            .post("/persons")
            .then()
            .statusCode(201)
            .body("name", is("John Doe"));

        given()
            .when().get("/persons")
            .then()
            .statusCode(200)
            .body("size()", is(1));
    }

    @Test
    public void testHealthEndpoint() {
        given()
            .when().get("/q/health/ready")
            .then()
            .statusCode(200)
            .body("status", is("UP"));
    }
}
