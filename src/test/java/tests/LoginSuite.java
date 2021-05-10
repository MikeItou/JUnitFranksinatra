package tests;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@RunWith(JUnitParamsRunner.class)
public class LoginSuite extends BasePage {

    public LoginSuite(WebDriver driver) {
        super(driver);
    }

    @Test
    @FileParameters("./data/CorrectLogin.csv")
    public void correctLogin(String browser, String url){
    }
}
