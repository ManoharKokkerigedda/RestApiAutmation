package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class payload {
	
	
	public static String addPlacePayload() {
		return "{\r\n"
	       		+ "  \"location\": {\r\n"
	       		+ "    \"lat\": -39.383494,\r\n"
	       		+ "    \"lng\": 33.427362\r\n"
	       		+ "  },\r\n"
	       		+ "  \"accuracy\": 50, \r\n"
	       		+ "  \"name\": \"Frontline house\",\r\n"
	       		+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
	       		+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
	       		+ "  \"types\": [\r\n"
	       		+ "    \"shoe park\",\r\n"
	       		+ "    \"shop\"\r\n"
	       		+ "  ],\r\n"
	       		+ "  \"website\": \"http://google.com\",\r\n"
	       		+ "  \"language\": \"French-IN\"\r\n"
	       		+ "}";
	}
	
	public static String updatePayload(String place_id,String Address)
	{
		return "{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\": \""+Address+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}";
	}
	public static String coursePrice()
	{
		return "{\r\n"
				+ "\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "\"courses\": [\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\r\n"
				+ "\"price\": 50,\r\n"
				+ "\r\n"
				+ "\"copies\": 6\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\r\n"
				+ "\"price\": 40,\r\n"
				+ "\r\n"
				+ "\"copies\": 4\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\r\n"
				+ "\"price\": 45,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "]\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "";
	}
	
	public static String addbook(String isbn,String aisle)
	{
		return "{\r\n"
				+ "\"name\":\"Learn CoreJava Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"Jn foer\"\r\n"
				+ "}\r\n"
				+ "";
	}
	public static String GenerateStringFromResource(String path) throws IOException {
	    return new String(Files.readAllBytes(Paths.get(path)));
	}
}