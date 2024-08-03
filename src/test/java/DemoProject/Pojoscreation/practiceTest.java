package DemoProject.Pojoscreation;

import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class practiceTest {

	public static void main(String[] args) {

		addrecordbody a=new addrecordbody();
		a.setId(null);
		a.setPlace_id(null);
		a.setReference(null);
		a.setScope(null);
		a.setStatus(null);
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123").build();
		ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).log(LogDetail.ALL).build();
		given().spec(req).log().all()
		.body(a)
		.when().post("/maps/api/place/add/json/{place}")
		.then().spec(res).log().all();
		
		
	}
}