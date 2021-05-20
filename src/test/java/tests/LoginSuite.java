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
}
