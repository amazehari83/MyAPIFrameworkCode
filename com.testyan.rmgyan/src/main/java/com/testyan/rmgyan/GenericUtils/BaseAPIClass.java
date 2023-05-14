package com.testyan.rmgyan.GenericUtils;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

/**
 * 
 * @author HARI HARAN
 *
 */
public class BaseAPIClass 
{
	DataBaseUtilities db = new DataBaseUtilities();
	/**
	 * @author HARI HARAN
	 * This Method is used for starting the Database and Connect to the Database
	 */
	@BeforeSuite
	public void configBeforeSuite()
	{
		System.out.println("Database is started Successfully");
		db.connectToDB();
		System.out.println("Connected to the Database Successfully");
		baseURI = "http://localhost";
		port = 8084;
	}
	/**
	 * @author HARI HARAN
	 * This Method is used for closing the Database connection
	 */
	@AfterSuite
	public void configAfterSuite() throws Throwable 
	{
		db.closeDB();
		System.out.println("Database Connection is closed");
	}
}

