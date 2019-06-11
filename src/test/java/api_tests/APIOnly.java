package api_tests;

import com.jayway.restassured.RestAssured;
import infrastructure.utils.Groups;
import infrastructure.utils.MyListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;

@Listeners(MyListener.class)
public class APIOnly {
    @BeforeMethod
    public void initAPI() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test (groups = {Groups.SMOKE,Groups.ALL})
    public void Test04_highestId() {
        RestAssured.
                get("/api/users?page=2")
                .then()
                .body("data.id.max()", equalTo(6));
    }
}