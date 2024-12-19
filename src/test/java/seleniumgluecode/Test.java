package seleniumgluecode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Test extends Testbase {

    
    @Given("El usuario se encuentra en la pagina principal del banco")
    
    public void el_usuario_se_encuentra_en_la_pagina_principal_del_banco() throws InterruptedException {
        Assert.assertTrue("La página principal del banco no se cargó correctamente.",homePage.titleHomePageDisplayed()  );
    }
    
    @When("El usuario hace clic en el boton register en la pagina principal")
    
    public void el_usuario_jace_clic_en_el_boton_en_la_pagina_principal() throws InterruptedException {
        
        homePage.clickButtonRegister();
        
    }

    @Then("El usuario debe ser redirigido a la pantalla de creación de cuenta")
    
    public void el_usuario_debe_ser_redirigido_a_la_pantalla_de_creación_de_cuenta() throws InterruptedException {
        
        //Assert.assertTrue(registerPage.isCurrentUrlRegisterPage());        
    }

    @Then("El formulario de creacion de cuenta debe estar visible")
    
    public void el_formulario_de_creacion_de_cuenta_debe_estar_visible() throws InterruptedException {
        Assert.assertTrue("El formulario de creación de cuenta no está visible.",registerPage.formRegisterUserDisplayed());        
    }

    @Then("El titulo de la pantalla debe ser {string}")
    
    public void el_titulo_de_la_pantalla_debe_ser(String string) throws InterruptedException {
        Assert.assertTrue("El título de la pantalla no es el esperado.",registerPage.titleRegisterPagePresensent());        
    }

    @Then("El usuario completa la informacion de todos los campos obligatorios")
    
    public void El_usuario_completa_la_informacion_de_todos_los_campos_obligatorios() {

    registerPage.newAccountRegistrationForm();
    }

    @Then("El usuario hace click en el boton registrar")
    
    public void el_usuario_hace_click_en_el_boton_registrar() throws InterruptedException {
    registerPage.clickButtonRegister();
    
    }
    
    @Then("El usuario visualiza en pantalla el mensaje {string}")
    
    public void el_usuario_visualiza_en_pantalla_el_mensaje(String string) {
    
        Assert.assertTrue(registerPage.registerAccount());
        
    }

    @Then("El usuario visualiza en pantalla el mensaje nuevo {string}")
    
    public void El_usuario_visualiza_en_pantalla_el_mensaje_nuevo(String s) throws InterruptedException {
        Assert.assertTrue(registerPage.accountExist());
    }

    @Then("El usuario hace click en el boton {string}")
    
    public void El_usuario_hace_click_en_el_boton(String s) throws InterruptedException {
        registerPage.clickButtonRegister();
    }

    @Then("El usuario ingresa username y password")
    
    public void El_usuario_ingresa_username_y_password() throws InterruptedException {
        registerPage.inputUserNameandPassword();
    }

    @Then("El usuario visualiza en pantalla el mensaje Welcome")
    
    public void El_usuario_visualiza_en_pantalla_el_mensaje_Welcome() throws InterruptedException {
        Assert.assertTrue(registerPage.welcomeMessage());
    }

    @Then("El usuario hace click en el boton Login")
    
    public void El_usuario_hace_click_en_el_boton_Login() throws InterruptedException {
        registerPage.clickLogIn();
    }

    @Then("En usuario visualiza en pantalla cuales son los campos obligatorios")
    
    public void En_usuario_visualiza_en_pantalla_cuales_son_los_campos_obligatorios() throws InterruptedException {

        boolean result = (boolean)registerPage.validateMandatoryFieldsWithErrors().get("isValid");
        List<String> errorsNoPresent = new ArrayList<>((List<String>) registerPage.validateMandatoryFieldsWithErrors().get("invalidFields"));
        
        for (String string : errorsNoPresent) {
            System.out.println(string);
        }
        System.out.println(registerPage.validateMandatoryFieldsWithErrors().get("isValid"));
        Assert.assertTrue(result);
        
    
    }

    @When("El usuario hace click en el boton Open New Account")
    public void El_usuario_hace_click_en_el_boton_Open_New_Account() throws InterruptedException {
    this.openNewAccount.clickButtonNewAccount();
    }

    @When("El usuario visualiza en la funcionalidad el mensaje Open New Account")
    public void El_usuario_visualiza_en_la_funcionalidad_el_mensaje_Open_New_Account() throws InterruptedException {
        Assert.assertTrue(openNewAccount.validationMessageOpenNewAccount());
    }


    @When("El usuario selecciona el tipo de cuenta SAVINGS")
    public void El_usuario_selecciona_el_tipo_de_cuenta_SAVINGS() throws InterruptedException {
        openNewAccount.selectAccountSaving();
    
    }

    @Then("El usuario visualiza en la funcionalidad el mensaje Account Opened")
    public void El_usuario_visualiza_en_la_funcionalidad_el_mensaje_Account_Opened() throws InterruptedException {
        Assert.assertTrue(this.openNewAccount.validationNumerNewAccount());
        
    }


    @Then("El usuario visualiza en la funcionalidad el numero de cuenta")
    public void El_usuario_visualiza_en_la_funcionalidad_el_numero_de_cuenta() throws InterruptedException {
        Assert.assertTrue(this.openNewAccount.validationNumerNewAccount());
    }

    @When("El usuario hace click en el boton que guarda la nueva cuenta Open New Account")
    public void El_usuario_hace_click_en_el_boton_que_guarda_la_nueva_cuenta_Open_New_Account() throws InterruptedException { 

        openNewAccount.clickSaveAccount();
    }

    @Given("el usuario hace click en el enlace Accounts Overwiew")
    public void el_usuario_hace_click_en_el_enlace_Accounts_Overwiew() throws InterruptedException {
    accountsOverviewPage.clickButtonAccountsOverview();
    }



    @Given("el usuario visualiza en pantalla el mensaje Balance includes deposits that may be subject to holds")
    public void el_usuario_visualiza_en_pantalla_el_mensaje_Balance_includes_deposits_that_may_be_subject_to_holds() throws InterruptedException {
        Assert.assertTrue(accountsOverviewPage.validationMessageAccountsOverview());
    }

    @When("el usuario hace click en el enlace Transfer Founds")
    public void el_usuario_hace_click_en_el_enlace_Transfer_Founds() throws InterruptedException {
        accountsOverviewPage.clickButtonTransferFounds();
    }

    @When("el usuario visualiza el mensaje Transfer Founds")
    public void el_usuario_visualiza_el_mensaje_Transfer_Founds() throws InterruptedException {
        Assert.assertTrue(accountsOverviewPage.validationMessageTransferFounds());
    }

    @When("el usuario ingresa la cantidad que desea transferir")
    public void el_usuario_ingresa_la_cantidad_que_desea_transferir() throws InterruptedException {
        accountsOverviewPage.enterAmountSend();    
    }

    @When("el usuario seleccoina la cuenta origen")
    public void el_usuario_seleccoina_la_cuenta_origen() throws InterruptedException {
        accountsOverviewPage.selectFromAccountList();
    }

    @When("el usuario selecciona la cuenta destino")
    public void el_usuario_selecciona_la_cuenta_destino() throws InterruptedException {
        accountsOverviewPage.selectToAccount();
    }

    @When("el usuario hace click en el boton Transfer")
    public void el_usuario_hace_click_en_el_boton_Transfer() throws InterruptedException {
        accountsOverviewPage.clickButtonTransfer();
    }

    @Then("el usuario visualiza en pantalla el mensaje Transfer Complete")
    public void el_usuario_visualiza_en_pantalla_el_mensaje_Transfer_Complete() throws InterruptedException {
        Assert.assertTrue(accountsOverviewPage.validationMessageTransfercomplete());
    }








    












    
   
    
}
