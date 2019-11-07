package restcom.qa.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
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

public class GetAPITestProducts extends Base{
	Base base;
	RestClient1 client;
	String url;
	String baseUrl;
	String productsUrlID;
	CloseableHttpResponse response;
	
	@BeforeMethod
	public void setUp() {
		base=new Base();
		baseUrl=prop.getProperty("baseUrl");
		productsUrlID=prop.getProperty("productsUrlID");
		url=baseUrl+productsUrlID;
		
	}
	
	@Test(priority=1,enabled=false)
	public void getProductsIDWithoutHeadersTest() throws ClientProtocolException, IOException {
		client=new RestClient1();
		CloseableHttpResponse response=client.getProductsID(url);
		
		//	String responseString=response.getEntity().toString();
		String responseString=EntityUtils.toString(response.getEntity(), "UTF-8");
		
		JSONObject jsonObj=new JSONObject(responseString);
		
		Header []headers=response.getAllHeaders();
		
		HashMap<String,String> headerMap=new HashMap<String,String>();
		System.out.println("Total number of headers are "+headers.length);
		
		for(Header header:headers) {
			headerMap.put(header.getName(), header.getValue());
		}
		
		System.out.println(headerMap);
		
		String name=TestUtil.getValueByJsonPath(jsonObj, "/name");
		
		System.out.println(name);
		
		System.out.println(TestUtil.getValueByJsonPath(jsonObj, "/type"));
		System.out.println(TestUtil.getValueByJsonPath(jsonObj, "/price"));
		System.out.println(TestUtil.getValueByJsonPath(jsonObj, "/shipping"));
		System.out.println(TestUtil.getValueByJsonPath(jsonObj, "/url"));
		//System.out.println(TestUtil.getValueByJsonPath(jsonObj, "/categories"));
		
		Assert.assertEquals(Double.parseDouble(TestUtil.getValueByJsonPath(jsonObj, "/price")), 5.49);
		
		String id=TestUtil.getValueByJsonPath(jsonObj, "/categories[0]/id");
		String name1=TestUtil.getValueByJsonPath(jsonObj, "/categories[0]/name");
		String createdAt=TestUtil.getValueByJsonPath(jsonObj, "/categories[0]/createdAt");
		String updatedAt=TestUtil.getValueByJsonPath(jsonObj, "/categories[0]/updatedAt");
		
	}
	
	@Test(priority=2,enabled=false)
	public void getProductsIDWithHeadersTest() throws ClientProtocolException, IOException {
		client=new RestClient1();
		HashMap<String,String> headerMap=new HashMap<String,String>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Accept-Charset", "utf-8");
		headerMap.put("Cache-Control", "no-cache");
		response=client.getProductsIDWithHeaders(url, headerMap);
		
       String responseString=EntityUtils.toString(response.getEntity(), "UTF-8");
		
		JSONObject jsonObj=new JSONObject(responseString);
		
		Header []headers=response.getAllHeaders();
		System.out.println("Total number of headers are "+headers.length);
		
		HashMap<String,String> headerMap1=new HashMap<String,String>();
		
		for(Header header:headers) {
			headerMap1.put(header.getName(), header.getValue());
		}
		
		System.out.println(headerMap1);
		
		String name=TestUtil.getValueByJsonPath(jsonObj, "/name");
		
		System.out.println(name);
		
		System.out.println(TestUtil.getValueByJsonPath(jsonObj, "/type"));
		System.out.println(TestUtil.getValueByJsonPath(jsonObj, "/price"));
		System.out.println(TestUtil.getValueByJsonPath(jsonObj, "/shipping"));
		System.out.println(TestUtil.getValueByJsonPath(jsonObj, "/url"));
		//System.out.println(TestUtil.getValueByJsonPath(jsonObj, "/categories"));
		
		Assert.assertEquals(Double.parseDouble(TestUtil.getValueByJsonPath(jsonObj, "/price")), 5.49);
		
		String id=TestUtil.getValueByJsonPath(jsonObj, "/categories[1]/id");
		String name1=TestUtil.getValueByJsonPath(jsonObj, "/categories[1]/name");
		String createdAt=TestUtil.getValueByJsonPath(jsonObj, "/categories[1]/createdAt");
		String updatedAt=TestUtil.getValueByJsonPath(jsonObj, "/categories[1]/updatedAt");
		
	}
	
	
}
