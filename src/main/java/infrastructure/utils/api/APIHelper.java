package infrastructure.utils.api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class APIHelper {

    public RequestSpecification ra() {
        return RestAssured.given();
    }

    public Response getUrl(String url) {
        return ra().get(url);
    }

    public Response getPage(String url){
        Response response = RestAssured.get(url);
        response.then().statusCode(200);
        return response;
    }

    public String getUrlAsString(String url){
        return getPage(url).asString();
    }

    public int getMaxId(String url){
        return getUrl(url).path("data.id.max()");
    }
}
