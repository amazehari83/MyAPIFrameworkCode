package com.parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParameterUSingGitTest
{
@Test
public void paramgit()
{
	given()
	  .contentType(ContentType.JSON)
	  .pathParam("username", "test123") 
	  .queryParam("sort", "created")
	.when()
	  .get("https://api.github.com/users/{username}/repos")
	.then()
	   .log().all();
	  
}
}