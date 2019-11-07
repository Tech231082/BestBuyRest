package restcom.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.client.RestClient;

public class GetAPITest2 extends BaseClass{
	BaseClass base;
	String baseUrl;
	String serviceUrl1;
	String url;
	RestClient client;
	
	@BeforeMethod
	public void setUp() {
		base=new BaseClass();
		baseUrl=prop.getProperty("baseUrl");
		serviceUrl1=prop.getProperty("serviceUrl1");
		url=baseUrl+serviceUrl1;
		
		
		
	}
	
	@Test
	public void test() throws ClientProtocolException, IOException {
		client=new RestClient();
		client.get2(url);
	}

}
