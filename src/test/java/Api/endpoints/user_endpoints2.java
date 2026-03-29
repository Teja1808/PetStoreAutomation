package Api.endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import org.testng.Assert;

import Api.payload.User;
public class user_endpoints2 {

	 static ResourceBundle getURL(){
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
		
		//create user code
		public static Response createuser(User payload){
			
			String post_url = getURL().getString("post_url");
			
			Response response =given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(payload)
			
			.when()
			.post(post_url);
			
			
			
			return response;
		}
		
		public static Response readUser(String Username){
			String get_url = getURL().getString("get_url");
			Response response =given()
			.pathParam("username",Username)
			
			.when()
			.get(get_url);

			
			return response;
			
		}
		
	public static Response Updateuser(User payload,String Username){
			
		String update_url = getURL().getString("update_url");
			Response response =given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(payload)
			.pathParam("username", Username)
			.when()
			.put(update_url);
			
			
			
			return response;
		}
		
	public static Response deleteuser(String Username){
		String delete_url = getURL().getString("delete_url");
		Response response =given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", Username)
		
		.when()
		.delete(delete_url);
		
		return response;
	}
		
		
		
		
	}

