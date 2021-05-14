package pages;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(css="[name='username']")
    WebElement usernameField;
    @FindBy(css="[name='password']")
    WebElement passwordField;
    @FindBy(css="[type='submit']")
    WebElement loginButton;
    @FindBy(css=".flash")
    WebElement errorLoginFlashMessage;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void validateLoginPage(){
        try {
            waitForElementVisible(usernameField);
            waitForElementVisible(passwordField);
            waitForElementVisible(loginButton);
            System.out.println("All LoginPage elements are visible.");
        }catch (TimeoutException te){
            System.out.println("All LoginPage elements aren't visible.");
        }
    }

    public void fillLoginValues(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void validateWrongLogin(){
        try{
            waitForElementVisible(errorLoginFlashMessage);
            Assert.assertEquals("The text is incorrect", errorLoginFlashMessage.getText(), "The username or password you entered are incorrect");
            //explicitWait.until(ExpectedConditions.attributeContains(errorLoginFlashMessage, "textContent", "The username or password you entered are incorrect"));
        }catch (TimeoutException te){
            System.out.println("Error Login Flash Message isn't visible.");
        }
    }
}
