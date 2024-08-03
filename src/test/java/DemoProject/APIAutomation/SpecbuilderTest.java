package DemoProject.APIAutomation;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecbuilderTest {

@Test
public void specbuilderTest()
{
RequestSpecification reqspec=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType("application/json").build();
ResponseSpecification resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
RequestSpecification res=given().spec(reqspec).body(payload.addPlacePayload());
String response=res.when().post("maps/api/place/add/json").then().spec(resspec).log().all().extract().asString();
JsonPath js=new JsonPath(response);
System.out.println(js.getString("place_id"));
}
}