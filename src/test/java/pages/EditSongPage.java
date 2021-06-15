package pages;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSongPage extends BasePage{

    @FindBy(css="#title")
    WebElement titleField;
    @FindBy(css="#length")
    WebElement lengthField;
    @FindBy(css="#released_on")
    WebElement releaseField;
    @FindBy(css="#lyrics")
    WebElement lyricsField;
    @FindBy(css="[value='Save Song']")
    WebElement saveSongButton;
    @FindBy(xpath="//h1[contains(.,'Internal')]")
    WebElement internalErrorMessage;

    public EditSongPage(WebDriver driver){
        super(driver);
    }

    public void validateEditSongPage(){
        try{
            waitForElementVisible(titleField);
            waitForElementVisible(lengthField);
            waitForElementVisible(releaseField);
            waitForElementVisible(lyricsField);
            waitForElementVisible(saveSongButton);
            System.out.println("All EditSongPage elements are visible.");
        }catch (TimeoutException te){
            throw new TimeoutException("All EditSongsPage elements aren't visible.");
        }
    }

    public void editSongFields(String title, String length, String date, String lyrics){
        if (!title.equals("Nothing to change")){
            titleField.clear();
            titleField.sendKeys(title);
        }

        if (!length.equals("Nothing to change")){
            lengthField.clear();
            lengthField.sendKeys(length);
        }

        if (!date.equals("Nothing to change")){
            releaseField.sendKeys(date);
            releaseField.clear();
        }

        if (!lyrics.equals("Nothing to change")){
            lyricsField.clear();
            lyricsField.sendKeys(lyrics);
        }

        saveSongButton.click();
    }

    public void internalServerError(String errorMessage){
        try {
            waitForElementVisible(internalErrorMessage);
            Assert.assertEquals(internalErrorMessage.getText(),errorMessage);
            System.out.println("Error message is present");
        }catch (TimeoutException te){
            throw new TimeoutException("Error message isn't present");
        }
    }
}
