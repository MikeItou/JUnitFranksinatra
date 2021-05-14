package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    @FindBy(css="[href='/logout']")
    WebElement logoutLink;
    WebElement specificSongName;

    public SongInfoPage(WebDriver driver) {
        super(driver);
    }

    public void validateSpecificSongPage(String songName){
        try{
            specificSongName = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(.,"+songName+")]")));
            waitForElementVisible(releaseDateSongInfo);
            waitForElementVisible(lengthSongInfo);
            waitForElementVisible(lyricsInfo);
            waitForElementVisible(numberOfLikesInfo);
            waitForElementVisible(likeButton);
            waitForElementVisible(indexSongLink);
            waitForElementVisible(editSongslink);
            waitForElementVisible(deleteSongButton);
            waitForElementVisible(logoutLink);
            System.out.println("All SpecificSongPage elements are visible.");
        }catch (TimeoutException te){
            System.out.println("All SpecificSongPage elements aren't visible.");
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

    public void updateLikeNumbers(String likeTimes){
        try{
            waitForElementVisible(numberOfLikesInfo);
            if(likeTimes.equals("once")){
                Assert.assertEquals(numberOfLikesInfo.getText(),"This song has been liked " + likeTimes);
            }
            else{
                Assert.assertEquals(numberOfLikesInfo.getText(),"This song has been liked " + likeTimes + "times");
            }
            System.out.println("Number of likes is present and up to date.");
        }catch (TimeoutException te){
            System.out.println("Number of likes is not present.");
        }
    }

}
