Feature: Customer


  Scenario: Add New Customer
    Given User Launch chrome Browsers
    When  User open URL "https://admin-demo.nopcommerce.com/login"
    And  User enter email as "admin@yourstore.com" and password as "admin"
    And  User click on Login
    Then User can view Dashboard
    When Click on customers menu
    And Click on customers menu item
    And Click on add new button
    Then User can view add new customer page
    When User enter customer info
    And click on save button
    Then user can view confirmation msg "The new customer has been added successfully."
    And close browser
