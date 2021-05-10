package pages;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait explicitWait;

    @After
    public void after(){
        //this.driver.quit();
    }
    public BasePage(WebDriver driver){
        this.driver = driver;
        this.explicitWait = new WebDriverWait(this.driver,5);
        PageFactory.initElements(this.driver,this);
    }

    public void setupWebPage(String browser, String url){
        switch (browser) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "safari" -> driver = new SafariDriver();
            case "opera" -> driver = new OperaDriver();
            case "edge" -> driver = new EdgeDriver();
        }
        this.driver.get(url);
    }

    protected WebElement waitForElementVisible(WebElement element){
        return this.explicitWait.until(ExpectedConditions.visibilityOf(element));
    }
}
