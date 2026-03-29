package Api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Api.endpoints.user_endpoints;
import Api.payload.User;
import Api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTESTS {
	@Test(priority=1,dataProvider="Data",dataProviderClass = DataProviders.class)
	public void testPostUser(String UserID,String UserName,String FirstName,String LastName,String Email,String Password,String Phone) {
		
		User userpayload = new User();
		
		userpayload.setId(Integer.parseInt(UserID));
		userpayload.setUsername(UserName);
		userpayload.setFirstname(FirstName);
		userpayload.setLastname(LastName);
		userpayload.setEmail(Email);
		userpayload.setPassword(Password);
		userpayload.setPhone(Phone);
		
		Response response = user_endpoints.createUser(userpayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		
	}
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	
	public void testdeletebyuser(String UserName) {
		Response response = user_endpoints.deleteUser(UserName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
