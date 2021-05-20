package pages;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(css="[href='/']")
    WebElement homeLink;
    @FindBy(css="[href='/about']")
    WebElement aboutLink;
    @FindBy(css="[href='/contact']")
    WebElement contactLink;
    @FindBy(css="[href='/songs']")
    WebElement songsLink;
    @FindBy(css="section p")
    WebElement welcomeLegend;
    @FindBy(css="[alt='Frank Sinatra']")
    WebElement imageFrankSinatra;
    @FindBy(css="[href='/login']")
    WebElement loginLink;
    @FindBy(css="[href='/logout']")
    WebElement logoutLink;
    @FindBy(css = ".flash")
    WebElement successfullLogoutFlashMessage;

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void validateMainPage(){
        try{
            waitForElementVisible(welcomeLegend);
            waitForElementVisible(imageFrankSinatra);
            System.out.println("All MainPage elements are visible.");
        }catch (TimeoutException te){
            System.out.println("All MainPage elements aren't visible.");
        }
    }

    public void validateMenu(){
        try{
            waitForElementVisible(homeLink);
            waitForElementVisible(aboutLink);
            waitForElementVisible(contactLink);
            waitForElementVisible(songsLink);
            System.out.println("All menu elements are visible.");
        }catch (TimeoutException te){
            System.out.println("All menu elements aren't visible.");
        }
    }

    public void clickHomeLink(){
        homeLink.click();
    }

    public void clickAboutLink(){
        aboutLink.click();
    }

    public void clickContactLink(){
        contactLink.click();
    }

    public void clickSongsLink(){
        songsLink.click();
    }

    public void clickLoginLink(){
        loginLink.click();
    }

    public void clickLogoutLink(){logoutLink.click();}

    public void verifyLoginLink(){
        try {
            waitForElementVisible(loginLink);
            System.out.println("Login link is present.");
        }catch (TimeoutException te){
            System.out.println("Login link isn't present.");
        }
    }

    public void verifyLogoutLink(){
        try {
            waitForElementVisible(logoutLink);
            System.out.println("Logout link is present.");
        }catch (TimeoutException te){
            System.out.println("Logout link isn't present.");
        }
    }

    public void validateSuccessfulLogoutMessage(String message){
        try {
            waitForElementVisible(successfullLogoutFlashMessage);
            Assert.assertEquals("Successful Logout Flash Message is present.",successfullLogoutFlashMessage.getText(), message);
            //System.out.println("Successful Login Flash Message is present");
        } catch (TimeoutException te) {
            System.out.println("Successful Logout Flash Message isn't present.");
        }
    }
}
