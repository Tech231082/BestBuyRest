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
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.BaseClass;
import com.qa.client.RestClient;
import com.qa.data.Users;

public class PostAPITest extends BaseClass{
	BaseClass base;
	String baseurl ;
	String serviceurl;
	String url;
	RestClient client;
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		base=new BaseClass();
		 baseurl = prop.getProperty("baseUrl");
		 serviceurl=prop.getProperty("serviceUrl");
		url=baseurl+serviceurl;
		
	}
	
	@Test
	public void postAPItest() throws JsonGenerationException, JsonMappingException, IOException {
		client=new RestClient();
		
		HashMap<String,String> headerMap=new HashMap<String,String>();
		headerMap.put("Content-Type", "application/json");
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		Users users=new Users("Mac","Apple",4000,5,"abcd","Silver","Apple","Pro","apple@mac.com","apple1@mac.com");
		
		//object to json
		mapper.writeValue(new File("C://Users//parmod.kumar//eclipse-workspace//rest//src//main//java//com//qa//data//users.json"), users);
		
		
		String usersjsonString=mapper.writeValueAsString(users);
		
		
		
		CloseableHttpResponse resp=client.post(url, usersjsonString, headerMap);
		int statusCode=resp.getStatusLine().getStatusCode();
		
		System.out.println("Status code : "+statusCode);
		
		Assert.assertEquals(statusCode, BaseClass.status_code_201);
		
		String respoString=EntityUtils.toString(resp.getEntity(), "UTF-8");
		
		//json object
		JSONObject jsonObj=new JSONObject(respoString);
		
		System.out.println("The response of API POST call is :  "+jsonObj);
		
		Users userObject=mapper.readValue(respoString, Users.class);
		
		Assert.assertTrue(users.getName().equals(userObject.getName()));
		
		Assert.assertTrue(users.getType().equals(userObject.getType()));
		
		System.out.println(respoString);
		
	}

}
