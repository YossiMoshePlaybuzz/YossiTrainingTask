package testsCases.ui_tests;

import infrastructure.pageObjects_Playbuzz.GoogleSearchPage;
import infrastructure.pageObjects_Playbuzz.ResultsPage;
import infrastructure.utils.ui.BaseTest;
import infrastructure.utils.Groups;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class TitleTests extends BaseTest {
    private String PearlJam = "pearl jam";

    @Test(groups =  {Groups.REGRESSION,Groups.ALL})
    public void Test02_titleNotEmpty() {
        GoogleSearchPage googleMainPage = new GoogleSearchPage(driver);
        ResultsPage googleResultsPage = new ResultsPage(driver);
        driver.get(url);
        googleMainPage.searchValue(PearlJam);
        String url = googleResultsPage.getUrlByResultIndex(0);
        googleResultsPage.clickOnUrlByResultIndex(0);
        waitForUrlToAppear(url,driver);
        assertTrue(!driver.getTitle().isEmpty());
    }
}
