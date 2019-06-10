package testsCases.ui_tests;

import infrastructure.pageObjects_Playbuzz.LoginPage;
import infrastructure.pageObjects_Playbuzz.MainPage;
import infrastructure.pageObjects_Playbuzz.SighUpPage;
import infrastructure.utils.ui.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Tests extends BaseTest {

    @Test
    public void test01_WrongPasswordLogin() throws Exception {

        MainPage PlaybuzzMainPage = new MainPage(driver);
        LoginPage PlaybuzzLoginPage = new LoginPage(driver);
        SighUpPage PlaybuzzSignUpPage = new SighUpPage(driver);

        driver.get("https://www.playbuzz.com/");
        PlaybuzzMainPage.login.click();
        PlaybuzzLoginPage.signup.click();
        PlaybuzzSignUpPage.enterPassword("Yos");

        assertTrue(!PlaybuzzSignUpPage.password.getText().contains("Must contain at least 8 characters"));

        driver.quit();
    }




}
