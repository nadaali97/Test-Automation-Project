package RestAssuredTesting;

import java.util.Random;

import org.testng.Assert;

import RestAssuredTesting.endpoints.PostEndPoint;
import RestAssuredTesting.endpoints.UserEndPoint;
import RestAssuredTesting.payload.Post;
import RestAssuredTesting.payload.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import kong.unirest.json.JSONObject;

public class RestAssuredStepDefinitions {

	
	PostEndPoint postEndPoint=new PostEndPoint();
	UserEndPoint userEndPoint=new UserEndPoint();
	User retrieveUser;
	JSONObject postBody= new JSONObject();
	int postId;
	int randomUserId=userEndPoint.generateRandomUserId(1,10);
	Post[] allPostResponse;
	
	@When("^user search with a random userid$")
    public void user_search_with_a_random_userid() {
       retrieveUser=userEndPoint.getSingleUser(randomUserId).as(User.class);
    
     }

    @When("^user get a post with the same random userid$")
    public void user_get_a_post_with_the_same_random_userid() {
     allPostResponse=  postEndPoint.getAllPosts(randomUserId).as(Post[].class);
      
      }
    
    @When("^user make a post with a body$")
    public void user_make_a_post_with_a_body()  {
    	
    	postBody.put("title","adipisci placeat illum aut reiciendis qui");
    	postBody.put("body","illum quis cupiditate provident sit magnam\nea sed aut omnis\nveniam maiores ullam consequatur atque\nadipisci quo iste expedita sit quos voluptas");
    	postBody.put("userId",2);
    	
    	postId= postEndPoint.createAPost(postBody);
    	
    	}

    @Then("^user email is printed in console$")
    public void user_email_is_printed_in_console() {
    	System.out.println("User email "+retrieveUser.getEmail()+" for Id:"+randomUserId);
    }

    @Then("^make sure that all id is between 1 and 100$")
    public void make_sure_that_all_id_is_between_1_and_100() {
      
      Assert.assertEquals( postEndPoint.checkValue(allPostResponse),true);
    }

    @Then("^response body should be the same as post body$")
    public void response_body_should_be_the_same_as_post_body()  {
    	
    	//I used the postId statically because POST "posts" is blocked in this API
    	Assert.assertEquals(postEndPoint.getSinglePost(19).as(Post.class).compare(postBody), true);
    }
	
	
}
