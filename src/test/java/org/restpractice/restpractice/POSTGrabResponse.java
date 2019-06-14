package org.restpractice.restpractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.PostPayload;
import resources.ReusableMethods;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class POSTGrabResponse {
	
	Properties p;
	@BeforeTest
	public void initialize() throws FileNotFoundException, IOException
	{
		p = new Properties();
		p.load(new FileInputStream("C:\\Users\\navarked\\Documents\\restpractice\\src\\test\\java\\resources\\configuration.properties"));
	}

	@Test 
	public void POSTtest() throws FileNotFoundException{
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = p.getProperty("JSONHOLDER");
		Response res = given().body(PostPayload.postPayloadMethod(300)).log().all().
when().post("/posts").then().log().all().assertThat().statusCode(201).and().contentType(ContentType.JSON).assertThat().body("id",equalTo(101)).extract().response();
		
		ReusableMethods rm = new ReusableMethods();
		JsonPath jp = rm.rawDataToJson(res);
		
		//Assert.assertEquals(jp.get("id"), "100");
		
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(jp.get("id"), 101,"Soft Assertion Failed");
		//Assert.assertEquals(jp.get("id"), "100");
		System.out.println(jp.get("id"));
		sa.assertAll();

	}
}
