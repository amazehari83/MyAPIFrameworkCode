package com.testyan.fourWaysToPostRequesttest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;
/**
 * 
 * @author HARI HARAN
 *
 */
public class CreateProjectUsingJSONObjTest
{
	/**
	 * This is the REST ASSURED Code for posting the request in Server using JSON Objects
	 */
	@Test
	public void create()
	{
		Random random = new Random();
		int randomnum = random.nextInt(1000);
		System.out.println(randomnum);


		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Online batch");
		jobj.put("projectName", "HARI"+randomnum+"");
		jobj.put("status", "on-going");
		jobj.put("teamSize", 145);
			 given()
			  .contentType(ContentType.JSON)
			   .body(jobj)
			    .when()
			     .post("http://localhost:8084/addProject")
			      .then()
			       .log().all()
			        .assertThat().contentType("application/json");


	}
}
