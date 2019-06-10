package testsCases.api_tests;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import infrastructure.pageObjects_Playbuzz.MainPage;
import infrastructure.pageObjects_Playbuzz.ResultsPage;
import infrastructure.pageObjects_Playbuzz.resultSection.ResultSection;
import infrastructure.utils.ui.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;


public class API_Results extends BaseTest {
    private String searchValue = "pearl jam";


    @Test
    public void firstResultsContainsPearlJam() {
        MainPage PlaybuzzMainPage = new MainPage(driver);
        ResultsPage PlaybuzzResultsPage = new ResultsPage(driver);
        ResultSection PlaybuzzResultSection = new ResultSection(driver);
        driver.get(url);
        PlaybuzzMainPage.searchValue(searchValue);
        WebElement result = PlaybuzzResultsPage.getSectionByIndex(0);
        String url = $(result).find(PlaybuzzResultSection.LINKED_URL).getText();
        Assert.assertTrue(isPearlJamExistInPage(url));
    }

    @Test
    public void secondResultsContainsPearlJam() {
        MainPage PlaybuzzMainPage = new MainPage(driver);
        ResultsPage PlaybuzzResultsPage = new ResultsPage(driver);
        ResultSection PlaybuzzResultSection = new ResultSection(driver);
        driver.get(url);
        PlaybuzzMainPage.searchValue(searchValue);
        WebElement result = PlaybuzzResultsPage.getSectionByIndex(3);
        String url = $(result).find(PlaybuzzResultSection.LINKED_URL).getText();
        Assert.assertTrue(isPearlJamExistInPage(url));
    }

    @Test
    public void thirdResultsContainsPearlJam() {
        MainPage PlaybuzzMainPage = new MainPage(driver);
        ResultsPage PlaybuzzResultsPage = new ResultsPage(driver);
        ResultSection PlaybuzzResultSection = new ResultSection(driver);
        driver.get(url);
        PlaybuzzMainPage.searchValue(searchValue);
        WebElement result = PlaybuzzResultsPage.getSectionByIndex(2);
        String url = $(result).find(PlaybuzzResultSection.LINKED_URL).getText();
        Assert.assertTrue(isPearlJamExistInPage(url));
    }

    //---------------------------------------

    public boolean isPearlJamExistInPage(String url) {
        Response response = RestAssured.get(url);
        System.out.println("url = " +url);
        Assert.assertEquals(response.getStatusCode(),200);
        String responseAsString = response.asString();
        return responseAsString.toLowerCase().contains(searchValue);

                //.then()
                //.body(containsString(searchValue))
                //.statusCode(200);
    }
}
