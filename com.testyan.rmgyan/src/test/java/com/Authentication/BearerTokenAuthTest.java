package com.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenAuthTest
{
@Test
public void bearerToken()
{
	given()
	 .auth().oauth2("jgktjridfj")
	.when()
	  .get("https://api.github.com/user/repos")
	 .then()
	   .log().all();
}
}


//https://docs.github.com/rest
