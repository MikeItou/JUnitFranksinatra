package pages;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage{

    @FindBy(css="[name='name']")
    WebElement nameField;
    @FindBy(css="[for='name']")
    WebElement nameTag;
    @FindBy(css="[name='email']")
    WebElement emailField;
    @FindBy(css="[for='email']")
    WebElement emailTag;
    @FindBy(css="[name='message']")
    WebElement messageField;
    @FindBy(css="[for='message']")
    WebElement messageTag;
    @FindBy(css="[type='submit']")
    WebElement sendMessageButton;
    @FindBy(xpath="//p[contains(.,'You can')]")
    WebElement contactMessage;
    @FindBy(xpath = "//h1[contains(.,'Internal')]")
    WebElement internalErrorMesage;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void validateContactPage(){
        try{
            waitForElementVisible(contactMessage);
            Assert.assertEquals(contactMessage.getText(),"You can contact me by filling in the form below:");
            waitForElementVisible(nameTag);
            Assert.assertEquals(nameTag.getText(),"Name:");
            waitForElementVisible(nameField);
            waitForElementVisible(emailTag);
            Assert.assertEquals(emailTag.getText(),"Email:");
            waitForElementVisible(emailField);
            waitForElementVisible(messageTag);
            Assert.assertEquals(messageTag.getText(),"Your Message:");
            waitForElementVisible(messageField);
            waitForElementVisible(sendMessageButton);
            //Assert.assertEquals(,sendMessageButton.getText(),"Send Message");

            System.out.println("All ContactPage elements are visible.");
        }catch (TimeoutException te){
            System.out.println("All ContactPage elements aren't visible.");
        }
    }

    public void fillContactFields(String name, String email, String message){
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        messageField.sendKeys(message);
        sendMessageButton.click();
    }

    public void validateErrorMessage(){
        try {
            waitForElementVisible(internalErrorMesage);
            System.out.println("Error message is present.");
        }catch (TimeoutException te){
            System.out.println("Error message isn't present.");
        }
    }
}
