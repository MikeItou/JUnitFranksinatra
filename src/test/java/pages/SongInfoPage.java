package pages;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SongInfoPage extends BasePage{

    @FindBy(xpath="//p[ contains( text(), 'Release')]")
    WebElement releaseDateSongInfo;
    @FindBy(xpath = "//p[ contains( text(), 'Length')]")
    WebElement lengthSongInfo;
    @FindBy(css="section pre")
    WebElement lyricsInfo;
    @FindBy(css="#like p")
    WebElement numberOfLikesInfo;
    @FindBy(css="[value='Like']")
    WebElement likeButton;
    @FindBy(css="p a[href='/songs']")
    WebElement indexSongLink;
    @FindBy(css="[href*='/edit']")
    WebElement editSongslink;
    @FindBy(css="[value='delete this song']")
    WebElement deleteSongButton;
    @FindBy(css="section h1")
    WebElement specificSongName;
    @FindBy(css = ".flash")
    WebElement updatedFlashMessage;

    public SongInfoPage(WebDriver driver) {
        super(driver);
    }

    public void validateSpecificSongPageInfo(String title){
        try{
            waitForElementVisible(specificSongName);
            waitForElementVisible(releaseDateSongInfo);
            waitForElementVisible(lengthSongInfo);
            waitForElementVisible(lyricsInfo);
            waitForElementVisible(numberOfLikesInfo);
            waitForElementVisible(likeButton);
            waitForElementVisible(indexSongLink);
            waitForElementVisible(editSongslink);
            waitForElementVisible(deleteSongButton);
            System.out.println("All SpecificSongPage elements of "+ title +" song are visible.");
        }catch (TimeoutException te){
            throw new TimeoutException("All SpecificSongPage elements of "+ title +" song aren't visible.");
        }
    }

    public void clickLikeButton(){
        likeButton.click();
    }
    public void clickSongsIndex(){
        indexSongLink.click();
    }
    public void clickEditSong(){
        editSongslink.click();
    }
    public void clickDeleteSong(){
        deleteSongButton.click();
    }

    public String updateLikeNumbers(){
        if ((numberOfLikesInfo.getText()).contains("Nobody")){
            System.out.println("Number on likes is 0.");
            return "0";
        }

        else if ((numberOfLikesInfo.getText()).contains("once")){
            return "1";
        }

        else {
            String[] partsOfMessage = (numberOfLikesInfo.getText()).split(" ");
            return partsOfMessage[partsOfMessage.length-2];
        }
    }

    public void compareLikeNumbers(String beforeLike, String afterLike) {
        int beforeCast = Integer.parseInt(beforeLike);
        int afterCast = Integer.parseInt(afterLike);

        if (beforeCast > afterCast) {
            System.out.println("INCORRECT!! There's a decrease in the number of likes." +
                    "\nBefore Like count: " + beforeLike +
                    "\nAfter Like count: " + afterLike);
        }

        else if (afterCast == beforeCast){
            System.out.println("INCORRECT!! There's no change in the like numbers." +
                    "\nBefore Like count: " + beforeLike +
                    "\nAfter Like count: " + afterLike);
        }

        else{
            System.out.println("CORRECT!! There's a increase in the number of likes." +
                    "\nBefore Like count: " + beforeLike +
                    "\nAfter Like count: " + afterLike);

        }
    }

    public void validateSuccessfulUpdatedMessage(String updatedMessage) {
        try {
            waitForElementVisible(updatedFlashMessage);
            Assert.assertEquals(updatedFlashMessage.getText(),updatedMessage);
            System.out.println("Updated Song Flash Message is visible.");
        }
        catch (TimeoutException te){
            throw new TimeoutException("Updated Song Flash Message isn't visible.");
        }
    }
}
