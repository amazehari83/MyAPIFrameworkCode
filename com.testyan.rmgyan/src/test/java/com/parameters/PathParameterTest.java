package com.parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParameterTest 
{
@Test
public void parameter()
{
	given()
	  .contentType(ContentType.JSON)
	 .pathParam("projectId", "TY_PROJ_612")
	//ProjectId is the variable which holds "TY_PROJ_90"
	.when()
	  .get("http://localhost:8084/projects/{projectId}")
	.then()
	  .log().all()
	  .assertThat().statusCode(200);
	  
	  
}
}
