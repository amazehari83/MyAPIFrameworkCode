package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class ValidateDynamicResponseTest 
{
@Test
public void dynamicResponseTest()
{
	
	String expectedData = "rmg";
	String actualData=null;
	
	Response response = when()
	.get("http://localhost:8084/projects");
	try
	{
	
	
	List<String> list = response.jsonPath().get("createdBy");
	
	 
	 boolean flag=false;
	 
	 for(String listdata:list)
	 {
		 if(listdata.equals(expectedData))
		 {
			 actualData=listdata;
			 flag=true;
			System.out.println("actual data Value is present: "+actualData);
			 break;
		 }
	 }
	
	 Assert.assertEquals(flag, true);
	 Assert.assertEquals(actualData, expectedData);
	 response.then().statusCode(200).log().all();
	}
	
	 catch (Exception e)
	{
			// TODO: handle exception
	}
}
}

