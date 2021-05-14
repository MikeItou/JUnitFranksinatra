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
    @FindBy(css = "//p[contains(.,'You need to be')]")
    WebElement loggedinMessage;
    @FindBy(css = "//a[contains(.,'logged in')]")
    WebElement loggedinLink;
    @FindBy(css = "//a[contains(.,'log in')]")
    WebElement loginLink;

    public void validateUnauthorizePage(){
        try {
            waitForElementVisible(unauthorizedHeader);
            Assert.assertEquals(unauthorizedHeader.getText(),"Unauthorized");
            waitForElementVisible(loggedinMessage);
            Assert.assertEquals(loggedinMessage.getText(),"You need to be logged in to view this page.");
            waitForElementVisible(loggedinLink);
            waitForElementVisible(loginLink);
            System.out.println("Unauthorized Page elements are visible.");
        }catch (TimeoutException te){
            System.out.println("Unauthorized Page elements aren't visible.");
        }
    }

    public void clickLoggedin(){
        loggedinLink.click();
    }

    public void clickLogin(){
        loginLink.click();
    }

}
