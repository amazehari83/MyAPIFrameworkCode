package com.testyan.fourWaysToPostRequesttest;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * 
 * @author HARI HARAN
 *
 */
public class CreateProjUsingJsonFileTest
{
	/**
	 * This is the REST ASSURED Code for posting in server by using .json file
	 */
	@Test
	public void jsonFileCreation()
	{
		File file = new File("./emp.json");
			 given()
			  .contentType(ContentType.JSON)
			   .body(file)
			    .when()
			     .post("http://localhost:8084/addProject")
			      .then()
			       .log().all().and()
			        .assertThat().contentType("application/json"); 




	}
}

