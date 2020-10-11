package resources;

import java.util.ArrayList;
import java.util.List;
import POJO.Address;
import POJO.location;



public class BuildTestData {

	public Address data_serialize(String address, String lang, String name, String Ph) {
		Address addr = new Address();
		addr.setAccuracy(50);
		addr.setAddress(address);
		addr.setLanguage(lang);
		addr.setName(name);
		addr.setPhone_number(Ph);
		addr.setWebsite("http://google.com");
		List<String> tps = new ArrayList<String>();
		tps.add("shoe park");
		tps.add("shop");
		addr.setTypes(tps);
		location l = new location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		addr.setLoc(l);
		return addr;
	}
	
	public String data_request_deleteApi(String plcid)
	{
	
		String req = ("{\r\n"
				+ "    \"place_id\":\""+plcid+"\"\r\n"
				+ "}\r\n"
				+ "");
		
		
		return req;
	}
		
}
