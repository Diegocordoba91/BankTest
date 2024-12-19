package pom;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {


    private String titleHomePage = "ParaBank | Welcome | Online Banking";
    private By buttonRegister = By.xpath("//a[text()='Register']");
    
    public HomePage (WebDriver driver, WebDriverWait wait, Actions actions){
        super(driver,wait,actions);
    }

    public String titleHomePage() throws InterruptedException{
        return this.getTitle();
    }
    
    public boolean titleHomePageDisplayed() throws InterruptedException{
        return this.getTitle().contentEquals(titleHomePage);
    }
    
    public void clickButtonRegister() throws InterruptedException{
        this.moveElementClick(this.findElement(buttonRegister));
    }

    public void findButtonRegister(){
        try {

            this.findElement(buttonRegister);
            System.out.println("Encontre el boton");
            
        } catch (Exception e) {
            System.out.println("Elemento no disponible: "+e);
        }
        
        
        
    }


    


    
}
