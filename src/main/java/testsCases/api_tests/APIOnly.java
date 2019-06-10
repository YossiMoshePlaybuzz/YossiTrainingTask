package testsCases.api_tests;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class APIOnly {
    @BeforeMethod
    public void initAPI() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void highestId() {
        RestAssured.
                get("/api/users?page=2")
                .then()
                .body("data.id.max()", equalTo(6));
    }
}
