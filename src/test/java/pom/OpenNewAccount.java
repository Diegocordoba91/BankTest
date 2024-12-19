package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenNewAccount extends BasePage {

    private By buttonNewAccount = By.xpath("//a[text()='Open New Account']");
    private By titleNewAccount = By.xpath("//h1[text()='Open New Account']");
    private By selectAccount = By.id("type");
    private By selectAccuntSaving = By.xpath("//option[@value='1']");
    private By buttonSaveNewAccount = By.cssSelector("input[class=\"button\"]");
    private By messageAccountOpened = By.id("openAccountResult");
    private By idNumberNewAccount = By.id("newAccountId");

      
    
    public OpenNewAccount (WebDriver driver, WebDriverWait wait, Actions actions){
        super(driver,wait, actions);
        
    }

    public void clickButtonNewAccount() throws InterruptedException{
        this.clickElement(buttonNewAccount);
    }

    public boolean validationMessageOpenNewAccount() throws InterruptedException{

        return this.elementDispaleyed(titleNewAccount);
    }

    public void selectAccountSaving () throws InterruptedException{
        this.selectionDropdownItem(selectAccount, SelectionType.TEXT, "SAVINGS");
    }

    public void clickSaveAccount () throws InterruptedException{
        this.clickElement(buttonSaveNewAccount);
    }

    public boolean validationSaveNewAccount() throws InterruptedException{

        return this.elementDispaleyed(messageAccountOpened);
    }

    public boolean validationNumerNewAccount() throws InterruptedException{
        return this.elementDispaleyed(idNumberNewAccount) ;
    }

  

    










    


}
