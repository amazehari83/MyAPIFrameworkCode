package com.testyan.withbddtest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
/**
 * 
 * @author HARI HARAN
 *
 */
public class DeleteProjectWithBDDDELETETest 
{
	/**
	 Code for deleting project from server using DELETE Method with BDD
	 */
   @Test
   public void deleteprojects()
   
   {
	   when()
	      .delete("http://localhost:8084/projects/TY_PROJ_803")
	        .then().assertThat()
	          .statusCode(204)
	            .and()
	               .log()
	                  .all(); 
   }
}

