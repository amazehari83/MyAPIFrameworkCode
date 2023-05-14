package com.testyan.rmgyan.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author HARI HARAN
 *
 */
public class DataBaseUtilities 
{
	static Connection connection=null;
	static ResultSet result;
	/**
	 * @author HARI HARAN
	 * This method will perform mysql database connection
	 */
	public void connectToDB()

	{
		try 
		{
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection(IConstantsAndPath.dbUrl, IConstantsAndPath.dbUserName,IConstantsAndPath.dbPassword);
			
		} 
		catch (SQLException e)
		{

			e.printStackTrace();
		}
	}
	/**
	 * @author HARI HARAN
	 * This method will perform database close action
	 */
	public void closeDB() throws SQLException
	{
		connection.close();
	}
	/**
	 * This method will execute the query and gives the result
	 * @param query
	 * @return
	 */
	public ResultSet executeQuery(String query)
	{
		try {
			result = connection.createStatement().executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 * @param query
	 * @param columnNumber
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 * This method will verify whether data is present in database or not
	 */

	public String executeQueryAndGetData(String query,int columnNumber, String expectedData) throws Throwable
	{
		boolean flag = false;
		result = connection.createStatement().executeQuery(query);
		while(result.next())
		{
			try
			{
				if(result.getString(columnNumber).equals(expectedData))
				{
					flag = true;
					break;
				}
			}
			catch(Exception e)
			{

			}
		}
		if(flag)
		{
			System.out.println(expectedData+"===>Data is verified in the database");
			return expectedData;
		}
		else
		{
			System.out.println(expectedData+"===> Data is not available in the Database");
			return expectedData;

		}
	}

}


