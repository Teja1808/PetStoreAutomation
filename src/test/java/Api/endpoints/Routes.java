package Api.endpoints;

/*swagger URI -->  https://petstore.swagger.io/#/
 * 
 * create a new pet - https://petstore.swagger.io/v2/user
 * get the details of pet -https://petstore.swagger.io/v2/user/{username}
 * update the details of pet -https://petstore.swagger.io/v2/user/{username}
 * delete the details of pet -https://petstore.swagger.io/v2/user/{username}
 
 * */
public class Routes {

	//create a baseurl
	public static String base_Url="https://petstore.swagger.io/v2/";
	
	//user module
	
	//static is used because if declare any variable with it ...we can use that in any other class without creating the object we can directly call by using classname
	public static String post_url=base_Url+"user";
	public static String get_url=base_Url+"user/{username}";
	public static String put_url=base_Url+"user/{username}";
	public static String delete_url=base_Url+"user/{username}";
	
	//pet module
	
	//store module
}
