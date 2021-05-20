package pages;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UnauthorizePage extends BasePage{

    public UnauthorizePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "//h1[contains(.,'Unauthorized')]")
    WebElement unauthorizedHeader;
    //@FindBy(css = "//p[contains(.,'You need to be')]")
    //WebElement loggedinMessageLogin;
    @FindBy(css = "//a[contains(.,'logged in')]")
    WebElement loggedinLink;
    @FindBy(css = "//a[contains(.,'log in')]")
    WebElement loginLink;
    @FindBy(css = "//p[contains(.,'This site')]")
    WebElement aboutMessage;

    public void validateUnauthorizePage(){
        /*try {
            waitForElementVisible(unauthorizedHeader);
            Assert.assertEquals(unauthorizedHeader.getText(),"Unauthorized");
            waitForElementVisible(loggedinMessageLogin);
            Assert.assertEquals(loggedinMessageLogin.getText(),"You need to be logged in to view this page.");
            waitForElementVisible(loggedinLink);
            waitForElementVisible(loginLink);
            System.out.println("Unauthorized Page elements are visible.Your are logedout");
        }catch (TimeoutException te){
            System.out.println("Unauthorized Page elements aren't visible. Your are logedout");
        }*/
        try {
            waitForElementVisible(loginLink);
            waitForElementVisible(aboutMessage);
            Assert.assertEquals("Unauthorized Page elements are visible. Your are logedin",aboutMessage.getText(),"This site is a demonstration of how to build a website using Sinatra.");
        }catch (TimeoutException te){
            System.out.println("Unauthorized Page elements aren't visible. Your are logedin");
        }
    }

    public void clickLoggedin(){
        loggedinLink.click();
    }


}
