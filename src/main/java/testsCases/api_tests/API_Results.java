package testsCases.api_tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import infrastructure.pageObjects_Playbuzz.MainPage;
import infrastructure.pageObjects_Playbuzz.ResultsPage;
import infrastructure.pageObjects_Playbuzz.resultSection.ResultSection;
import infrastructure.utils.Groups;
import infrastructure.utils.MyListener;
import infrastructure.utils.ui.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.$;


public class API_Results extends BaseTest {
    private String PearlJam = "pearl jam";
    private List<String> urls = new ArrayList<String>();
    private int numOfUrls = 5;

    @Test(priority = -1,groups =  {Groups.SMOKE,Groups.ALL})
    public void beforeTests_getResults(){
        MainPage GoogleMainPage = new MainPage(driver);
        ResultsPage GoogleResultsPage = new ResultsPage(driver);
        ResultSection GoogleResultSection = new ResultSection(driver);
        driver.get(url);
        GoogleMainPage.searchValue(PearlJam);

        for(int i=0; i<numOfUrls; i++){
            WebElement result = GoogleResultsPage.getResultByIndex(i);
            String url = $(result).find(GoogleResultSection.LINKED_URL).getText();
            urls.add(url);
        }
    }

    @Test(groups =  {Groups.SMOKE,Groups.ALL}, dependsOnMethods = "beforeTests_getResults")
    public void Test05_firstResultsContainsPearlJam() {
        String responseAsString = getUrlAsString(urls.get(0));
        Assert.assertTrue(isPearlJamExistInPage(responseAsString));
    }

    @Test(groups =  {Groups.SMOKE,Groups.ALL}, dependsOnMethods = "beforeTests_getResults")
    public void Test06_secondResultsContainsPearlJam() {
        String responseAsString = getUrlAsString(urls.get(2));
        Assert.assertTrue(isPearlJamExistInPage(responseAsString));
    }

    @Test(groups =  {Groups.SMOKE,Groups.ALL}, dependsOnMethods = "beforeTests_getResults")
    public void test07_thirdResultsContainsPearlJam() {
        String responseAsString = getUrlAsString(urls.get(4));
        Assert.assertTrue(isPearlJamExistInPage(responseAsString));
    }

    //---------------------------------------

    public boolean isPearlJamExistInPage(String responseAsString) {
        return responseAsString.toLowerCase().contains(PearlJam);
    }

    public String getUrlAsString(String url){
        return getPage(url).asString();
    }

    public Response getPage(String url){
        Response response = RestAssured.get(url);
        response.then().statusCode(200);
        return response;
    }
}
