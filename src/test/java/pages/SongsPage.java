package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SongsPage extends BasePage{

    @FindBy(css=".flash")
    WebElement successfullLoginFlashMessage;
    @FindBy(css="section h1")
    WebElement songsHeader;
    @FindBy(css="[href='/songs/new']")
    WebElement createsongLink;
    @FindBy(css="#songs")
    WebElement songList;
    @FindBy(css="[href='/logout']")
    WebElement logoutLink;
    WebElement specificSongLink;
    WebElement specificSongName;
    @FindBy(css="section p:nth-child(2)")
    WebElement releaseDateSongInfo;
    @FindBy(css="section p:nth-child(3)")
    WebElement lengthSongInfo;
    @FindBy(css="section pre")
    WebElement lyricsInfo;
    @FindBy(css="section div p")
    WebElement likeInfo;
    @FindBy(css="[value='Like']")
    WebElement likeButton;
    @FindBy(css="p a[href='/songs']")
    WebElement indexSongLink;
    @FindBy(css="section:nth-child(2) > p:nth-child(7) > a")
    WebElement editSongslink;
    @FindBy(css="[value='delete this song']")
    WebElement deleteSongButton;
    @FindBy(css=".flash")
    WebElement songDeletedFlashMessage;

    public SongsPage(WebDriver driver){
        super(driver);
    }

    public void validateSongsPage(){
        try{
            explicitWait.until(ExpectedConditions.attributeContains(waitForElementVisible(successfullLoginFlashMessage),"div","You are now logged in as"));
            waitForElementVisible(songsHeader);
            waitForElementVisible(createsongLink);
            waitForElementVisible(songList);
            waitForElementVisible(logoutLink);

            System.out.println("All SongsPage elements are visible.");
        }catch (TimeoutException te){
            System.out.println("All SongsPage elements aren't visible.");
        }
    }

    public void clickCreateSong(){
        createsongLink.click();
    }
    public void clickLogout(){
        logoutLink.click();
    }
    public void selectSong(String songName){
        specificSongLink = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/ul/li[contains(.,"+songName+")]/a")));
        specificSongLink.click();
    }

    public void validateSpecificSongPage(String songName){
        try{
             specificSongName = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(.,"+songName+")]")));
             waitForElementVisible(releaseDateSongInfo);
             waitForElementVisible(lengthSongInfo);
             waitForElementVisible(lyricsInfo);
             waitForElementVisible(likeInfo);
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
    public void validateDeletedSong(){
        explicitWait.until(ExpectedConditions.attributeContains(waitForElementVisible(songDeletedFlashMessage),"div","Song deleted"));
    }

}
