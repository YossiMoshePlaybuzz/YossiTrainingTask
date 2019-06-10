package infrastructure.utils.api;

import com.jayway.restassured.response.Response;

public class BaseAPIClient {
    protected RestAssuredWrapper restAssured = new RestAssuredWrapper();

    public Response getUrl(String url) {
        return restAssured.ra()
                .get(url);
    }
}
