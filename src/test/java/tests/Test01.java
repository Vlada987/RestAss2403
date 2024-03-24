package tests;

import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoints.Methods;
import io.restassured.response.Response;
import utility.Pojo;

public class Test01 {
	
Pojo load=new Pojo();	

@BeforeClass	
public void createLoad() {
Faker f=new Faker();
Random r=new Random();
load.setId(String.valueOf(r.nextInt(505)));
load.setUsername(f.name().username());
load.setFirstName(f.name().firstName());
load.setLastName(f.name().lastName());
load.setEmail(f.internet().emailAddress());
load.setPassword(f.internet().password(9, 15));
load.setPhone(String.valueOf(f.phoneNumber()));
		
}
	
@Test(priority=1)
public void test1CreateUser() {

	
Response r=Methods.createUser(load);
r.then().log().all();		
}

@Test(priority=2)
public void test2GetUser() {
	
Response r=Methods.getUser(load.getUsername());
r.then().log().all();
	
}
	

}
