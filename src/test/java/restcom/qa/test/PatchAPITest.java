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
import com.qa.data.UsersPatch;

public class PatchAPITest extends Base {
	
	Base base;
	RestClient1 client;
	String url;
	String baseUrl;
	String patchServicesUrl;
	CloseableHttpResponse response;
	
	@BeforeMethod
	public void setUp() {
		base=new Base();
		baseUrl=prop.getProperty("baseUrl");
		patchServicesUrl=prop.getProperty("patchServicesUrl");
		url=baseUrl+patchServicesUrl;
	}

	@Test
	public void test() throws ClientProtocolException, IOException {
		client=new RestClient1();
		
		HashMap<String,String> headerMap=new HashMap<String,String>();
		headerMap.put("Content-Type", "application/json");
		
		UsersPatch usersPatch=new UsersPatch("BestBuyBooks");//expected users object
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		mapper.writeValue(new File("C://Users//parmod.kumar//git//BestBuyRest//rest//src//main//java//com//qa//data//UsersPatch.json"), usersPatch);
		
		String usersPatchString=mapper.writeValueAsString(usersPatch);
		
		System.out.println(usersPatchString);
		
		
		CloseableHttpResponse response=client.patchservices(url, usersPatchString, headerMap);
		
		System.out.println(response.getStatusLine().getStatusCode());
		
		String responseString=EntityUtils.toString(response.getEntity());
		
		System.out.println(responseString);
		
		JSONObject jsonObj=new JSONObject(responseString);
		
		System.out.println("JSON response of patch request is "+jsonObj);
		
		UsersPatch userPatchObj=mapper.readValue(responseString, UsersPatch.class);//actual users object
		
		Assert.assertEquals(userPatchObj.getName(), usersPatch.getName(),"Not Equals");
		
		
	}
	
}
