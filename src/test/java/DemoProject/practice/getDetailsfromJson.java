package DemoProject.practice;

import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class getDetailsfromJson {

	@Test
	public void getCourseDetails()
	{
		int sum=0;
		String response=payload.coursePrice();
		JsonPath js=new JsonPath(response);
		int purchaseAmount= js.getInt("dashboard.purchaseAmount");
		int count= js.getInt("courses.size()");
		System.out.println(purchaseAmount);
		System.out.println("No of Courses:"+count);
		for(int i=0;i<count;i++)
		{
			int coursePrice=js.getInt("courses["+i+"].price");
			String courseTitle=js.getString("courses["+i+"].title");
			int copies=js.getInt("courses["+i+"].copies");
			System.out.println(courseTitle+"Price--->"+coursePrice+"No of Copies-->"+copies);
			sum=sum+coursePrice*copies;
		}
		System.out.println("Total purchase Amount:"+sum);
	}
}
