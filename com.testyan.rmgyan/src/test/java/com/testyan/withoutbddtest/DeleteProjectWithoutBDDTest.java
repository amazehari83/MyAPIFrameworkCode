package com.testyan.withoutbddtest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
/**
 * 
 * @author HARI HARAN
 *
 */
public class DeleteProjectWithoutBDDTest 
{
	/**
	 Code for Deleting Project from Server using DELETE Method without BDD 
	 */
	@Test
	public void deleteProjectt()
	{
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_807");
		ValidatableResponse vresponse = response.then();
		vresponse.assertThat().contentType("application/json");
		vresponse.assertThat().statusCode(204);
		vresponse.log().all();

	}
}

