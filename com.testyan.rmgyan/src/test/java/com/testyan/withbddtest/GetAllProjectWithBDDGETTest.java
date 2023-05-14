package com.testyan.withbddtest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
/**
 * 
 * @author HARI HARAN
 *
 */
public class GetAllProjectWithBDDGETTest
{
	/**
 Code for getting all theProjects from Server with BDD
	 */
	@Test
	public void getProjects()
	{

			 when()
			 .get("http://localhost:8084/projects")
			  .then()
			   .assertThat()
			    .statusCode(200)
			     .and()
			      .assertThat()
			       .contentType("application/json")
			        .and()
			         .log()
			          .all();

	}
}

