package restcom.qa.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.client.RestClient1;
import com.qa.util.TestUtil;

public class DeleteAPITest extends Base{
	Base base;
	String url;
	String baseUrl;
	String serviceUrlDel;
	RestClient1 client;
	CloseableHttpResponse response;
	String storesIdDelUrl;
	String categoriesIDUrl;
	
	@BeforeMethod
	public void setUp() {
		base=new Base();
		baseUrl=prop.getProperty("baseUrl");
		//serviceUrlDel=prop.getProperty("serviceUrlDel");
		//url=baseUrl+serviceUrlDel;
		//storesIdDelUrl=prop.getProperty("storesIdDelUrl");
		//url=baseUrl+storesIdDelUrl;
		categoriesIDUrl=prop.getProperty("categoriesIDUrl");
		url=baseUrl+categoriesIDUrl;
		
	}
	
	@Test(enabled=false)
	public void deleteIDTest() throws ClientProtocolException, IOException {
		client=new RestClient1();
		response=client.deleteId(url);
		
		System.out.println("Status code is "+response.getStatusLine().getStatusCode());
		
		Assert.assertEquals(response.getStatusLine().getStatusCode(), Base.status_code_404);
		
		String stringResponse=EntityUtils.toString(response.getEntity(), "UTF-8");
		
		System.out.println(stringResponse);
		
		JSONObject json=new JSONObject(stringResponse);
		
		System.out.println("Json response is "+json);
		
		String name=TestUtil.getValueByJsonPath(json, "/name");
		String className=TestUtil.getValueByJsonPath(json, "/className");
		System.out.println("Name "+name);
		System.out.println("Class Name "+className);
		
		
	}
	
	@Test(enabled=false)
	public void deleteStoresIDTest() throws ClientProtocolException, IOException {
		client=new RestClient1();
		HashMap<String,String> headerMap=new HashMap<String,String>();
		headerMap.put("Content-Type", "application/json");
		response=client.deleteStoresID(url,headerMap);
		
		System.out.println("Raw Response is "+response);
		
		int code=response.getStatusLine().getStatusCode();
		
		Assert.assertEquals(code, Base.status_code_404,"Status code is not correct");
		
		String responseString=EntityUtils.toString(response.getEntity(), "UTF-8");
		
		System.out.println("String response is"+responseString);
		
		JSONObject json=new JSONObject(responseString);
		
		System.out.println("Json response is "+json);
		
		String name=TestUtil.getValueByJsonPath(json, "/name");
		String message=TestUtil.getValueByJsonPath(json, "/message");
		
		System.out.println("Name is "+name);
		System.out.println("Message is "+message);
		
		
	}
	
	@Test
	public void deleteCatogoriesIDWithHeadersTest() throws ClientProtocolException, IOException {
		client=new RestClient1();
		
		HashMap<String,String> headerMap=new HashMap<String,String>();
		
		headerMap.put("Content-Type", "application/json");
		
		response=client.deleteCatogoriesIDWithHeaders(url, headerMap);
		
		System.out.println("Response code is : "+response.getStatusLine().getStatusCode());
		
		String responseString=EntityUtils.toString(response.getEntity(), "UTF-8");
		
		JSONObject json=new JSONObject(responseString);
		System.out.println("Json response is "+json);
		
		
		
		
	}

}
