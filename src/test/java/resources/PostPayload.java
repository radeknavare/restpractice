package resources;

public class PostPayload {

	public static String postPayloadMethod(int userId)
	{
		String payload = "{"+"\"title\": \"foo\","+
			      "\"body\": \"bar\","+
			      "\"userId\": "+userId+","+
			      "\"id\": 2000,"+
			    "}";
		
		return payload;
	}
}
