package pages;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends BasePage{

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="//p[contains(.,'This')]")
    WebElement aboutPageMessage;
    @FindBy(css="[href='/logout']")
    WebElement logoutLink;
    //@FindBy(css="[href='/login']")
    //WebElement loginLink;

    public void validateAboutPage(){
        try {
            waitForElementVisible(logoutLink);
            waitForElementVisible(aboutPageMessage);
            Assert.assertEquals("About Page elements aren visible.",aboutPageMessage.getText(),"This site is a demonstration of how to build a website using Sinatra.");
        }catch (TimeoutException te){
            System.out.println("About Page elements aren't visible.");
        }
    }

    public void clickLogout(){
        logoutLink.click();
    }

}
