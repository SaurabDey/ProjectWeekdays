package com.selenium.ProjectWeekdays;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/*<!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>4.1.1</version>
</dependency>*/
public class AssuredClass {

	/*<!-- https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple -->
	<dependency>
	    <groupId>com.googlecode.json-simple</groupId>
	    <artifactId>json-simple</artifactId>
	    <version>1.1.1</version>
	</dependency>*/
	@Test
	public void rest() throws ParseException, FileNotFoundException, IOException
	{
		/*Response resp=RestAssured.
			given().
				baseUri("http://dummy.restapiexample.com/api/v1/employees").
				contentType("application/json").
			when().
				get();
		
		String myresponse =resp.getBody().asString();
		int status=resp.statusCode();
		long myTime=resp.getTime();
		
		System.out.println(myresponse);
		System.out.println(status);
		System.out.println(myTime);*/
		
		
		//*********JSONObject for single employee*******//
		/*
		 * JSONParser parser = new JSONParser(); 
		 * JSONObject jsonO= (JSONObject)parser.parse(myresponse);
		 * 
		 * String name = jsonO.get("employee_name").toString();
		 * String id=jsonO.get("id").toString(); 
		 * System.out.println(name+" "+id);
		 */

		//*********JSONArray and JSONObject for multiple employee*******//
		
		/*
		 * JSONParser parser = new JSONParser(); 
		 * JSONArray jsonA= (JSONArray)parser.parse(myresponse);
		 * 
		 * System.out.println(jsonA.size()); 
		 * for (int i = 0; i < jsonA.size();i++) 
		 * { 
		 * JSONObject jsonO= (JSONObject)parser.parse(jsonA.get(i).toString());
		 * String name = jsonO.get("employee_name").toString(); 
		 * String id =jsonO.get("id").toString(); 
		 * System.out.println(name+" "+id); 
		 * }
		 */
		
		//*********JSONArray and JSONObject from a FILE*******//
		JSONParser parser = new JSONParser(); 
		JSONObject jsonO= (JSONObject)parser.parse(new FileReader("Resource/My.json"));
		String fname=jsonO.get("firstName").toString();
		System.out.println("FirstName "+fname);
		JSONObject jsoninnerO= (JSONObject)parser.parse(jsonO.get("address").toString());
		String street=jsoninnerO.get("streetAddress").toString();
		System.out.println("Street "+street);
		
		JSONArray jsoninnerA= (JSONArray)parser.parse(jsonO.get("phoneNumbers").toString());
		System.out.println("size "+jsoninnerA.size());
		for (int i = 0; i < jsoninnerA.size(); i++) {
			JSONObject jsonPhoneinnerO= (JSONObject)parser.parse(jsoninnerA.get(i).toString());
			String ty = (String) jsonPhoneinnerO.get("type");
			System.out.println("type "+ty);
			
		}
		
		
	}
	@Test(enabled=false)
	public void soap()
	{
		Response resp=RestAssured.
			given().
				baseUri("http://www.dneonline.com/calculator.asmx").
				contentType("text/xml").
				body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n   <soapenv:Header/>\n   <soapenv:Body>\n      <tem:Add>\n         <tem:intA>90</tem:intA>\n         <tem:intB>10</tem:intB>\n      </tem:Add>\n   </soapenv:Body>\n</soapenv:Envelope>").
			when().
				post();
		
		String myresponse =resp.getBody().asString();
		int status=resp.statusCode();
		long myTime=resp.getTime();
		
		System.out.println(myresponse);
		System.out.println(status);
		System.out.println(myTime);
		
	}
}
