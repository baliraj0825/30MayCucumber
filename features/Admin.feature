Feature:Login

Background:
    Given User Launch chrome Browsers
    When  User open URL "https://admin-demo.nopcommerce.com/login"

@Smoke
  Scenario: Succesffuly Login with valid Credential
    
    And  User enter email as "admin@yourstore.com" and password as "admin"
    And  User click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    And close browser
    
    
@Sanity
  Scenario Outline: Login Data Driven
   
    And  User enter email as "<email>" and password as "<password>"
    And  User click on Login 
    Then Page title should be "Dashboard / nopCommerce administration"
    And close browser
    
 Examples:
   |email|password|
   |admin@yourstore.com|admin|
   |admin@yourstore.com|admin123|  
    
    

  
