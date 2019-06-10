package infrastructure.utils.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import javax.xml.ws.Response;

public class BaseAPITest {

    private RequestSpecification request;
    private Response response;

    public RequestSpecification getRequest() { return request; }
    public Response getResponse() { return response; }


    @BeforeMethod
    public void initAPI() {
        RestAssured.baseURI = "https://reqres.in";
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }


}
