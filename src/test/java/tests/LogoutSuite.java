package tests;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class LogoutSuite extends BaseTest{
    @Test
    @FileParameters("./data/CorrectLoginThenLogout.csv")
    public void correctLoginThenLogout(String browser, String url, String username, String password){
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        mainPage.verifyLogoutLink();
        mainPage.clickLogoutLink();
        mainPage.validateSuccessfulLogoutMessage("You have now logged out");
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
    }

    @Test
    @FileParameters("./data/LogoutHomePage.csv")
    public void logoutHomePage(String browser, String url, String username, String password){
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        mainPage.validateMenu();
        mainPage.clickHomeLink();
        mainPage.verifyLogoutLink();
        mainPage.clickLogoutLink();
        mainPage.validateSuccessfulLogoutMessage("You have now logged out");
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
    }

    @Test
    @FileParameters("./data/LogoutAboutPage.csv")
    public void logoutAboutPage(String browser, String url, String username, String password){
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        mainPage.validateMenu();
        mainPage.clickAboutLink();
        mainPage.verifyLogoutLink();
        mainPage.clickLogoutLink();
        mainPage.validateSuccessfulLogoutMessage("You have now logged out");
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
    }

    @Test
    @FileParameters("./data/LogoutContactPage.csv")
    public void logoutContactPage(String browser, String url, String username, String password){
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        mainPage.validateMenu();
        mainPage.clickContactLink();
        mainPage.verifyLogoutLink();
        mainPage.clickLogoutLink();
        mainPage.validateSuccessfulLogoutMessage("You have now logged out");
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
    }
}