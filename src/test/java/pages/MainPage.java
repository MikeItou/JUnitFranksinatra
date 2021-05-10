package pages;

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

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void validateMainPage(){
        try{
            waitForElementVisible(homeLink);
            waitForElementVisible(aboutLink);
            waitForElementVisible(contactLink);
            waitForElementVisible(songsLink);
            waitForElementVisible(welcomeLegend);
            waitForElementVisible(imageFrankSinatra);
            waitForElementVisible(loginLink);
            System.out.println("All MainPage elements are visible.");
        }catch (TimeoutException te){
            System.out.println("All MainPage elements aren't visible.");
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
}
