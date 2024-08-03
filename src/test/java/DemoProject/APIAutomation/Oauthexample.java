package DemoProject.APIAutomation;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.tools.javac.util.List;

import DemoProject.pojos.Api;
import DemoProject.pojos.GetCourse;
import DemoProject.pojos.WebAutomation;
import io.restassured.path.json.JsonPath;

public class Oauthexample {
	
	@Test(priority=1)
	public void testacccessToken()
	{
		String response=given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type","client_credentials")
		.formParam("scope", "trust")
		.when().log().all()
		.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		JsonPath js =new JsonPath(response);
		String token=js.getString("access_token");
		GetCourse getcourse=given().queryParam("access_token", token)
		.when().log().all()
		.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").then().log().all().extract().response()
		.as(GetCourse.class);
		System.out.println(getcourse.getLinkedIn());
		System.out.println(getcourse.getExpertise());
		System.out.println(getcourse.getInstructor());
		System.out.println(getcourse.getServices());
		getcourse.getCourses().getApi().get(0).getCourseTitle();
		
		java.util.List<Api> apis=getcourse.getCourses().getApi();
		for(int i=0;i<apis.size();i++)
		{
			if(apis.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
			{
				System.out.println("Price is: "+apis.get(i).getPrice());
			}
		}
		java.util.List<WebAutomation> wa=getcourse.getCourses().getWebAutomation();
		String[] courseTitles= {"Selenium Webdriver Java","Cypress","Protractor."};
		java.util.List<String> actualCourses=new ArrayList<String>();
		for(int i=0;i<wa.size();i++)
		{
			actualCourses.add(wa.get(i).getCourseTitle());
			System.out.println("Course Title is"+wa.get(i).getCourseTitle());
		}
		java.util.List<String> test=Arrays.asList(courseTitles);
		Assert.assertTrue(test.equals(actualCourses));
	}
}