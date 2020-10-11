package resources;

public enum ApiResources {
	
	AddPlaceApi("/maps/api/place/add/json"),
	DeletePlaceApi("/maps/api/place/delete/json"),
	GetPlaceApi("/maps/api/place/get/json"),
	PutPlaceApi("/maps/api/place/update/json");
	private String resources;
	
	ApiResources(String resources)
	{
		this.resources= resources;
	}
	
	public String getResource() {
		return resources;
	}
}
