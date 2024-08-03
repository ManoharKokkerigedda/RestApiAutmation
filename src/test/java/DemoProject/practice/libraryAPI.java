package DemoProject.practice;
import static io.restassured.RestAssured.given;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class libraryAPI {
	
	@Test(dataProvider="BooksData")
	public void addbook(String isbn,String aisle)
	{
	RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
	RequestSpecification addbook=given().spec(req).body(payload.addbook(isbn,aisle));
	String response=addbook.when().post("/Library/Addbook.php").then().log().all().extract().asString();
	}
	
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		return new Object[][] {{"asdas","123123"},{"lksdg","12321"}};
	}
}