Feature: Login Functionality of the Website

  Scenario: Login with valid credentials
    Given User lanuch chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com"
    And User enters password as "admin"
    And User click login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When user click on logout button
    Then Page title should be "Your store. Login"
    And Close the browser

  Scenario Outline: Login Data Drivern
    Given User lanuch chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "<email>"
    And User enters password as "<password>"
    And User click login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When user click on logout button
    Then Page title should be "Your store. Login"
    And Close the browser

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com | adm      |
