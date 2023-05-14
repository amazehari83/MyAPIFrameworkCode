package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ValidateStaticResponse1Test
{
	@Test
	public void staticResponse()
	{
		String expectedCreatedBy = "raju";

		Response response = when()
				.get("http://localhost:8084/projects");

		response.then()
		.assertThat()
		.statusCode(200)
		.log().all();

		String actualCreatedBy = response.jsonPath().get("[0].createdBy");
		System.out.println(expectedCreatedBy);
		System.out.println(actualCreatedBy);
		Assert.assertEquals(actualCreatedBy, expectedCreatedBy);

	}
}
