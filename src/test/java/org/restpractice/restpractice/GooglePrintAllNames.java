package org.restpractice.restpractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GooglePrintAllNames {
	
	@Test
	public void printAllGoogleNameJSON()
	{
		String S="{"+"\"markers\": [{\"name\": \"Rixos The Palm Dubai\",\"position\": [25.1212, 55.1535],},{\"name\": \"Shangri-La Hotel\",\"location\": [25.2084, 55.2719]},{\"name\": \"Grand Hyatt\",\"location\": [25.2285, 55.3273]}]"+"}";			          
		JsonPath jp = new JsonPath(S);
		int size = jp.get("markers.size()");
		for(int i =0; i < size ; i++)
		{
			System.out.println(jp.get("markers["+i+"].name"));
		}
	}
}
