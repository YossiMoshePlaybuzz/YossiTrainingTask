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

@Listeners(MyListener.class)
public class API_Results extends BaseTest {
    private String PearlJam = "pearl jam";
    private List<String> urls = new ArrayList<String>();
    private int numOfUrls = 5;

    @Test(priority = -1,groups =  {Groups.SMOKE,Groups.ALL})
    public void beforeTests_getResults(){
        MainPage PlaybuzzMainPage = new MainPage(driver);
        ResultsPage PlaybuzzResultsPage = new ResultsPage(driver);
        ResultSection PlaybuzzResultSection = new ResultSection(driver);
        driver.get(url);
        PlaybuzzMainPage.searchValue(PearlJam);

        for(int i=0; i<numOfUrls; i++){
            WebElement result = PlaybuzzResultsPage.getResultByIndex(i);
            String url = $(result).find(PlaybuzzResultSection.LINKED_URL).getText();
            urls.add(url);
        }
    }

    @Test(groups =  {Groups.SMOKE,Groups.ALL},dependsOnMethods = "beforeTests_getResults")
    public void Test05_firstResultsContainsPearlJam() {
        Assert.assertTrue(isPearlJamExistInPage(urls.get(0)));
    }

    @Test(groups =  {Groups.SMOKE,Groups.ALL},dependsOnMethods = "beforeTests_getResults")
    public void Test06_secondResultsContainsPearlJam() {
        Assert.assertTrue(isPearlJamExistInPage(urls.get(2)));
    }

    @Test(groups =  {Groups.SMOKE,Groups.ALL},dependsOnMethods = "beforeTests_getResults")
    public void test07_thirdResultsContainsPearlJam() {
        Assert.assertTrue(isPearlJamExistInPage(urls.get(3)));
    }

    //---------------------------------------

    public boolean isPearlJamExistInPage(String url) {
        Response response = getPage(url);
        Assert.assertEquals(response.getStatusCode(),200);
        String responseAsString = response.asString();
        return responseAsString.toLowerCase().contains(PearlJam);
    }

    public Response getPage(String url){
        return RestAssured.get(url);
    }
}
