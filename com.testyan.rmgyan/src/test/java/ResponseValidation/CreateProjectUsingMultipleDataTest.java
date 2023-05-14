package ResponseValidation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.projectpojolib.ProjectLib;

import io.restassured.http.ContentType;

public class CreateProjectUsingMultipleDataTest 
{
 @Test(dataProvider="provideData")
 public void createMultipleProject(String createdBy,String projectName , String status,int teamSize)
 {
	 ProjectLib pojoObject = new ProjectLib(createdBy,projectName,status,teamSize);
	 given()
	  .contentType(ContentType.JSON)
	   .body(pojoObject)
	    .when()
	     .post("http://localhost:8084/addProject")
	      .then()
	       .log().all()
	        .and()
	         .assertThat().statusCode(201)
	          .and()
	           .assertThat()
	           	 .contentType("application/json");

 }

@DataProvider
public Object[][] provideData()
{
	Object[][] objArray = new Object[3][4];
	objArray[0][0] = "HARAN";
	objArray[0][1] = "HARAN123";
    objArray[0][2] = "Completed";
    objArray[0][3] = 102;
    
    objArray[1][0] = "HARANN";
	objArray[1][1] = "HARAN123456";
    objArray[1][2] = "Completed";
    objArray[1][3] = 202;
    
    objArray[2][0] = "HARANNN";
	objArray[2][1] = "HARAN123456789";
    objArray[2][2] = "Completed";
    objArray[2][3] = 302;
    
    return objArray;
}
}
