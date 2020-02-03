package restcom.qa.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.Base;
import com.qa.client.RestClient1;
import com.qa.data.Users1;

public class PostAPICategoriesTest extends Base{
	
	Base base;
	RestClient1 client;
	String url;
	String baseUrl;
	String categoriesUrl;
	CloseableHttpResponse response;
	
	@BeforeMethod
	public void setUp() {
		base=new Base();
		baseUrl=prop.getProperty("baseUrl");
		categoriesUrl=prop.getProperty("categoriesUrl");
		url=baseUrl+categoriesUrl;
		
	}
	
	@Test
	public void postCatoriesTest() throws ClientProtocolException, IOException {
		client=new RestClient1();
		
		//adding the payload
		//users class
		Users1 users1=new Users1("GirlsAndBoysToys","abcat002000111");//expected users object
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		//java object to json conversion
		mapper.writeValue(new File("C://Users//parmod.kumar//git//BestBuyRest//rest//src//main//java//com//qa//data//user1.json"), users1);
		
		//java object to json string
		String usersJsonString=mapper.writeValueAsString(users1);
		
		System.out.println("Users data in Json string"+usersJsonString);
		
		//adding the headerMap 
		HashMap<String,String> headerMap=new HashMap<String,String>();
		headerMap.put("Content-Type", "application/json");
		
		response=client.post(url, usersJsonString, headerMap);
		
		int code=response.getStatusLine().getStatusCode();
		
		System.out.println("Status code : "+code);
		
		Assert.assertEquals(code, Base.status_code_201,"Status code is not as expected");
		
		String responseString=EntityUtils.toString(response.getEntity(), "UTF-8");
		
		System.out.println("Response in string "+responseString);
		
		JSONObject jsonResponse=new JSONObject(responseString);
		
		System.out.println("Response in json format "+jsonResponse);
		
		//json to java
		Users1 userObjResponse=mapper.readValue(responseString,Users1.class);//actual users object
		
		System.out.println(userObjResponse);
		
		
		System.out.println(users1.getName().equals(userObjResponse.getName()));
		
		System.out.println(users1.getId().equals(userObjResponse.getId()));
	}

}
