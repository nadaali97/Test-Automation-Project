#Author: Nada Ali

 Feature: Google search 
 @Selenium
  Scenario Outline: Search with a keyword and assert the page title has this keyword
   When user searches by a certain <query>
   And validate the number of links with <keyword> is greater than 1
   Then open each link with the keyword
   And check that title has the keyword

    Examples: 
      | query          | keyword | 
      | Cars in London | Gumtree | 
      

     
      
