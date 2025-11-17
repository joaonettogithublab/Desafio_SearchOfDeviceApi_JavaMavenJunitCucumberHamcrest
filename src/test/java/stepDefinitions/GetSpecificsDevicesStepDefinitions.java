package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class GetSpecificsDevicesStepDefinitions {

    private Response response;
    private String   identificationDevice;


    @Given("I send the parameter for identification of device {string}")
    public void iSendTheParameterForIdentificationOfDevice(String  identificationDevice) {
        this.identificationDevice =  identificationDevice;
    }

    @When("I access the endpoint List of objects by id")
    public void getSpecifDevice() {
        String apiUrl = "https://api.restful-api.dev/objects/";
        response =  RestAssured
                    .given()
                        .log().all()
                        .pathParam("id", identificationDevice)
                        .contentType("application/json")
                     .when()
                        .get(apiUrl + "{id}");
    }

    @Then("I receive the json response with status code success {string}")
    public void iReceiveTheJsonResponseWithStatusCodeSuccess(String statusCode) {

        int returnCode = response.getStatusCode();

        String statusCodeCondition = "    ";
        if (returnCode == 200 ) {
            statusCodeCondition =  "success";
        } else {
            statusCodeCondition =  "failed";
        }

        System.out.println("statusCodeCondition: " + statusCodeCondition );
        assertThat(statusCodeCondition, is(statusCode));
    }



}