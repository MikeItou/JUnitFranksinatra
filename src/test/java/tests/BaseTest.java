package tests;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.*;

public class BaseTest {

    protected WebDriver driver;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected SongsPage songsPage;
    protected EditSongPage editSongPage;
    protected SongInfoPage songInfoPage;
    protected CreateSongPage createSongPage;
    protected AboutPage aboutPage;
    protected UnauthorizePage unauthorizePage;
    protected ContactPage contactPage;

    public void setupWebPage(String browser, String url){
        switch (browser) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "safari" -> driver = new SafariDriver();
            case "opera" -> driver = new OperaDriver();
            case "edge" -> driver = new EdgeDriver();
        }
        this.driver.get(url);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        songsPage = new SongsPage(driver);
        editSongPage = new EditSongPage(driver);
        songInfoPage = new SongInfoPage(driver);
        createSongPage = new CreateSongPage(driver);
        aboutPage = new AboutPage(driver);
        unauthorizePage = new UnauthorizePage(driver);
        contactPage = new ContactPage(driver);
    }

    @After
    public void after(){
        //this.driver.quit();
    }

}
