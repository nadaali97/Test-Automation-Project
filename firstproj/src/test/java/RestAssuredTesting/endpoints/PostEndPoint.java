package RestAssuredTesting.endpoints;

import static io.restassured.RestAssured.given;

import org.apache.commons.codec.binary.Base32InputStream;

import com.google.gson.JsonObject;

import RestAssuredProject.RestClient;
import RestAssuredTesting.payload.Post;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import kong.unirest.Client;
import kong.unirest.json.JSONObject;

public class PostEndPoint {
RestClient client;
	public PostEndPoint() { 
		 client= new RestClient("https://jsonplaceholder.typicode.com/");}
	
	public Response getAllPosts(int userId) {
		
		client.httpGet("posts","userId",String.valueOf(userId));
		return client.getResponse();
	}

   public int createAPost(JSONObject postBody) {
	   client.httpPost("posts", postBody);
	  return Integer.valueOf(client.getResponseJsonValue("id")) ;
	   
   }
   public Response getSinglePost(int postId) {
		
		client.httpGet("posts/"+postId);
		return client.getResponse();
	}
   public boolean checkValue(Post[] allPostResponse) {
    for(Post p:allPostResponse) {
   	
    	if(p.getId()<1 || p.getId()>100) {
   		
    		return false ;
    	}
   
   }
	return true;
   }
}