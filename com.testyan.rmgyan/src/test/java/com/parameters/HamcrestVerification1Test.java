package com.parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class HamcrestVerification1Test 
{
	@Test
	public void verifyNameStr()
	{
		given()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(500L), TimeUnit.SECONDS)
		.assertThat().body("[0].projectName",Matchers.equalTo("test"))
		.log().all();

	}
}
