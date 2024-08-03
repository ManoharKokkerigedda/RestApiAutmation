package DemoProject.practice;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class Oauth20 {

	@Test
	public void getOauth()
	{
		RequestSpecification req=new RequestSpecBuilder()
				.addQueryParam("scope", "https://www.googleapis.com/auth/userinfo.email")
				.addQueryParam("auth_url","https://accounts.google.com/o/oauth2/v2/auth")
				.addQueryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.addQueryParam("response_type","code")
				.addQueryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php").build();
		String response=given().spec(req).log().all()
						.when().post("https://accounts.google.com/o/oauth2/v2/auth").asString();
		System.out.println(response);
		
		
	}
}