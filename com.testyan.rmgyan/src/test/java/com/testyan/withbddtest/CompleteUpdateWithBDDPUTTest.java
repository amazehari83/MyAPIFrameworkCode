package com.testyan.withbddtest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
/**
 * 
 * @author HARI HARAN
 *
 */
public class CompleteUpdateWithBDDPUTTest 
{
	/**
	 Code for Complete Updation of Project using PUT Method with BDD
	 */
	@Test
	public void completeUpdate()
	{

		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Online batch");
		jobj.put("projectName", "HARAAAA");
		jobj.put("status", "on-going");
		jobj.put("teamSize", 145);

			 given()
			  .contentType(ContentType.JSON)
			   .body(jobj)
			    .when()
			     .put("http://localhost:8084/projects/TY_PROJ_1403")
			      .then().log().all();
	}


}

