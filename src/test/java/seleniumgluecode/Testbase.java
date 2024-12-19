package seleniumgluecode;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en_old.Ac;
import pom.AccountsOverviewPage;
import pom.HomePage;
import pom.OpenNewAccount;
import pom.RegisterPage;

public class Testbase {
    
    private WebDriverWait wait;   
    protected ChromeDriver driver = Hooks.getDriver();
    private Actions actions;
    protected HomePage homePage = new HomePage(driver, wait, actions);
    protected RegisterPage registerPage = new RegisterPage(driver, wait, actions);
    protected OpenNewAccount openNewAccount = new OpenNewAccount(driver, wait, actions);
    protected AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver, wait, actions);

}
