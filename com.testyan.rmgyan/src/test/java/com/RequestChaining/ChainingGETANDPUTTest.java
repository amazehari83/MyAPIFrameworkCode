package com.RequestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ChainingGETANDPUTTest 
{
@Test
public void chain()
{
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "Online batch");
	jobj.put("projectName", "HARAAAA");
	jobj.put("status", "on-going");
	jobj.put("teamSize", 145);
	
	Response response = when()
	 .get("http://localhost:8084/projects");
	String Firstpid = response.jsonPath().get("[1].projectId");
	System.out.println(Firstpid);
	
	given()
	.pathParam("proID", Firstpid)
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
	.put("http://localhost:8084/projects/{proID}")
	.then()
	.log().all()
	.assertThat().statusCode(200);
}
}
/*
 {
  "createdBy": "string",
  "projectName": "string",
  "status": "string",
  "teamSize": 0
}
 */
