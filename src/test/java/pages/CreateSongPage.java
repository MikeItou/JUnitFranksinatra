package pages;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateSongPage extends BasePage{

    public CreateSongPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#title")
    WebElement titleField;
    @FindBy(css="#length")
    WebElement lengthField;
    @FindBy(css="#released_on")
    WebElement dateField;
    @FindBy(css="#lyrics")
    WebElement lyricsField;
    @FindBy(css="[type='submit']")
    WebElement saveSongButton;
    @FindBy(css="//h1[contains(.,'Add')]")
    WebElement addSongHeader;
    @FindBy(css = ".flash")
    WebElement createdSongFlashMessage;

    public void validateCreateSongPage(){
        try{
            waitForElementVisible(addSongHeader);
            Assert.assertEquals(addSongHeader.getText(),"Add a New Song");
            waitForElementVisible(titleField);
            waitForElementVisible(lengthField);
            waitForElementVisible(dateField);
            waitForElementVisible(lyricsField);
            waitForElementVisible(saveSongButton);
            System.out.println("Create Song Page elements are visible.");
        }catch (TimeoutException te){
            System.out.println("Create Song Page elements aren´t visible.");
        }
    }

    public void fillCreateSongFields(String title, String length, String date, String lyrics){
        titleField.sendKeys(title);
        lengthField.sendKeys(length);
        dateField.sendKeys(date);
        lyricsField.sendKeys(lyrics);
        saveSongButton.click();
    }

    public void validateCreatedSong(){
        try {
            waitForElementVisible(createdSongFlashMessage);
            Assert.assertEquals("Created Song flash message is visible.",createdSongFlashMessage.getText(),"Song successfully added");
        }catch (TimeoutException te){
            System.out.println("Created Song flash message isn't visible.");
        }
    }
}
