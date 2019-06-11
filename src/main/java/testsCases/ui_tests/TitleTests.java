package testsCases.ui_tests;

import com.codeborne.selenide.SelenideElement;
import infrastructure.pageObjects_Playbuzz.MainPage;
import infrastructure.pageObjects_Playbuzz.ResultsPage;
import infrastructure.pageObjects_Playbuzz.resultSection.ResultSection;
import infrastructure.utils.ui.BaseTest;
import infrastructure.utils.Groups;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class TitleTests extends BaseTest {
    private String PearlJam = "pearl jam";

    @Test(groups =  {Groups.REGRESSION})
    public void test02_titleNotEmpty() {
        MainPage PlaybuzzMainPage = new MainPage(driver);
        ResultsPage PlaybuzzResultsPage = new ResultsPage(driver);
        ResultSection PlaybuzzResultSection = new ResultSection(driver);
        driver.get(url);
        PlaybuzzMainPage.searchValue(PearlJam);
        WebElement result = PlaybuzzResultsPage.getResultByIndex(0);
        SelenideElement urlElement = $(result).find(PlaybuzzResultSection.LINKED_URL);
        String url = urlElement.getText();
        urlElement.click();
        waitForUrlToAppear(url,driver);
        assertTrue(!driver.getTitle().isEmpty());
    }
}
