package DemoProject.Pojoscreation;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetTest {
	
	@Test
	public void getTest()
	{
		HashMap<String,String> a=new HashMap<String, String>();
		a.put("user", "Manohar");
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addPathParam("place", "lksj").build();
		ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).log(LogDetail.ALL).build();
		given().spec(req).log().all()
		.body(a)
		.when().post("/maps/api/place/get/json/{place}")
		.then().spec(res).log().all();
	}
}