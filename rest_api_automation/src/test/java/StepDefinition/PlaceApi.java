package StepDefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;
import resources.ApiResources;
import resources.BuildTestData;
import resources.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(Cucumber.class)
public class PlaceApi extends Utils {
	
	RequestSpecification json_request;
	String strResponse;
	Response json_response;
	static String placeid;
	BuildTestData data = new BuildTestData();
	
	 @Given("^user has payload ready with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	    public void user_has_payload_ready_with_something_something_something_something(String address, String language, String name, String phone) throws Throwable {
	      		 
		 
		 json_request = RestAssured.given().spec(get_Place_RequestSpecBuilder()).body(data.data_serialize(address, language, name, phone));
	
	        
	    }

	 @When("user calls {string} with {string} http request")
	 	public void user_calls_with_http_request(String resource, String httpmethod) throws Throwable {
		   String httpresource = ApiResources.valueOf(resource).getResource();
		   System.out.println(httpresource);
		   if(httpmethod.equalsIgnoreCase("POST"))
		       json_response = json_request.when().post(httpresource);
		   else if(httpmethod.equalsIgnoreCase("GET"))
			   json_response = json_request.when().get(httpresource);
		   strResponse = json_response.asString();
		   if (placeid == null)
		   {
			   placeid = getJsonValue(strResponse, "place_id");
	        	
		   }
	    }

	 @Then("user gets a statuscode of {string}")
	 		public void user_gets_a_statuscode_of(String code) {
	    	String stCode  = Integer.toString(json_response.statusCode());
	    	assertEquals(stCode, code);
	        
	    }

	    @And("^\"([^\"]*)\" is \"([^\"]*)\"$")
	    public void something_is_something(String strArg1, String strArg2) throws Throwable {
	        
	    }
	    
	    @And("verify place_Id created maps to {string}")
	    public void verify_place_id_created_maps_to(String expectedName) throws Throwable {
	        // Write code here that turns the phrase above into concrete actions
	    	
	    	json_request.queryParam("place_id", placeid);
	    	user_calls_with_http_request("GetPlaceApi", "GET");
	    	assertEquals(getJsonValue(json_response.asString(), "name"), expectedName) ;
	      
	    }
	    
	    @Given("^user has deletePlaceApi payload$")
	    public void user_has_deleteplaceapi_payload() throws Throwable {
	    	
	    		 data = new BuildTestData();
	        
	    		 json_request = RestAssured.given().spec(get_Place_RequestSpecBuilder()).body(data.data_request_deleteApi(placeid));
	    }

}
