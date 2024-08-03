package DemoProject.APIAutomation;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import DemoProject.pojos.LocationPOJO;
import DemoProject.pojos.addPLace;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SerializationofInputPayload {

	public static void main(String[] args) {
		
		List<String> t=new ArrayList<String>();
		t.add("shoe park");
		t.add("shoe");
		addPLace add=new addPLace();
		add.setLat(38.122);
		add.setLng(-38.122);
	LocationPOJO p=new LocationPOJO();
	p.setAccuracy(50);
	p.setAddress("Test Address");
	p.setLanguage("French");
	p.setName("My Home");
	p.setPhone_number("123123123");
	p.setWebsite("Google.com");
	p.setTypes(t);
	p.setLocation(add);
	RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123").build();
	ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).log(LogDetail.ALL).build();
	given().spec(req).log().all()
	.body(p)
	.when().post("/maps/api/place/add/json")
	.then().spec(res);

	}
}