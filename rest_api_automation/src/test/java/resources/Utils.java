package resources;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;


public class Utils  {
	
	public static RequestSpecification json_request_spec;
	public RequestSpecification get_Place_RequestSpecBuilder() throws IOException
	{
		
		if (json_request_spec == null)
		{
		PrintStream stream = new PrintStream(new FileOutputStream("log.txt"));
		 json_request_spec =  new RequestSpecBuilder().setBaseUri(getGlobalValue("BaseUri"))
				 .setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(stream))
				 .addFilter(ResponseLoggingFilter.logResponseTo(stream))
				 .addQueryParam("key", "qaclick123").build();
		 
		}
		 return json_request_spec;
	}
	
	public String getGlobalValue(String Key) throws IOException
	{
		Properties property = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\n.sathyanarayanan\\eclipse-workspace\\rest_api_automation\\src\\test\\java\\resources\\cucumber.properties");
		property.load(fis);
		return property.getProperty(Key);
		
		
	}
	
	public JsonPath convertToJason(String response)
	{
		return new JsonPath(response);
	}
	
	public String getJsonValue(String response, String Key)
	{
		return convertToJason(response).get(Key).toString();
	}

}
