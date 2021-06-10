package tests;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class LoginSuite extends BaseTest {

    @Test
    @FileParameters("./data/CorrectLoginSongsNavigation.csv")
    public void correctLoginSongsNavigation(String browser, String url, String username, String password) {
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSongsPage();
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        mainPage.verifyLogoutLink();
    }

    @Test
    @FileParameters("./data/IncorrectLogin.csv")
    public void incorrectLogin(String browser, String url, String username, String password) {
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        loginPage.validateWrongLogin();
    }

    @Test
    @FileParameters("./data/CorrectLoginAboutNavigation.csv")
    public void correctLoginAboutNavigation(String browser, String url,String username, String password){
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username,password);
        mainPage.validateMenu();
        mainPage.clickAboutLink();
        aboutPage.validateAboutPage();
        mainPage.verifyLogoutLink();
    }

    @Test
    @FileParameters("./data/CorrectLoginContactNavigation.csv")
    public void correctLoginContactNavigation(String browser, String url,String username, String password){
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        mainPage.validateMenu();
        mainPage.clickContactLink();
        contactPage.validateContactPage();
        mainPage.verifyLogoutLink();
    }

    @Test
    @FileParameters("./data/CorrectLoginHomeNavigation.csv")
    public void correctLoginHomeNavigation(String browser, String url,String username, String password){
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        mainPage.validateMenu();
        mainPage.clickHomeLink();
        mainPage.validateMainPage();
        mainPage.verifyLogoutLink();
    }

    @Test
    @FileParameters("./data/IncorrectLoginGoToHomePage.csv")
    public void incorrectLoginGoToHomePage(String browser, String url, String username, String password){
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        loginPage.validateWrongLogin();
        mainPage.validateMenu();
        mainPage.clickHomeLink();
        mainPage.verifyLoginLink();
    }

    @Test
    @FileParameters("./data/IncorrectLoginGoToAboutPage.csv")
    public void incorrectLoginGoToAboutPage(String browser, String url, String username, String password){
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        loginPage.validateWrongLogin();
        mainPage.validateMenu();
        mainPage.clickAboutLink();
        aboutPage.validateAboutPage();
        mainPage.verifyLoginLink();
    }

    @Test
    @FileParameters("./data/IncorrectLoginGoToContactPage.csv")
    public void incorrectLoginGoToContactPage(String browser, String url, String username, String password){
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        loginPage.validateWrongLogin();
        mainPage.validateMenu();
        mainPage.clickContactLink();
        contactPage.validateContactPage();
        mainPage.verifyLoginLink();
    }

    @Test
    @FileParameters("./data/IncorrectLoginGoToSongsPage.csv")
    public void incorrectLoginGoToSongsPage(String browser, String url, String username, String password){
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        loginPage.validateWrongLogin();
        mainPage.validateMenu();
        mainPage.clickSongsLink();
        songsPage.validateSongsPage();
        mainPage.verifyLoginLink();
    }

    @Test
    @FileParameters("./data/AboutPageCorrectLogin.csv")
    public void aboutPageCorrectLogin(String browser, String url, String username, String password){
        setupWebPage(browser, url);
        mainPage.validateMenu();
        mainPage.clickAboutLink();
        aboutPage.validateAboutPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username,password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
    }

    @Test
    @FileParameters("./data/ContactPageCorrectLogin.csv")
    public void contactPageCorrectLogin(String browser, String url, String username, String password){
        setupWebPage(browser, url);
        mainPage.validateMenu();
        mainPage.clickContactLink();
        contactPage.validateContactPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username,password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
    }

    @Test
    @FileParameters("./data/SongsPageCorrectLogin.csv")
    public void songsPageCorrectLogin(String browser, String url, String username, String password){
        setupWebPage(browser, url);
        mainPage.validateMenu();
        mainPage.clickSongsLink();
        songsPage.validateSongsPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username,password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
    }
}
