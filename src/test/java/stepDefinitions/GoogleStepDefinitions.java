package stepDefinitions;

import org.junit.Assert;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

import pages.SearchPage;

public class GoogleStepDefinitions extends TestBase{
	
	HomePage HomePage;
	SearchPage SearchPage;
	


    @When("^user searches by a certain (.+)$")
    public void user_searches_by_a_certain(String query)  {
    	HomePage = new HomePage(driver);
        HomePage.search(query);
        
    }


    @And("^check that title has the keyword$")
    public void check_that_title_has_the_keyword()  {
        Assert.assertEquals(SearchPage.navigateBetweenTabs(),true);
    }
    
    @Then("^open each link with the keyword$")
    public void open_each_link_with_the_keyword()  {
    	  
        SearchPage.openlinks();
    }

    @And("^validate the number of links with (.+) is greater than 1$")
    public void validate_the_number_of_links_with_is_greater_than_1(String keyword)  {
    	
    	SearchPage=new SearchPage(driver); 
    	Assert.assertEquals(SearchPage.isLinksgreaterThanOne(keyword), true);
        
    }

}
