package restcom.qa.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.Base;
import com.qa.client.RestClient1;
import com.qa.data.UserServices;
import com.qa.data.Users;
import com.qa.data.Users1;

public class PostAPIServicesTest extends Base {
	Base base;
	RestClient1 client;
	String url;
	String baseUrl;
	String servicesPostUrl;
	CloseableHttpResponse response;
	
	@BeforeMethod
	public void setUp() {
		base=new Base();
		baseUrl=prop.getProperty("baseUrl");
		servicesPostUrl=prop.getProperty("servicesPostUrl");
		url=baseUrl+servicesPostUrl;
		
	}
	
	@Test
	public void post() throws JsonGenerationException, JsonMappingException, IOException {
		client=new RestClient1();
		
		//headerMap
		HashMap<String,String> headerMap=new HashMap<String,String>();
		headerMap.put("Content-Type", "application/json");
		
		//preparing data to be sent
		UserServices usersServices=new UserServices("BestBuyElectronicMedia");//expected users object
		
		//java object to json file
		ObjectMapper mapper=new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.writeValue(new File("C://Users//parmod.kumar//git//BestBuyRest//rest//src//main//java//com//qa//data//UserServices.json"),usersServices);
		
		//java object to json string
		String userJsonString=mapper.writeValueAsString(usersServices);
		
		System.out.println(userJsonString);
		
		
		CloseableHttpResponse response=client.postServices(url, userJsonString, headerMap);
		
		int code=response.getStatusLine().getStatusCode();
		
		System.out.println(code);
		
		//
		String responseString=EntityUtils.toString(response.getEntity(), "UTF-8");
		
		JSONObject jsonObjString=new JSONObject(responseString);
		
		System.out.println("Response in json format "+jsonObjString);
		
		//json to java
		UserServices userServicesObj=mapper.readValue(responseString,UserServices.class);//actual
		
		Assert.assertEquals(userServicesObj.getName(), usersServices.getName());
		
		
		
	}
}
