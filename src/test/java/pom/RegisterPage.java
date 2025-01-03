package pom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage{
    
    private By titleRegisterPage = By.cssSelector("h1[class=\"title\"]");
    private By formRegisterUser = By.cssSelector("form[id=\"customerForm\"]");
    private String urlRegisterPage = "https://parabank.parasoft.com/parabank/register.htm";
    private By inputFirstName = By.id("customer.firstName");
    private By inputLastaName = By.id("customer.lastName");
    private By inputAdress = By.id("customer.address.street");
    private By inputCity = By.id("customer.address.city");
    private By inputState = By.id("customer.address.state");
    private By inputZipCode = By.id("customer.address.zipCode");
    private By inputPhone = By.id("customer.phoneNumber");
    private By inputSSN = By.id("customer.ssn");
    private By inputUserName = By.id("customer.username");
    private By inputPassword = By.id("customer.password");
    private By inputConfirmPassword = By.id("repeatedPassword");
    private By buttonRegisterForm = By.cssSelector("input[value=\"Register\"]");
    private By messageAccountSuccessfly = By.xpath("//p[text()='Your account was created successfully. You are now logged in.']");
    private By messageErrorUserExist = By.xpath("//span[text()='This username already exists.']");
    private By inputLoginUserName = By.name("username");
    private By inputLogisPassword = By.name("password");
    private By buttonLoginIn = By.cssSelector("input[value='Log In']");
    private By welcome = By.xpath("//b[text()=\"Welcome\"]");
    private int contador =4;
    private String userName= "Alejitoteamo"+contador;
    private String userPassword = "@Lejito2022";
    private By home = By.cssSelector("li[class='home']");

    
    public RegisterPage (WebDriver driver, WebDriverWait wait, Actions actions){
        super(driver,wait, actions);
        
    }

    public boolean titleRegisterPagePresensent() throws InterruptedException{

        return this.elementDispaleyed(titleRegisterPage);
        
    }

    public boolean formRegisterUserDisplayed() throws InterruptedException{
        return this.elementDispaleyed(formRegisterUser);
    }

    public boolean isCurrentUrlRegisterPage(){
        return this.currentUrl().equals(urlRegisterPage);
    }

    public void newAccountRegistrationForm() {

        try {

            this.sendText(inputFirstName, "Diego Hernando");
            this.sendText(inputLastaName, "Cordoba Pineros");
            this.sendText(inputAdress, "Carrera 106 # 44 67");
            this.sendText(inputCity, "Cali");
            this.sendText(inputState, "Colombia");
            this.sendText(inputZipCode, "760048");
            this.sendText(inputPhone, "3045693492");
            this.sendText(inputSSN, "8556987");
            this.sendText(inputUserName, userName);
            this.sendText(inputPassword, userPassword);
            this.sendText(inputConfirmPassword, userPassword);
    

        } catch (Exception e) {
            System.out.println("\"Error registro de formulario: "+e );
            
        }
              
    }

    public void clickButtonRegister() throws InterruptedException{
        this.clickElement(buttonRegisterForm);
    }

    public boolean registerAccount() {
        try {
            if (this.elementDispaleyed(messageAccountSuccessfly)) {
                contador++;
                
            }

            return this.elementDispaleyed(messageAccountSuccessfly);
                           
                   
        } catch (Exception e) {
            System.out.println("La cuenta no fue creada");
            return false;    
        }
            
    }

    public boolean accountExist() throws InterruptedException{

        return this.elementDispaleyed(messageErrorUserExist);
    }

    public void inputUserNameandPassword() throws InterruptedException{
        //this.clickElement(home);
        this.sendText(inputLoginUserName, userName);
        this.sendText(inputLogisPassword, userPassword);
    }

    public void clickLogIn() throws InterruptedException{
        this.clickElement(buttonLoginIn);
    }

    public boolean welcomeMessage() throws InterruptedException{
        if (!this.elementDispaleyed(welcome)) {
            System.out.println("Elemento no esta visible tomando captura........");
            this.takeScreenshot("errorAccesoCuentaCreada");

        } else {
            System.out.println("Elemento visible no se toma captura de pantalla");
            
        }
        return this.elementDispaleyed(welcome);
    }

    public Map<String, Object>  validateMandatoryFieldsWithErrors() throws InterruptedException{

        Map<String, Object> result = new HashMap<>();
        boolean isValid = true;
        List<String> invalidFiels = new ArrayList<>();

        String[][] fieldsAndErrors = {
            {"customer.firstName", "customer.firstName.errors"},
            {"customer.lastName", "customer.lastName.errors"},
            {"customer.address.street", "customer.address.street.errors"},
            {"customer.address.city", "customer.address.city.errors"},
            {"customer.address.state", "customer.address.state.errors"},
            {"customer.address.zipCode", "customer.address.zipCode.errors"},
            {"customer.phoneNumber", "customer.phoneNumber.errors"},
            {"customer.ssn", "customer.ssn.errors"},
            {"customer.username", "customer.username.errors"},
            {"customer.password", "customer.password.errors"},
            {"repeatedPassword", "repeatedPassword.errors"}
        };

        this.clickButtonRegister();
        

        for (String[] fielandError : fieldsAndErrors) {

            
            String fielIdInput= fielandError[0];
            String fielIdError = fielandError[1];

            try {
                WebElement field = findElement(By.id(fielIdInput));
                WebElement error = findElement(By.id(fielIdError));
                
    
                if(field.getAttribute("value").isEmpty()&& !error.isDisplayed()){
                    isValid = false;
                    invalidFiels.add(fielIdInput);
                }
                
            } catch (Exception e) {

                System.out.println("Elemento no visible, error: "+e.getMessage());
            }
          
                
        }

        result.put("isValid", isValid);
        result.put("invalidFields", invalidFiels);
        
        return result;   
            
    }


    

    
}
