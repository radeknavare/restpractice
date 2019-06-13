package resources;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMethods {

	public JsonPath rawDataToJson(Response response)
	{
		JsonPath jp = new JsonPath(response.asString());
		return jp;
	}
}
