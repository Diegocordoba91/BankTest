package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsOverviewPage extends BasePage {

    private By buttonAccountsOverview = By.xpath("//a[text()='Accounts Overview']");
    private By messageAccountsOverview = By.cssSelector("td[colspan=\"3\"]");
    private By buttonTransferFounds = By.xpath("//a[text()='Transfer Funds']");
    private By messageTransferFounds = By.xpath("//a[contains(text(),\"Transfer Funds\")]");
    private By inputAmount = By.id("amount");
    private By selectFromAccount = By.id("fromAccountId");
    private By selectionFromAccountOptionOne=By.xpath("//select[@id='fromAccountId']/option[1]");
    private By selectToAccount=By.id("toAccountId");
    private By selectToAccountOptionOne = By.xpath("//select[@id='toAccountId']/option[2]");
    private By buttonTransfer = By.cssSelector("input[type='submit'][class='button'][value='Transfer']");
    private By messageTransferComplete = By.xpath("//h1[contains(text(), 'Transfer Complete!')]");
    private By tableAccounts = By.id("accountTable");
    private  List<String> accountsWhitBalance = new ArrayList<>();
    private List<String> accountsWhitOutBalance = new ArrayList<>();
    
       
        public AccountsOverviewPage (WebDriver driver, WebDriverWait wait, Actions actions){
            super(driver,wait,actions);
        }
    
        public void clickButtonAccountsOverview() throws InterruptedException{
            this.clickElement(buttonAccountsOverview);
        }
    
        public boolean validationMessageAccountsOverview() throws InterruptedException{
            //this.getAccountsResults();
            //System.out.println(accountsWhitBalance.get(0));
    
            return this.elementDispaleyed(messageAccountsOverview);
        }
    
        public void clickButtonTransferFounds() throws InterruptedException{
            this.clickElement(buttonTransferFounds);
            
        }
    
        public boolean validationMessageTransferFounds() throws InterruptedException{

            return this.elementDispaleyed(messageTransferFounds);
        }
    
        public void enterAmountSend() throws InterruptedException{
               
           this.sendText(inputAmount, "100");
        }
    
        public void getAccountsResults(){
    
            WebElement table = this.findElement(tableAccounts);

            List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));

            for(WebElement row:rows){
                try {
                    List<WebElement> cells = row.findElements(By.tagName("td"));
                    if (cells.size() >= 3) {
                        // Obtener el texto de la columna "Account"
                        String account = cells.get(0).getText().trim();

                        // Obtener el texto de la columna "Available Amount" y limpiarlo
                        String availableAmountText = cells.get(2).getText().replace("$", "").replace(",", "").trim();

                        // Validar si el valor de "Available Amount" es numérico
                        double availableAmount = availableAmountText.isEmpty() ? 0.0 : Double.parseDouble(availableAmountText);

                        // Clasificar las cuentas según el saldo
                        if (availableAmount > 0) {
                            accountsWhitBalance.add(account);
                        } else {
                            accountsWhitOutBalance.add(account);
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Error al procesar una fila: " + e.getMessage());
                    }
                }

        

        }
    
    public void selectFromAccountList() throws InterruptedException{
        
        this.clickElement(selectFromAccount);
        this.clickElement(selectionFromAccountOptionOne);
    }

    public void selectToAccount() throws InterruptedException{
        this.clickElement(selectToAccount);
        this.clickElement(selectToAccountOptionOne);
    }

    public void clickButtonTransfer() throws InterruptedException{
        this.clickElement(buttonTransfer);
    }

    public boolean validationMessageTransfercomplete() throws InterruptedException{
        return this.elementDispaleyed(messageTransferComplete);
    }


    
}
