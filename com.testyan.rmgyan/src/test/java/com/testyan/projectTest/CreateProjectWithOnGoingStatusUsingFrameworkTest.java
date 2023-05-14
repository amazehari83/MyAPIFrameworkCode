package com.testyan.projectTest;

import org.testng.Assert;
import org.testng.annotations.Test;

//import com.mysql.jdbc.Driver;

import com.mysql.cj.jdbc.Driver;
import com.projectpojolib.ProjectLib;
import com.testyan.rmgyan.GenericUtils.BaseAPIClass;
import com.testyan.rmgyan.GenericUtils.DataBaseUtilities;
import com.testyan.rmgyan.GenericUtils.EndPoints;
import com.testyan.rmgyan.GenericUtils.JavaUtility;
import com.testyan.rmgyan.GenericUtils.JsonUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class CreateProjectWithOnGoingStatusUsingFrameworkTest extends BaseAPIClass
{

	@Test
	public void createProject() throws Throwable
	{
		JavaUtility javautils = new JavaUtility();
		JsonUtility jsonutils = new JsonUtility();
		DataBaseUtilities dbutility = new DataBaseUtilities();

		String expectedProjectName = "TeamIndia"+javautils.randomNumber();
		String expectedStatus = "on-going";
		ProjectLib projectLib = new ProjectLib("Sachin",expectedProjectName,expectedStatus,15);

		//Give Precondition and capture the response after doing post operation
		Response response = given()
				.contentType(ContentType.JSON)
				.body(projectLib)
				.when()
				.post(EndPoints.addProject_EP);

		//Capture projectName and statuscode from the response
		String responseProjectName = jsonutils.getJsonPathData("projectName", response);
		String responseStatus = jsonutils.getJsonPathData("status", response);

		//Provide the restassured verification
		response.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.log().all();

		String querry = "select * from project";
		String actualProjectName = dbutility.executeQueryAndGetData(querry, 4, expectedProjectName);
		String actualStatus = dbutility.executeQueryAndGetData(querry, 5, expectedStatus);

		//assertion for both db and response body projectname
		Assert.assertEquals(actualProjectName, expectedProjectName);
		Assert.assertEquals(responseProjectName, expectedProjectName);

		//assertion for both db and response body status
		Assert.assertEquals(actualStatus, expectedStatus);
		Assert.assertEquals(responseStatus, expectedStatus);

	}


}


