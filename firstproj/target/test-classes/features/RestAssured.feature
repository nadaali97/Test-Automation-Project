#Author: Nada Ali

 Feature: RestAssured Project 
 
  @Rest
  Scenario: Get a random user (userID), print out its email address to console.
   When user search with a random userid
   Then user email is printed in console
 @Rest
  Scenario: Using this userID, get this user’s associated posts and verify they contain valid Post IDs.
      
   When user get a post with the same random userid
   Then make sure that all id is between 1 and 100
      
  @Rest
   Scenario: Do a post using same userID with a non-empty title and body, verify the correct response is returned
      
   When user make a post with a body
   Then response body should be the same as post body
     
      
