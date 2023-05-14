package com.HamcrestMatchesVerification;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ChainingTest 
{
@Test
public void chain()
{
	Response response = when()
	 .get("http://localhost:8084/projects");
	String Firstpid = response.jsonPath().get("[1].projectId");
	System.out.println(Firstpid);
	
	given()
	.pathParam("proID", Firstpid)
	.when()
	.delete("http://localhost:8084/projects/{proID}")
	.then()
	.log().all()
	.assertThat().statusCode(204);
}
}


/*
 
 */
