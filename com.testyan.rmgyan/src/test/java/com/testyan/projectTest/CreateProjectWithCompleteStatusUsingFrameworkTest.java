package com.testyan.projectTest;

import org.testng.Assert;
import org.testng.annotations.Test;

//import com.mysql.jdbc.Driver;

import com.mysql.cj.jdbc.Driver;
import com.projectpojolib.ProjectLib;
import com.testyan.rmgyan.GenericUtils.BaseAPIClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class CreateProjectWithCompleteStatusUsingFrameworkTest 
{
	Random random = new Random();
	int randomno = random.nextInt(3000);
	String expectedProjectName="CSK"+randomno;
	String expectedStatus = "Completed";
	@Test
	public void createProjectWithCompletedStatus() throws Throwable
	{
		
		//Create a resource inside the server using pojo class
		//String expectedProjectName="CSK"+randomno;
		//String expectedStatus = "Completed";
		ProjectLib projectLib = new ProjectLib("Sachin",expectedProjectName,expectedStatus,15);

		//Give Precondition and capture the response after doing post operation
		Response response = given()
				.contentType(ContentType.JSON)
				.body(projectLib)
				.when()
				.post("http://localhost:8084/addProject");

		//Capture projectName and statuscode from the response
		String responseprojectName = response.jsonPath().get("projectName");
		String responseStatus = response.jsonPath().get("status");

		//Provide the restassured verification
		response.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.log().all();


		//step 1: register the mysql database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		//step 2: connect to the database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");

		//step 3: issue the database querry
		Statement statement = connection.createStatement();

		//step 4: execute the querry and get the values from the database

		String actualprojectName=null;
		String actualStatus = null;
		boolean flag = false;
		ResultSet result = statement.executeQuery("select * from project");

		while(result.next()) 
		{
			if(result.getString(4).equals(expectedProjectName))
			{
				actualprojectName = result.getString(4);
				actualStatus = result.getString(5);
				flag = true;
				break;
			}

		} 
		//closing the Database Connection
		connection.close(); 

		//testng assertion
		//assertion using flag between expected and actual from data base
		Assert.assertEquals(flag, true);
		
		//verification between expected and actual from database
		Assert.assertEquals(actualprojectName, expectedProjectName);
		
		// Assert.assertEquals(expectedProjectName, actualprojectName);  

		//verification between expected and actual from response
		Assert.assertEquals(responseprojectName, expectedProjectName);

		//assertion for status
		Assert.assertEquals(expectedStatus, actualStatus);
		Assert.assertEquals(responseStatus, expectedStatus);
	}


}


