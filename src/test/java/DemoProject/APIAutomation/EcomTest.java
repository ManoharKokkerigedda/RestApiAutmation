package DemoProject.APIAutomation;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import DemoProject.pojos.LoginRequest;
import DemoProject.pojos.LoginResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class EcomTest {
	
	public String token="";
	public String userid="";
	
	@Test(priority=1)
	public void generateToken()
	{
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		LoginRequest lr=new LoginRequest();
		lr.setUserEmail("postman@gmail.com");
		lr.setUserPassword("Hello123@");
		RequestSpecification reqlogin=given().log().all().spec(req).body(lr);
		LoginResponse loginres=reqlogin.when().post("/api/ecom/auth/login").then().log().all().extract().as(LoginResponse.class);
		token=loginres.getToken();
		userid=loginres.getUserId();
		System.out.println("token:"+token);
		System.out.println("userid:"+userid);
		RequestSpecification req1=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
				addHeader("authorization", token).build();
		RequestSpecification addproduct=given().spec(req1).formParam("productName", "LaptopLenovo").formParam("productAddedBy", userid).formParam("productCategory", "Fashion")
		.formParam("productSubCategory","shirts").formParam("productPrice", "11500").formParam("productDescription", "Addias Originals")
		.formParam("productFor", "women")
		.multiPart("productImage", new File("C://Users//manoh//OneDrive//Pictures//image_Code.png"));
		String response1=addproduct.when().post("/api/ecom/product/add-product").then().extract().response().asString();
		System.out.println(response1);
	} 
	@Test()
	public void CreateProduct()
	{
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
				addHeader("authorization", token).build();
		RequestSpecification addproduct=given().spec(req).formParam("productName", "LaptopLenovo").formParam("productAddedBy", userid).formParam("productCategory", "Fashion")
		.formParam("productSubCategory","shirts").formParam("productPrice", "11500").formParam("productDescription", "Addias Originals")
		.formParam("productFor", "women")
		.multiPart("productImage", new File("C://Users//manoh//OneDrive//Pictures//image_Code.png"));
		String response=addproduct.when().post("/api/ecom/product/add-product").then().extract().response().asString();
		System.out.println(response);
		
	}
}
