package org.example.api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.api.support.ApiClient;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiLoginSteps {

    private Response response;
    private RequestSpecification request;

    @Given("the API login endpoint is available")
    public void theApiLoginEndpointIsAvailable() {
        request = ApiClient.givenBase();
    }

    @When("the client sends valid login credentials")
    public void theClientSendsValidLoginCredentials() {
        response = request
                .body("""
                        {
                          "email": "eve.holt@reqres.in",
                          "password": "cityslicka"
                        }
                        """)
                .when()
                .post("/api/login");
    }

    @Then("the API should return a token")
    public void theApiShouldReturnAToken() {
        assertEquals(200, response.statusCode());
        response.then().body("token", notNullValue());
    }
}
