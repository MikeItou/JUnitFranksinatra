package tests;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@RunWith(JUnitParamsRunner.class)
public class LoginSuite extends BaseTest {

    @Test
    @FileParameters("./data/CorrectLogin.csv")
    public void correctLogin(String browser, String url, String username, String password){
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username,password);
        songsPage.validateSongsPage();
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
    }



}
