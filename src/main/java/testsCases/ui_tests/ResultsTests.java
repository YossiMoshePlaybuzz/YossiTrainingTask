package testsCases.ui_tests;


import infrastructure.pageObjects_Playbuzz.MainPage;
import infrastructure.pageObjects_Playbuzz.ResultsPage;
import infrastructure.pageObjects_Playbuzz.resultSection.ResultSection;
import infrastructure.utils.ui.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class ResultsTests extends BaseTest {

    private String searchValue = "pearl jam";

    @Test
    public void test02_titleNotEmpty() throws Exception {
        MainPage PlaybuzzMainPage = new MainPage(driver);
        ResultsPage PlaybuzzResultsPage = new ResultsPage(driver);
        ResultSection PlaybuzzResultSection = new ResultSection(driver);
        driver.get(url);
        PlaybuzzMainPage.searchValue(searchValue);
        WebElement result = PlaybuzzResultsPage.getSectionByIndex(0);
        $(result).find(PlaybuzzResultSection.LINKED_URL).click();
        assertTrue(!driver.getTitle().isEmpty());
    }

    @Test
    public void test03_allResultsContainsSearchValue() throws Exception {
        MainPage PlaybuzzMainPage = new MainPage(driver);
        ResultsPage PlaybuzzResultsPage = new ResultsPage(driver);
        ResultSection PlaybuzzResultSection = new ResultSection(driver);
        driver.get(url);
        PlaybuzzMainPage.searchValue(searchValue);
        for(WebElement element : PlaybuzzResultsPage.getResults()) {
            String description = $(element).find(PlaybuzzResultSection.DESCRIPTION).getText();
            Assert.assertTrue(description.toLowerCase().contains(searchValue));
        }
    }




}
