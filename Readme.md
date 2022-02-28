# Valeo Automation Testing Task

The project has both Google( Selenium, Cucumber) and RestAssured implementaion

## Installation
```maven
mvn clean install
```
## Run
### Google project
```java
Go to src/test/java/cucumberOptions/GoogleTestRunner.java Run as TestNg.
```
### RestAssured project
```java
Go to src/test/java/cucumberOptions/RestAssuredTestRunner.java Run as TestNg.
```



## Project Description:

### Google:
 implementation for google search functionality using certian query and after displaying all results, all the links with the given keyword "Gumtree" is displayed


### RestAssured:
using this api: https://jsonplaceholder.typicode.com/
1) Get a random user (userID), print out its email address to console.
2) Using this userID, get this user’s associated posts and verify they
contain valid Post IDs (an Integer between 1 and 100).
3)Do a post using same userID with a non-empty title and body, verify the correct response is returned

## Author
 Nada Ali