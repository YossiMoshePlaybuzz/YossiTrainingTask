package ui_tests;


import infrastructure.pageObjects_Playbuzz.MainPage;
import infrastructure.pageObjects_Playbuzz.ResultsPage;
import infrastructure.pageObjects_Playbuzz.resultSection.ResultSection;
import infrastructure.utils.Groups;
import infrastructure.utils.MyListener;
import infrastructure.utils.ui.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;


@Listeners(MyListener.class)
public class ResultsTests extends BaseTest {

    private String PearlJam = "pearl jam";

    @Test(groups =  {Groups.REGRESSION,Groups.ALL})
    public void Test03_allResultsContainsPearlJam() {
        MainPage PlaybuzzMainPage = new MainPage(driver);
        ResultsPage PlaybuzzResultsPage = new ResultsPage(driver);
        ResultSection PlaybuzzResultSection = new ResultSection(driver);
        driver.get(url);
        PlaybuzzMainPage.searchValue(PearlJam);
        for(WebElement element : PlaybuzzResultsPage.getResults()) {
            String description = $(element).find(PlaybuzzResultSection.DESCRIPTION).getText();
            Assert.assertTrue(description.toLowerCase().contains(PearlJam));
        }
    }




}
