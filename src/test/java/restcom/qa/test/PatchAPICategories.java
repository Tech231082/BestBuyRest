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

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.Base;
import com.qa.client.RestClient1;
import com.qa.data.UserCategories;

public class PatchAPICategories extends Base{
	
	Base base;
	RestClient1 client;
	String url;
	String baseUrl;
	String patchCategoriesUrl;
	CloseableHttpResponse response;
	
	
	@BeforeMethod
	public void setUp() {
		
		base=new Base();
		baseUrl=prop.getProperty("baseUrl");
		patchCategoriesUrl=prop.getProperty("patchCategoriesUrl");
		url=baseUrl+patchCategoriesUrl;
	}
	
	@Test
	public void test() throws JsonGenerationException, JsonMappingException, IOException {
		client=new RestClient1();
		
		HashMap<String,String> headerMap=new HashMap<String,String>();
		headerMap.put("Content-Type", "application/json");
		
		UserCategories userCategories= new UserCategories("Learning Toddler","abcat0020003");
		
		ObjectMapper mapper=new ObjectMapper();
		
		mapper.writeValue(new File("C://Users//parmod.kumar//git//BestBuyRest//rest//src//main//java//com//qa//data//userCategories.json"), userCategories);
		
		String entityString=mapper.writeValueAsString(userCategories);
		
		response=client.patchCategoriesID(url, entityString, headerMap);
		
		int code=response.getStatusLine().getStatusCode();
		
		System.out.println(code);
		
	}
	
	@Test
	public void patchCategoriesIDTest() throws JsonGenerationException, JsonMappingException, IOException {
		client=new RestClient1();
		
		HashMap<String,String> headerMap=new HashMap<String,String>();
		headerMap.put("Content-Type", "application/json");
		
		UserCategories userCategories=new UserCategories("Toddler toys","abcat0020002");
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.writeValue(new File("C://Users//parmod.kumar//git//BestBuyRest//rest//src//main//java//com//qa//data//userCategories1.json"), userCategories);
		
		String entityString=mapper.writeValueAsString(userCategories);
		
		
		response=client.patchCategoriesID1(url, entityString, headerMap);
		int code=response.getStatusLine().getStatusCode();
		System.out.println(code);
		
		String responseString=EntityUtils.toString(response.getEntity(), "UTF-8");
		
		System.out.println("String response is "+responseString);
		
		JSONObject jsonResponse=new JSONObject(responseString);
		
		System.out.println("Response in json "+responseString);
		
		UserCategories userCategoriesObj=mapper.readValue(responseString, UserCategories.class);
		
		Assert.assertEquals(userCategoriesObj.getName(), userCategories.getName());
		Assert.assertEquals(userCategoriesObj.getId(), userCategories.getId());
	}

}
