package com.testyan.projectTest;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.projectpojolib.ProjectLib;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class CreateProjectWithOnGoingStatusTest 
{
@Test
public void createProjectWithOnGoingStatus() throws Throwable
{
	Random random = new Random();
	int randomno = random.nextInt(3000);
	String expectedProjectName="CSK"+randomno;
	String expectedStatus = "on-going";
	ProjectLib projectlib = new ProjectLib("dhos",expectedProjectName,expectedStatus,145 );
	
	//Give Precondition and capture the response after doing post operation
	
	Response response = given()
	.contentType(ContentType.JSON)
	.body(projectlib)
	.when()
	.post("localhost:8084/addProjects");
	
	//Capture projectName and statuscode from the response
	String responseprojectName = response.jsonPath().getString("projectName");
	String responseStatus = response.jsonPath().get("status");
	
	//Provide the restassured verification
	response.then()
	.assertThat().statusCode(201)
	.assertThat().contentType(ContentType.JSON)
	.log().all();
	
	//step 1: Register the mySQL database
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	//Step 2: connect to the database
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	
	//Step 3: issue the database query
	Statement statement = connection.createStatement();
	
	//Step 4: execute the query and get the values from the database
	
	String actualprojectName = null;
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
	//Closing the Database Connection
	connection.close();
	
	//testng assertion
	//assertion using flag between expected and actual from database
	
	
}
}

