package RestAssuredProject;
import java.util.Map;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import kong.unirest.json.JSONObject;

public class RestClient {

    RequestSpecification httpRequest;
    Response response;

    public RestClient(String baseURI) {
	RestAssured.baseURI = baseURI;
	httpRequest = RestAssured.given();
    }

   

    public void httpGet(String resource) {
	response = httpRequest.request(Method.GET, resource);
    }

   
    public void httpGet(String resource, String key, String value) {
    	response = httpRequest.queryParam(key,value).request(Method.GET, resource);
        }

    public void httpPost(String resource) {
	response = httpRequest.request(Method.POST, resource);
    }
    public void httpPost(String resource, JSONObject postBody) {
    	response = httpRequest.body(postBody).request(Method.POST, resource);
        }

    public Response getResponse() {
	response.then().log().all();
	return response;
    }

  

    public String getResponseJsonValue(String key) {

	return response.getBody().jsonPath().getString(key);
    }
}