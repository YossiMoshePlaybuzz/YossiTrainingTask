package testsCases.api_tests;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import infrastructure.utils.api.BaseAPIClient;
import infrastructure.utils.api.serializationClasses.Data;
import infrastructure.utils.api.serializationClasses.User;
import infrastructure.utils.api.serializationClasses.Worker;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jayway.restassured.path.xml.XmlPath.from;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class API extends BaseAPIClient {

    @BeforeMethod
    public void initAPI() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void user_id() {

        getUrl("/api/users/2")
                .then()
                .body("data.id", equalTo(2));
    }

    @Test
    public void reqresAPI() {

        getUrl("/api/unknown")
                .then()
                .body("data.name", hasItems("cerulean","true red"));
    }

    @Test
    public void status_code() {
        RestAssured.
                given()
                .get("/api/users/2")
                .then()
                .statusCode(200);
    }

    @Test (enabled = false)
    public void text() {
        RestAssured.
                given()
                .get("/api/users/2")
                .then()
                .body("data.text()",containsString("Janet"));
    }

    @Test
    public void testDeSerialization() {
        User student = RestAssured.get("/api/users/2").as(User.class);
        Gson gson = new Gson();
        String userJson = gson.toJson(student);
        User user = gson.fromJson(userJson, User.class);

        //JSONObject newUser = (JSONObject)RestAssured.get("/api/users/2");
        Response response = RestAssured.get("/api/users/2");
        JSONParser parser;


        //Data userObject = gson.fromJson(userJson, Data.class);

    }


    @Test
    public void Serialization() {
        Worker worker = new Worker("Martin","Developer");
        RestAssured.given()
                .body(worker)
                .post("/api/users")
                .then().statusCode(201);
    }

    @Test
    public void testDeSerialization2() {
        User user = RestAssured.get("/api/users/2").as(User.class);
        System.out.println(user.toString());

    }

    @Test (enabled = false)
        public void testSerialization() {
            Response response = null;
            Data student = new Data(2,"yossi@gmail.com","Yossi","Moshe","aaa");

            response = RestAssured.given()
                    .contentType("application/json")
                    .body(student)
                    .when()
                    .post("http://localhost:9091/students");

            Assert.assertTrue(response.toString().contains("Student added successfully."));

        }

    @Test
    public void post() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name","morpheus");
        requestParams.put("job","leader");

        Response response = RestAssured.given()
                            .body(requestParams.toString())
                            .post("/api/users");
        Assert.assertEquals(response.getStatusCode(),201);

    }

    @Test
    public void post2() {
        Map<String,String> requestParams = new HashMap<>();
        requestParams.put("name","morpheus");
        requestParams.put("job","leader");

        Response response = RestAssured.given()
                .body(requestParams)
                .post("/api/users");
        Assert.assertEquals(response.getStatusCode(),201);

    }

    @Test
    public void update() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name","morpheus");
        requestParams.put("job","QA");

        Response response = RestAssured.given()
                .body(requestParams.toString())
                .put("/api/users/2");
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(response.getBody().asString());

    }

    @Test
    public void jasonPath()
    {
        Response response = RestAssured.given().get("/api/unknown");
        JsonPath jp = response.jsonPath();
        String name = jp.getString("data.name[0]");
        Assert.assertTrue(name.equals("cerulean"));
    }

    @Test
    public void path()
    {
        String name = RestAssured.given().get("/api/unknown").path("data.name[0]");
        Assert.assertTrue(name.equals("cerulean"));
    }

    @Test
    public void path2()
    {
        String name = RestAssured.given().get("/api/unknown").andReturn().jsonPath().getString("data.name[0]");
        Assert.assertTrue(name.equals("cerulean"));
    }

    @Test
    public void greater_Than()
    {
        RestAssured.given().get("/api/unknown").then()
                .body("data.color*.length().sum()",greaterThan(20));
    }

    @Test
    public void list1()
    {
        Response response = RestAssured.given().get("/api/unknown");
        JsonPath jp = response.jsonPath();
        List<String> names = jp.getList("data.name");
        Assert.assertEquals(names.size(),3);
    }

    @Test (enabled = false)
    public void list2()
    {
        String response = RestAssured.given().get("/api/unknown/2").asString();
        int id = from(response).get("id");
        Assert.assertEquals(id,2);

    }
}
