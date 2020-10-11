package StepDefinition;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace") 
	public void get_place_id() throws Throwable
	{
		if (PlaceApi.placeid == null)
		{
			PlaceApi plc = new PlaceApi();
			plc.user_has_payload_ready_with_something_something_something_something("Anderson Mill", "Hindi", "Shetty","5128671200");
			plc.user_calls_with_http_request("AddPlaceApi", "post");
			plc.verify_place_id_created_maps_to("Shetty");
			
		}
	}
	
	

}
