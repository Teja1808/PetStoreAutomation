package Api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Api.payload.User;

public class user_endpoints{
	
	//create user code
	public static Response createUser(User payload){
		
		Response response =given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.post_url);
		
		
		
		return response;
	}
	
	public static Response readUser(String Username){
		
		Response response =given()
		.pathParam("username",Username)
		
		.when()
		.get(Routes.get_url);

		
		return response;
		
	}
	
public static Response UpdateUser(User payload,String Username){
		
		Response response =given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		.pathParam("username", Username)
		.when()
		.put(Routes.put_url);
		
		
		
		return response;
	}
	
public static Response deleteUser(String Username){
	
	Response response =given()
	.accept(ContentType.JSON)
	.contentType(ContentType.JSON)
	.pathParam("username", Username)
	
	.when()
	.delete(Routes.delete_url);
	
	return response;
}
	
	
	
	
}
