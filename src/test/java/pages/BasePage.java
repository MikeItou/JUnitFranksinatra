package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait explicitWait;


    public BasePage(WebDriver driver){
        this.driver = driver;
        this.explicitWait = new WebDriverWait(this.driver,5);
        PageFactory.initElements(this.driver,this);
    }

    protected WebElement waitForElementVisible(WebElement element){
        return this.explicitWait.until(ExpectedConditions.visibilityOf(element));
    }
}
