package com.github.api;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRepositoriesTest {
	
	private static final String BASE_URI = "https://api.github.com/"; 
	Response response;
	
	@BeforeSuite
	public void suiteSetUp() {
		response = RestAssured.get(BASE_URI+"users/binnujesudasan/repos");
	}
	
	@Test
	public void verifyResponseCode() {
		int responseCode = response.getStatusCode();
		Assert.assertTrue(responseCode == 200);
	}
	
	@Test(enabled=true)
	public void printResponse() {
		response.prettyPrint();
	}
	
	@Test(enabled=true)
	public void verifyRepositoryCount() {
		response.getBody().jsonPath().get("");
	}
	
	@Test(enabled=true)
	public void readResponseHeaders() {
		
	}
}
