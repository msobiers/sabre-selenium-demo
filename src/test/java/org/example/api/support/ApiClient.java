package org.example.api.support;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class ApiClient {

    private static final RequestSpecification BASE_SPEC = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in")
            .setContentType(ContentType.JSON)
            .addHeader("x-api-key", "reqres-free-v1")
            .build();

    private ApiClient() {
    }

    public static RequestSpecification givenBase() {
        return RestAssured.given().spec(BASE_SPEC);
    }
}