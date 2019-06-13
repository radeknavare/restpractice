package org.restpractice.restpractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.sun.xml.bind.v2.runtime.reflect.opt.FieldAccessor_Boolean;


public class RestAPICall {

	@Test
	public void Connect_API() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\navarked\\Documents\\restpractice\\src\\test\\java\\resources\\configuration.properties");
		prop.load(fis);
		RestAssured.baseURI = prop.getProperty("GOOGLE");
		Response r = given().
				queryParam("key","AIzaSyCamUynSbAa79OOqdFObMp9b3I5q7D5cfw").
				queryParam("location","-33.8670522,151.1957362").
				queryParam("radius","500").
				queryParam("type","restaurant").
				when().
					get("/maps/api/place/nearbysearch/json").
				then().
					assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
					.body("results[0].name",equalTo("The Little Snail Restaurant")).extract().response();
		
		String response = r.toString();
		System.out.println(response);
		JsonPath jp = new JsonPath(r.toString());
		System.out.println(jp.get("results[0].name"));
	}
}
