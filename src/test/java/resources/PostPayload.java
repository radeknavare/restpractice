package resources;

public class PostPayload {

	public static String postPayloadMethod()
	{
		String payload = "{"+"\"title\": \"foo\","+
			      "\"body\": \"bar\","+
			      "\"userId\": 200,"+
			      "\"id\": 2000,"+
			    "}";
		
		return payload;
	}
}
