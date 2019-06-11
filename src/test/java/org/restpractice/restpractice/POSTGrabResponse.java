package org.restpractice.restpractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class POSTGrabResponse {

	@Test 
	public void POSTtest() {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		Response res = given().body("{"+
			      "\"title\": \"foo\","+
			      "\"body\": \"bar\","+
			      "\"userId\": 200,"+
			      "\"id\": 2000,"+
			    "}").
when().post("/posts").then().assertThat().statusCode(201).and().contentType(ContentType.JSON).assertThat().body("id",equalTo(101)).extract().response();
		
		String response = res.asString();
		
		System.out.println(response);
		JsonPath jp = new JsonPath(response);
		System.out.println(jp.get("id"));
		
		
	}
}
