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
    @FindBy(css="//h1[contains(.,'Internal')]")
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
            System.out.println("All EditSongsPage elements aren't visible.");
        }
    }

    public void editSongFields(String title, String length, String date, String lyrics){
        if (!title.isEmpty()){
            titleField.clear();
            titleField.sendKeys(title);
            System.out.println("Holo ado en el titulo.");
        }

        if (!length.isEmpty()){
            lengthField.clear();
            lengthField.sendKeys(length);
            System.out.println("Holo ado en la duracion.");
        }

        if (!date.isEmpty()){
            releaseField.clear();
            releaseField.sendKeys(date);
            System.out.println("Holo ado en la fecha.");
        }

        if (!lyrics.isEmpty()){
            lyricsField.clear();
            lyricsField.sendKeys(length);
            System.out.println("Holo ado en la letra dela cancion.");
        }
        saveSongButton.click();
    }

    public void internalServerError(String errorMessage){
        try {
            waitForElementVisible(internalErrorMessage);
            Assert.assertEquals(internalErrorMessage.getText(),errorMessage);
            System.out.println("Error message is present");
        }catch (TimeoutException te){
            System.out.println("Error message isn't present");
        }
    }
}
