package org.restpractice.bookAPI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import groovy.json.JsonBuilder;

import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddBook {
	Properties p;
	
	@BeforeTest
	public void initialize() throws FileNotFoundException, IOException
	{
		p = new Properties();
		p.load(new FileInputStream("C:\\Users\\navarked\\Documents\\restpractice\\src\\test\\java\\resources\\configuration.properties"));
		RestAssured.baseURI= p.getProperty("ADDBOOK");
	}

	@Test
	public void bookAdd()
	{
		Response r = given().body("{\r\n" + 
				"\r\n" + 
				"\"name\":\"KRestPractice\",\r\n" + 
				"\"isbn\":\"k123\",\r\n" + 
				"\"aisle\":\"227\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n").when().post(p.getProperty("ADDBOOKRESOURCES")).then().log().all().assertThat().body("Msg",equalTo("successfully added")).extract().response();
		
		JsonPath jp = new JsonPath(r.toString());
		
		System.out.println(jp.get("Msg"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(jp.getBoolean("Msg"), "successfully added");
		Assert.assertEquals(jp.get("Msg"), "successfully added");
		softAssert.assertAll();
	}
}
