package seleniumgluecode;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private static ChromeDriver driver;
    private static int numberOfCase=0;

    @Before
    public void setup(){
        numberOfCase++;
        System.out.println("Se esta ejecutando el escenario: "+numberOfCase);
        System.setProperty("webdriver.chrome.driver","./src/test/java/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();

    }

    
    @After
    public void tearDown(){
        System.out.println("El escensario "+numberOfCase+" se ejecuto correctamente.");
        driver.quit();
    }

    public static ChromeDriver getDriver(){
        return driver;
    }
    
}
