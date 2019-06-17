package testsCases.ui_tests;

import infrastructure.pageObjects_Playbuzz.GoogleSearchPage;
import infrastructure.pageObjects_Playbuzz.ResultsPage;
import infrastructure.utils.ui.BaseTest;
import infrastructure.utils.Groups;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ResultsTests extends BaseTest {

    private String PearlJam = "pearl jam";

    @Test(groups =  {Groups.REGRESSION,Groups.ALL})
    public void Test03_allResultsContainsPearlJam() {
        GoogleSearchPage PlaybuzzMainPage = new GoogleSearchPage(driver);
        ResultsPage PlaybuzzResultsPage = new ResultsPage(driver);
        driver.get(url);
        PlaybuzzMainPage.searchValue(PearlJam);

        for (int i=0; i < PlaybuzzResultsPage.getResultsSize(); i++){
            String description = PlaybuzzResultsPage.getDescriptionByResultIndex(i);
            Assert.assertTrue(description.toLowerCase().contains(PearlJam));
        }
    }

}
