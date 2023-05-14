package com.testyan.fourWaysToPostRequesttest;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import com.projectpojolib.ProjectLib;

import io.restassured.http.ContentType;
/**
 * 
 * @author HARI HARAN
 *
 */
public class CreateUsingpojoTest 
{
	/**
	 * Code for Creating new project in server with POST Method using POJO Class
	 */
	@Test
	public void createpojo()
	{
		Random random = new Random();
		int randomnum = random.nextInt(3000);
		System.out.println(randomnum);

		ProjectLib pojoObject = new ProjectLib("testyantra","onlinetestyantra"+randomnum+"","Completed",546);
			 given()
			  .contentType(ContentType.JSON)
			   .body(pojoObject)
			    .when()
			     .post("http://localhost:8084/addProject")
			      .then()
			       .log().all()
			        .and()
			         .assertThat().statusCode(201)
			          .and()
			           .assertThat()
			           	 .contentType("application/json");

	}

}

