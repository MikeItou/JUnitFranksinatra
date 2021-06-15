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

    @FindBy(xpath="//p[contains(.,'This site')]")
    WebElement aboutPageMessage;

    public void validateAboutPage(){
        try {
            waitForElementVisible(aboutPageMessage);
            Assert.assertEquals(aboutPageMessage.getText(),"This site is a demonstration of how to build a website using Sinatra.");
            System.out.println("About Page elements are visible.");
        }catch (TimeoutException te){
            throw new TimeoutException("About Page elements aren't visible.");
        }
    }
}
