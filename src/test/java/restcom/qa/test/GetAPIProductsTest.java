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

public class GetAPIProductsTest  extends Base{
	Base base;
	RestClient1 client;
	String url;
	String baseUrl;
	String serviceUrl;
	CloseableHttpResponse response;
	
	@BeforeMethod
	public void setUp() {
		base=new Base();
		baseUrl=prop.getProperty("baseUrl");
		serviceUrl=prop.getProperty("serviceUrl");
		url=baseUrl+serviceUrl;
		
	}
	@Test
	public void getAPIProductsTest() throws ClientProtocolException, IOException {
		client=new RestClient1();
		response=client.getProducts(url);
		
		String responseString=EntityUtils.toString(response.getEntity(), "UTF-8");
		JSONObject json=new JSONObject(responseString);
		
		System.out.println("Response of API in JSON form is   "+json);
		
		Header []headers=response.getAllHeaders();
		
		HashMap<String,String> headerMap=new HashMap<String,String>();
		
		for(Header header:headers) {
			headerMap.put(header.getName(), header.getValue());
		}
		
		System.out.println("Headers array is   "+headerMap);
		
		String total=TestUtil.getValueByJsonPath(json, "/total");
		
		System.out.println("Total :- "+total);
		Assert.assertEquals(Integer.parseInt(total), 51968);
		
		String skip=TestUtil.getValueByJsonPath(json, "/skip");
		
		String limit=TestUtil.getValueByJsonPath(json, "/limit");
		
		System.out.println("Skip :- "+skip);
		System.out.println("Limit :- "+limit);
		
		//json-array
		System.out.println(TestUtil.getValueByJsonPath(json, "/data[0]/categories[0]/id"));
		
		
	}

}
