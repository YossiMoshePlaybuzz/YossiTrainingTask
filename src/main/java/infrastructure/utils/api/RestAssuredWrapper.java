package infrastructure.utils.api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;

public class RestAssuredWrapper {
    public RequestSpecification ra() {
        return RestAssured.given();
    }

    private void initializeRestAssured() {

    }
}
