@CrearCuenta
Feature: Abrir nueva cuenta bancaria

Scenario: Crear una nueva cuenta de un usuaro que ya realizó registro previo
    Given El usuario ingresa username y password
    And El usuario hace click en el boton Login
    When El usuario hace click en el boton Open New Account
    And El usuario visualiza en la funcionalidad el mensaje Open New Account
    And El usuario selecciona el tipo de cuenta SAVINGS
    And El usuario hace click en el boton que guarda la nueva cuenta Open New Account
    Then El usuario visualiza en la funcionalidad el mensaje Account Opened
    And El usuario visualiza en la funcionalidad el numero de cuenta

Scenario: Transferencia de fondo de cuentas
    Given El usuario ingresa username y password
    And El usuario hace click en el boton Login
    And el usuario hace click en el enlace Accounts Overwiew
    And el usuario visualiza en pantalla el mensaje Balance includes deposits that may be subject to holds
    When el usuario hace click en el enlace Transfer Founds
    And el usuario visualiza el mensaje Transfer Founds
    And el usuario ingresa la cantidad que desea transferir
    And el usuario seleccoina la cuenta origen
    And el usuario selecciona la cuenta destino
    And el usuario hace click en el boton Transfer
    Then el usuario visualiza en pantalla el mensaje Transfer Complete





