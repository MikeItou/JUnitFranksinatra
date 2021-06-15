package tests;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ContactSuite extends BaseTest {

    @Test
    @FileParameters("./data/LoginAndContact.csv")
    public void loginAndContact(String browser, String url, String username, String password, String name, String email, String message) {
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
        contactPage.validateContactPage();
        contactPage.fillContactFields(name, email, message);
        contactPage.validateErrorMessage();
    }

    @Test
    @FileParameters("./data/NoLoginAndContact.csv")
    public void noLoginAndContact(String browser, String url, String name, String email, String message) {
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.validateMenu();
        mainPage.clickContactLink();
        contactPage.validateContactPage();
        contactPage.fillContactFields(name,email,message);
        contactPage.validateErrorMessage();
    }
}
