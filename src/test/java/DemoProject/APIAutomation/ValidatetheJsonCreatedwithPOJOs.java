package DemoProject.APIAutomation;

import org.testng.annotations.Test;

import DemoProject.pojos.GetCourse;

public class ValidatetheJsonCreatedwithPOJOs {
	
	@Test
	public void testCreateJson()
	{
		GetCourse getCourse=new GetCourse();
		getCourse.setExpertise("Automation Selenium");
//		getCourse.setE("Automation Selenium");
		getCourse.setExpertise("Automation Selenium");
		getCourse.setExpertise("Automation Selenium");
	}

}
