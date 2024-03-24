package tests;

import org.testng.annotations.Test;

import endpoints.Methods;
import io.restassured.response.Response;
import utility.DataProviders;
import utility.Pojo;

public class DDtest {
	
//@Test(dataProvider="allData",dataProviderClass=DataProviders.class)	
public void test2(String id,String un,String fn,String ln,String mail,String pwd,String phone) {

Pojo load=new Pojo();
load.setId(id);
load.setUsername(un);
load.setFirstName(fn);
load.setLastName(ln);
load.setEmail(mail);
load.setPassword(pwd);
load.setPhone(phone);

Response r=Methods.createUser(load);
r.then().log().all();
	
}
//@Test(dataProvider="userNames",dataProviderClass=DataProviders.class)	
public void test3(String userName) {
	
Response r=Methods.getUser(userName);
r.then().log().all();
	
	
}

}
