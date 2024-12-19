@CrearUsuario
Feature: Creacion de nuevo  usuario en el banco
    Como usuario del banco
    Quiero crear una cuenta nueva
    Para poder gestionar mis finanzas

//Scenario: Crear una nueva cuenta para el usuario del banco
    Given El usuario se encuentra en la pagina principal del banco
    When  El usuario hace clic en el boton register en la pagina principal
    Then El usuario debe ser redirigido a la pantalla de creación de cuenta
    And El formulario de creacion de cuenta debe estar visible
    And El titulo de la pantalla debe ser "Signing up is easy!"
    And El usuario completa la informacion de todos los campos obligatorios
    And El usuario hace click en el boton registrar
    And El usuario visualiza en pantalla el mensaje "You are now logged in"

//Scenario: Ingresar con un usuario con una cuenta creada
    Given El usuario se encuentra en la pagina principal del banco
    And  El usuario hace clic en el boton register en la pagina principal
    And El usuario debe ser redirigido a la pantalla de creación de cuenta
    And El formulario de creacion de cuenta debe estar visible
    And El titulo de la pantalla debe ser "Signing up is easy!"
    And El usuario completa la informacion de todos los campos obligatorios
    When El usuario hace click en el boton registrar
    Then El usuario visualiza en pantalla el mensaje nuevo "This username already exists."
    And El usuario ingresa username y password
    And El usuario hace click en el boton Login
    And El usuario visualiza en pantalla el mensaje Welcome

//Scenario: El usuario no ingresa información a los campo e intenta crear una nueva cuenta
    Given El usuario se encuentra en la pagina principal del banco
    And  El usuario hace clic en el boton register en la pagina principal
    And El usuario debe ser redirigido a la pantalla de creación de cuenta
    And El formulario de creacion de cuenta debe estar visible
    When El usuario hace click en el boton registrar
    Then En usuario visualiza en pantalla cuales son los campos obligatorios







    





