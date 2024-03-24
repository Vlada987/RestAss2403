package endpoints;
import io.restassured.response.Response;
import utility.Pojo;

import static io.restassured.RestAssured.*;

import api.Routes;

public class Methods {
	
Pojo load=new Pojo();	
	
public static Response createUser(Pojo load) {
	
Response r= given().contentType("application/json")
.body(load).when().post(Routes.postURL);
return r;
	
}

public static Response getUser(String userName) {
	
Response r= given().pathParam("username", userName) 
.get(Routes.getURL);
return r;
}
	

}
