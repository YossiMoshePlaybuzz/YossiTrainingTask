package testsCases.api_tests;

import infrastructure.utils.Groups;
import infrastructure.utils.api.APIHelper;
import org.testng.Assert;
import org.testng.annotations.Test;


public class API_HighestID {

    APIHelper api = new APIHelper();
    String url = "https://reqres.in/api/users?page=2";

    @Test (groups = {Groups.SMOKE,Groups.ALL})
    public void Test04_highestId() {
        int maxId = api.getMaxId(url);
        Assert.assertEquals(maxId,6);
    }
}
