package com.parameters;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameterTest 
{
@Test
public void FormParam()
{
	given()
	 .contentType(ContentType.JSON)
	 .formParam("createdBy","lak")
	 .formParam("projectName", "Shopping")
	 .formParam("status","Completed")
	 .formParam("teamSize",172)
	.when()
	 .post("http://localhost:8084/addProject")
	.then()
	 .log().all();
}
}
