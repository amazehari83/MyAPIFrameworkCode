package com.testyan.fourWaysToPostRequesttest;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * 
 * @author HARI HARAN
 *
 */
public class CreateProjUsingHashMapTest 
{
	/**
	 * This is the REST ASSURED Code for posting in server using Hashmap
	 */
	@Test
	public void createUsingmap()
	{
		Random random = new Random();
		int randomnum = random.nextInt(1000);
		System.out.println(randomnum);
		
		//creating hashmap obj
		HashMap map = new HashMap();

		map.put("createdBy", "Online batch");
		map.put("projectName", "HA"+randomnum+"");
		map.put("status", "on-going");
		map.put("teamSize", 115);
			 given()
			  .contentType(ContentType.JSON)
			   .body(map)
			    .when()
			     .post("http://localhost:8084/addProject")
			      .then()
			       .log().all()
			        .assertThat().contentType("application/json");

	}
}

