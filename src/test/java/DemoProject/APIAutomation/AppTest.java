package DemoProject.APIAutomation;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AppTest 
{
	//Author Manohar Kokkerigedda
	public String place_id="69a3ea9f1ae565820a064263dc17580c";
   @Test(priority=1)
    public void AddPlace()
    {
       RestAssured.baseURI="https://rahulshettyacademy.com";
       String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
       .body(payload.addPlacePayload())
       .when().post("maps/api/place/add/json")
       .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
       .header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
       System.out.println(response);
       JsonPath js=new JsonPath(response);
       place_id=js.getString("place_id");
       System.out.println(place_id);
       
    }
   //Author Manohar Kokkerigedda
   @Test(priority=2)
   public void UpdatePlace()
   {
      RestAssured.baseURI="https://rahulshettyacademy.com";
      String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
      .body(payload.updatePayload(place_id,"Plot30,AxisPapaHomes,Hyderabad"))
      .when().put("maps/api/place/update/json")
      .then().assertThat().statusCode(200)
      .header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
      System.out.println(response);
      JsonPath js=new JsonPath(response);
      String msg=js.getString("msg");
      Assert.assertTrue(msg.equalsIgnoreCase("Address successfully updated"));
   }
   @Test(priority=3)
   public void GetPlace()
   {
      RestAssured.baseURI="https://rahulshettyacademy.com";
      String response=given().log().all().queryParam("key","qaclick123").queryParam("place_id",place_id)
      .when().get("maps/api/place/get/json")
      .then().assertThat().statusCode(200)
      .header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
      System.out.println(response);
      JsonPath js=new JsonPath(response);
      String msg=js.getString("address");
      System.out.println(msg);
   }
   @Test()
   public void reverseString()
   {
	   String Test="Manohar";
	   int size=Test.length();
	   String reversevalue="";

		   for(int i=size-1;i>=0;i--)
		   {
		   	reversevalue=reversevalue+Test.charAt(i);
		   }
		   System.out.println("reverseofString:-->"+reversevalue);
   }
}