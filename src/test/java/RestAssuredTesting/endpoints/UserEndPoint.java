package RestAssuredTesting.endpoints;

import java.util.Random;

import RestAssuredProject.RestClient;
import io.restassured.response.Response;

public class UserEndPoint {
	
 RestClient client;
	public UserEndPoint() { 
		 client= new RestClient("https://jsonplaceholder.typicode.com/");}
	 
	public Response getSingleUser(int userId) {
			
			client.httpGet("users/"+userId);
			return client.getResponse();
		}
	
	public int generateRandomUserId(int min, int max) {
		Random random = new Random();
        int randomValue = random.nextInt(max + min) + min;
		return randomValue;
	}

}
