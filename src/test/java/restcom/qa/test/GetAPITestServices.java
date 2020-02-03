package restcom.qa.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.client.RestClient1;
import com.qa.util.TestUtil;

public class GetAPITestServices extends Base{
	Base base;
	String url;
	String baseUrl;
	String serviceUrlID;
	RestClient1 client;
	CloseableHttpResponse response;
	
	@BeforeMethod
	public void setUp() {
		base=new Base();
		baseUrl=prop.getProperty("baseUrl");
		serviceUrlID=prop.getProperty("serviceUrlID");
		url=baseUrl+serviceUrlID;
	}
	
	@Test
	public void test() throws ClientProtocolException, IOException {
		client=new RestClient1();
		response=client.getServices(url);
		
		Header []headers=response.getAllHeaders();
		HashMap<String,String> headerMap=new HashMap<String,String>();
		for(Header header:headers) {
			headerMap.put(header.getName(), header.getValue());
		}
		
		System.out.println(headerMap);
		
		String responseString=EntityUtils.toString(response.getEntity(), "UTF-8");
		
		JSONObject jsonResponse=new JSONObject(responseString);
		
		String s=TestUtil.getValueByJsonPath(jsonResponse,"/id");
		
		
		System.out.println(s);
		
		System.out.println(TestUtil.getValueByJsonPath(jsonResponse,"/name"));
		
		System.out.println(TestUtil.getValueByJsonPath(jsonResponse,"/createdAt"));
		System.out.println(TestUtil.getValueByJsonPath(jsonResponse,"/updatedAt"));
		
		//createdAt
	}

}
