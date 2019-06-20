package testsCases.api_tests;

import infrastructure.pageObjects_Playbuzz.GoogleSearchPage;
import infrastructure.pageObjects_Playbuzz.resultSection.ResultSection;
import infrastructure.utils.Groups;
import infrastructure.utils.api.APIHelper;
import infrastructure.utils.ui.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;


public class API_Results extends BaseTest {
    private String PearlJam = "pearl jam";
    APIHelper api = new APIHelper();

    @Test(groups =  {Groups.SMOKE,Groups.ALL})
    public void Test05_firstResultsContainsPearlJam() {
        String url = getUrlByResultIndex(0);
        String responseAsString = api.getResponseAsString(url);
        Assert.assertTrue(isPearlJamExistInPage(responseAsString));
    }

    @Test(groups =  {Groups.SMOKE,Groups.ALL})
    public void Test06_secondResultsContainsPearlJam() {
        String url = getUrlByResultIndex(2);
        String responseAsString = api.getResponseAsString(url);
        Assert.assertTrue(isPearlJamExistInPage(responseAsString));
    }

    @Test(groups =  {Groups.SMOKE,Groups.ALL})
    public void test07_thirdResultsContainsPearlJam() {
        String url = getUrlByResultIndex(3);
        String responseAsString = api.getResponseAsString(url);
        Assert.assertTrue(isPearlJamExistInPage(responseAsString));
    }

    //---------------------------------------

    public String getUrlByResultIndex(int index){
        GoogleSearchPage GoogleMainPage = new GoogleSearchPage(driver);
        driver.get(url);
        GoogleMainPage.searchValue(PearlJam);
        ResultSection result = new ResultSection(index,driver);
        return result.getUrl();
    }

    public boolean isPearlJamExistInPage(String responseAsString) {
        return responseAsString.toLowerCase().contains(PearlJam);
    }

}
