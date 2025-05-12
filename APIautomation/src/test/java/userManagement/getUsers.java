package userManagement;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class getUsers {


    @Test
    public void getUserData() {
                given().
                when().
                get("https://reqres.in/api/users?page=2").
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void validateGetResponseBody() {
        // Set base URI for the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send a GET request and validate the response body using 'then'
        given()
                .when()
                .get("/todos/1")
                .then()
                .assertThat()
                .statusCode(200)
                .body(not(isEmptyString()))
                .body("title", equalTo("delectus aut autem"))
                .body("userId", equalTo(1));
    }
}


