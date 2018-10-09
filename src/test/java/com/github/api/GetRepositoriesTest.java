package com.github.api;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GetRepositoriesTest {
	
	private static final String BASE_URI = "https://api.github.com/"; 
	Response response;
	
	@BeforeSuite
	public void suiteSetUp() {
		response = RestAssured.get(BASE_URI+"users/binnujesudasan/repos");
	}
	
	@Test(enabled=true)
	public void verifyResponseCode() {
		int responseCode = response.getStatusCode();
		assertTrue(responseCode == 200);
	}
	
	@Test(enabled=true)
	public void printResponse() {
		response.prettyPrint();
	}
	
	@Test(enabled=true)
	public void verifyRepositoryCount() {
		List<Integer> repositoryCount = response.getBody().jsonPath().getList("$");
		System.out.println(repositoryCount.size());
		assertTrue(repositoryCount.size() == 6);
	
	}
	
	@Test(enabled=true)
	public void captureResponseHeadersAndPrint() {
		Headers headersCaptured = response.getHeaders();
		Iterator<Header> headerIterator = headersCaptured.iterator();
		while (headerIterator.hasNext()) {
			Header header = (Header) headerIterator.next();
			System.out.println("Key: "+header.getName()+", Value: "+header.getValue());
		}
	}
}
