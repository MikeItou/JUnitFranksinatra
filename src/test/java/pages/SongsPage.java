package pages;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SongsPage extends BasePage {

    @FindBy(css = ".flash")
    WebElement successfullLoginFlashMessage;
    @FindBy(css = "section h1")
    WebElement songsHeader;
    @FindBy(css = "[href='/songs/new']")
    WebElement createsongLink;
    @FindBy(css = "#songs")
    WebElement songList;
    @FindBy(css = "[href='/logout']")
    WebElement logoutLink;
    @FindBy(css = "a[href *= '/songs/']")
    List<WebElement> songLinks;
    @FindBy(css = ".flash")
    WebElement songDeletedFlashMessage;

    public SongsPage(WebDriver driver) {
        super(driver);
    }

    public void validateSongsPage() {
        try {
            waitForElementVisible(songsHeader);
            waitForElementVisible(createsongLink);
            waitForElementVisible(songList);
            waitForElementVisible(logoutLink);

            System.out.println("All SongsPage elements are visible.");
        } catch (TimeoutException te) {
            System.out.println("All SongsPage elements aren't visible.");
        }
    }

    public void clickCreateSong() {
        createsongLink.click();
    }

    public void clickLogout() {
        logoutLink.click();
    }

    public void selectSong(String songName) throws Exception {

        for (WebElement songLink : songLinks) {
            if (songLink.getText().equals(songName)) {
                songLink.click();
            }
        }
        throw new Exception(songName + " is not in the songList");
    }

    public void validateSuccessfulLoginMessage(String message) {
        try {
            waitForElementVisible(successfullLoginFlashMessage);
            Assert.assertEquals("Successful Login Flash Message is present.",successfullLoginFlashMessage.getText(), message);
            //System.out.println("Successful Login Flash Message is present");
        } catch (TimeoutException te) {
            System.out.println("Successful Login Flash Message isn't present.");
        }
    }

    public void validateDeletedSong() {
        try {
            waitForElementVisible(songDeletedFlashMessage);
            Assert.assertEquals("Delete Song Flash Message is present.",songDeletedFlashMessage.getText(), "Song deleted");
            //System.out.println("Delete Song Flash Message is present.");
        } catch (TimeoutException te) {
            System.out.println("Delete Song Flash Message isn't present.");
        }
    }
}
