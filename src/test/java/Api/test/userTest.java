package Api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Api.endpoints.user_endpoints;
import Api.payload.User;
import io.restassured.response.Response;

public class userTest {
	
	User userpayload;
	Faker faker;
	

	public Logger logger;
	
	@BeforeTest
	void setUpData() {
		
		userpayload = new User();
		faker=new Faker();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setUsername(faker.name().username());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setPassword(faker.internet().password());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
	
		//for creating log files
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void createuser() {
		logger.info("************Creating User******************");
		Response response =user_endpoints.createUser(userpayload);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		logger.info("************After Creating User******************");
		
	}
	
	@Test(priority=2)
	public void readUser()
{
		logger.info("************Reading User******************");
		Response response =user_endpoints.readUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		logger.info("************After reading User******************");
}
	
	
	@Test(priority=3)
	public void updateUser() {
		logger.info("************Updating User******************");
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setPassword(faker.internet().password());
		
		Response response = user_endpoints.UpdateUser(userpayload, this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response responsereaduser =user_endpoints.readUser(this.userpayload.getUsername());
		Assert.assertEquals(responsereaduser.getStatusCode(), 200);
		response.then().log().all();
		logger.info("************after Updating User******************");
	}
	
	@Test(priority=4)
	public void deleteUser()
	{
		logger.info("************deleting User******************");
		Response response =user_endpoints.deleteUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		logger.info("************after deleting User******************");
	}
}
	


	