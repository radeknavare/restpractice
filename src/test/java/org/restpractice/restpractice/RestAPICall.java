package org.restpractice.restpractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;


public class RestAPICall {

	@Test
	public void Connect_API() {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		given().
				queryParam("key","AIzaSyCamUynSbAa79OOqdFObMp9b3I5q7D5cfw").
				queryParam("location","-33.8670522,151.1957362").
				queryParam("radius","500").
				queryParam("type","restaurant").
				when().
					get("/maps/api/place/nearbysearch/json").
				then().
					assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
					.body("results[0].name",equalTo("The Little Snail Restaurant")).and()
					.body("results[0].icon", equalTo("https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png")).and()
					.header("server", "scaffolding on HTTPServer2");
	}
}
