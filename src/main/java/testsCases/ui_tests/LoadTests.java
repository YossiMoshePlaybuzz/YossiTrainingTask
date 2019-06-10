package testsCases.ui_tests;

import infrastructure.pageObjects_Playbuzz.SighUpPage;
import infrastructure.utils.ui.BaseTest;
import infrastructure.utils.ui.Groups;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoadTests extends BaseTest {

    //private String url = "https://www.playbuzz.com";

    @Test(groups =  {Groups.BROWSER_FIREFOX})
    public void test01_LoadTimeGoogleSite() {
        SighUpPage PlaybuzzSignUpPage = new SighUpPage(driver);

        driver.get("https://www.playbuzz.com/Signup");
        PlaybuzzSignUpPage.enterUsername("Yos");

        assertTrue(PlaybuzzSignUpPage.fullnameError.getText().contains("Name must have at least 4 characters and no special characters."));


    }
}
