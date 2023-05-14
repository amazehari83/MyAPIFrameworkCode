package com.testyan.withoutbddtest;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
/**
 * 
 * @author HARI HARAN
 *
 */
public class GetAllProjectWithoutBDDTest 
{
	/**
	 Code for Getting all the Projects from Server using GET Method without BDD 
	 */
	@Test
	public void GetallProject()
	{
		Response response = RestAssured.get("http://localhost:8084/projects");
		//System.out.println(response.asString());
		//response.prettyPrint();
		System.out.println(response.getContentType());
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		
		/*
		int actualstatuscode = response.getStatusCode();
		Assert.assertEquals(actualstatuscode, 204);
	    */
		ValidatableResponse vresponse = response.then();
		
		vresponse.assertThat().statusCode(200);
		vresponse.assertThat().contentType("application/json");
		vresponse.log().all();
	}

}

