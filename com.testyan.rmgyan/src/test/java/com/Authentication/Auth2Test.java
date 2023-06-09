package com.Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class Auth2Test 
{
@Test
public void auth2()
{
	Response response1 = given()
	  .formParam("client_ID", "Applicatin-2")
	  .formParam("client_secret", "53eea1714dd04eab8041fb67aa9884d1")
	  .formParam("grant_type", "client_credentials")
	  .formParam("redirect_uri", "https://example.com")
	  
	  
	  .when()
	    .post("http://coop.apps.symfonycasts.com/token");
	  //.then().log().all();
	System.out.println(response1.prettyPrint());
	  
	 String token = response1.jsonPath().get("access_token");
	 
	 given()
	   .auth().oauth2(token)
	   .pathParam("USER_ID", "1951")
	   .when()
	     .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
	     .then().log().all();
	     
	   
}
}


// http://coop.apps.symfonycasts.com/api

