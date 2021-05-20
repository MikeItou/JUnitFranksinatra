package tests;

import junitparams.FileParameters;
import org.junit.Test;

public class LogoutSuite extends BaseTest{
    @Test
    @FileParameters("./data/CorrectLoginAboutNavigation.csv")
    public void loginAboutNavigation(String browser, String url){
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.clickAboutLink();
        aboutPage.validateAboutPage();
        mainPage.verifyLoginLink();
    }
}