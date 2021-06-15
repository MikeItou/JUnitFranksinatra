package tests;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

@RunWith(JUnitParamsRunner.class)
public class SongSuite extends BaseTest{
    @Test
    @FileParameters("./data/CreateNewSong.csv")
    public void createNewSong(String browser, String url, String username, String password, String title, String duration, String date, String lyrics){
        Random rd = new Random();

        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        songsPage.clickCreateSong();
        createSongPage.validateCreateSongPage();
        createSongPage.fillCreateSongFields(title,duration,date,lyrics);
        createSongPage.validateCreatedSong();
    }

    @Test
    @FileParameters("./data/DeleteSong.csv")
    public void deleteSong(String browser, String url, String username, String password, String title) throws Exception {
        setupWebPage(browser, url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        songsPage.selectSong(title);
        songInfoPage.validateSpecificSongPageInfo(title);
        songInfoPage.clickDeleteSong();
       songsPage.validateDeletedSong();
    }

    @Test
    @FileParameters("./data/LikeSong.csv")
    public void likeSong(String browser, String url, String username, String password, String title){
        String afterLike, beforeLike;

        setupWebPage(browser,url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        songsPage.selectSong(title);
        songInfoPage.validateSpecificSongPageInfo(title);
        for (int i = 0; i < 1 ; i++) {
            beforeLike = songInfoPage.updateLikeNumbers();
            songInfoPage.clickLikeButton();
            afterLike = songInfoPage.updateLikeNumbers();
            songInfoPage.compareLikeNumbers(beforeLike, afterLike);
        }
    }

    @Test
    @FileParameters("./data/BackSongIndex.csv")
    public void backSongIndex(String browser, String url, String username, String password, String title){
        setupWebPage(browser,url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        songsPage.selectSong(title);
        songInfoPage.validateSpecificSongPageInfo(title);
        mainPage.verifyLogoutLink();
        songInfoPage.clickSongsIndex();
        songsPage.validateSongsPage();
    }

    @Test
    @FileParameters("./data/EditSongTitle.csv")
    public void editSongTitle(String browser, String url, String username, String password, String title, String newTitle, String newLength, String newDate, String newLyrics){
        setupWebPage(browser,url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        songsPage.selectSong(title);
        songInfoPage.validateSpecificSongPageInfo(title);
        songInfoPage.clickEditSong();
        editSongPage.validateEditSongPage();
        editSongPage.editSongFields(newTitle,newLength,newDate,newLyrics);
        songInfoPage.validateSuccessfulUpdatedMessage("Song successfully updated");
        songInfoPage.validateSpecificSongPageInfo(newTitle);
    }

    @Test
    @FileParameters("./data/EditSongDuration.csv")
    public void editSongDuration(String browser, String url, String username, String password, String title, String newTitle, String newLength, String newDate, String newLyrics){
        setupWebPage(browser,url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        songsPage.selectSong(title);
        songInfoPage.validateSpecificSongPageInfo(title);
        songInfoPage.clickEditSong();
        editSongPage.validateEditSongPage();
        editSongPage.editSongFields(newTitle,newLength,newDate,newLyrics);
        songInfoPage.validateSuccessfulUpdatedMessage("Song successfully updated");
        songInfoPage.validateSpecificSongPageInfo(title);
    }

    @Test
    @FileParameters("./data/EditSongDate.csv")
    public void editSongDate(String browser, String url, String username, String password, String title, String newTitle, String newLength, String newDate, String newLyrics){
        setupWebPage(browser,url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        songsPage.selectSong(title);
        songInfoPage.validateSpecificSongPageInfo(title);
        songInfoPage.clickEditSong();
        editSongPage.validateEditSongPage();
        editSongPage.editSongFields(newTitle,newLength,newDate,newLyrics);
        songInfoPage.validateSuccessfulUpdatedMessage("Song successfully updated");
        songInfoPage.validateSpecificSongPageInfo(title);
    }

    @Test
    @FileParameters("./data/EditSongLyrics.csv")
    public void editSongLyrics(String browser, String url, String username, String password, String title, String newTitle, String newLength, String newDate, String newLyrics){
        setupWebPage(browser,url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        songsPage.selectSong(title);
        songInfoPage.validateSpecificSongPageInfo(title);
        songInfoPage.clickEditSong();
        editSongPage.validateEditSongPage();
        editSongPage.editSongFields(newTitle,newLength,newDate,newLyrics);
        songInfoPage.validateSuccessfulUpdatedMessage("Song successfully updated");
        songInfoPage.validateSpecificSongPageInfo(title);
    }

    @Test
    @FileParameters("./data/EditVoidSongTitle.csv")
    public void editVoidSongTitle(String browser, String url, String username, String password, String title, String newTitle, String newLength, String newDate, String newLyrics){
        setupWebPage(browser,url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        songsPage.selectSong(title);
        songInfoPage.validateSpecificSongPageInfo(title);
        songInfoPage.clickEditSong();
        editSongPage.validateEditSongPage();
        editSongPage.editSongFields(newTitle,newLength,newDate,newLyrics);
        songInfoPage.validateSuccessfulUpdatedMessage("Song successfully updated");
        songInfoPage.validateSpecificSongPageInfo(newTitle);
    }

    @Test
    @FileParameters("./data/EditVoidSongDuration.csv")
    public void editVoidSongDuration(String browser, String url, String username, String password, String title, String newTitle, String newLength, String newDate, String newLyrics){
        setupWebPage(browser,url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        songsPage.selectSong(title);
        songInfoPage.validateSpecificSongPageInfo(title);
        songInfoPage.clickEditSong();
        editSongPage.validateEditSongPage();
        editSongPage.editSongFields(newTitle,newLength,newDate,newLyrics);
        songInfoPage.validateSuccessfulUpdatedMessage("Song successfully updated");
        songInfoPage.validateSpecificSongPageInfo(newTitle);
    }

    @Test
    @FileParameters("./data/EditVoidSongLyrics.csv")
    public void editVoidSongLyrics(String browser, String url, String username, String password, String title, String newTitle, String newLength, String newDate, String newLyrics){
        setupWebPage(browser,url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        songsPage.selectSong(title);
        songInfoPage.validateSpecificSongPageInfo(title);
        songInfoPage.clickEditSong();
        editSongPage.validateEditSongPage();
        editSongPage.editSongFields(newTitle,newLength,newDate,newLyrics);
        songInfoPage.validateSuccessfulUpdatedMessage("Song successfully updated");
        songInfoPage.validateSpecificSongPageInfo(newTitle);
    }

    @Test
    @FileParameters("./data/EditVoidSongDate.csv")
    public void editVoidSongDate(String browser, String url, String username, String password, String title, String newTitle, String newLength, String newDate, String newLyrics){
        setupWebPage(browser,url);
        mainPage.validateMainPage();
        mainPage.verifyLoginLink();
        mainPage.clickLoginLink();
        loginPage.validateLoginPage();
        loginPage.fillLoginValues(username, password);
        songsPage.validateSuccessfulLoginMessage("You are now logged in as " + username);
        songsPage.validateSongsPage();
        songsPage.selectSong(title);
        songInfoPage.validateSpecificSongPageInfo(title);
        songInfoPage.clickEditSong();
        editSongPage.validateEditSongPage();
        editSongPage.editSongFields(newTitle,newLength,newDate,newLyrics);
        editSongPage.internalServerError("Internal Server Error");
    }
}
