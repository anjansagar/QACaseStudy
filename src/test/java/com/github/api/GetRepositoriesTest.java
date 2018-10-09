package com.github.api;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GetRepositoriesTest {

	private String BASE_URI = "https://api.github.com/"; 
	private Response response;

	@BeforeTest
	public void suiteSetUp() {
		response = RestAssured.get(BASE_URI+"users/binnujesudasan/repos");
	}

	@Test
	public void verifyResponseCode() {
		int responseCode = response.getStatusCode();
		assertTrue(responseCode == 200);
	}

	@Test
	public void printResponse() {
		response.prettyPrint();
	}

	@Test
	public void verifyRepositoryCount() {
		List<Integer> repositoryCount = response.getBody().jsonPath().getList("$");
		System.out.println(repositoryCount.size());
		assertTrue(repositoryCount.size() == 6);

	}

	@Test
	public void captureResponseHeadersAndPrint() {
		Headers headersCaptured = response.getHeaders();
		Iterator<Header> headerIterator = headersCaptured.iterator();
		while (headerIterator.hasNext()) {
			Header header = (Header) headerIterator.next();
			System.out.println("Key: "+header.getName()+", Value: "+header.getValue());
		}
	}

	@Test
	public void assertListOfRepositoriesIds() {
		response.then().body("id", Matchers.hasItems(41202414, 152239814, 151860805, 117455365, 106032543, 117455272));
	}

	@Test
	public void assertDataAtSpecificPath() {
		String nodeId = response.getBody().jsonPath().get("owner.node_id[0]");
		assertTrue(nodeId.equals("MDQ6VXNlcjIxODc1NzA="));
	}

	@Test
	public void getMapData() {
		Map<String, String> ownerMap = response.body().jsonPath().getMap("owner[0]");
		assertTrue(ownerMap.containsValue("binnujesudasan"));
	}

	@Test
	public void getCallInBddStyle() {
		String customCallURI = "https://api.github.com/users/binnujesudasan";
		given().
			headers("Content-Type",ContentType.JSON,"Accept",ContentType.JSON).
		when().
			get(customCallURI).
		then().
			body("id", Matchers.is(2187570)).
		and().
			body("public_gists", Matchers.is(2));	
	}
}