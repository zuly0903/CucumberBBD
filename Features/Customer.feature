Feature: Customers

Background: Below are the initial steps for each scenario
		Given User lanuch chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com"
    And User enters password as "admin"
    And User click login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on customers menu
    And User click on sub customers menu

@regression    
Scenario: Add new customer functionality
		And User click on Add new button
		Then Page title should be "Add a new customer / nopCommerce administration"
		When User enter customer info
		And User click on save button
		Then User can view confirmation message "The new customer has been added successfully."
		And Close the browser

@sanity		
Scenario: Search customer by EmailID
		And User enter customer email
		When User click on search button
		Then User should found email in the search table
		And Close the browser


Scenario: Search customer by name
		And User enter customer First Name
		And User enter customer Last Name
		When User click on search button
		Then User should found name in the search table
		And Close the browser
		