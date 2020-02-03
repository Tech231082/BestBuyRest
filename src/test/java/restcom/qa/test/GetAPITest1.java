package restcom.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.client.RestClient;

public class GetAPITest1 extends BaseClass{
	BaseClass base;
	String baseUrl;
	String serviceUrl;
	String url;
	RestClient client;
	
	
	@BeforeMethod
	public void setUp() {
		base=new BaseClass();
		baseUrl=prop.getProperty("baseUrl");
		serviceUrl=prop.getProperty("serviceUrl");
		url=baseUrl+serviceUrl;
	}

	@Test
	public void test() throws ClientProtocolException, IOException {
		client=new RestClient();
		client.get1(url);
	}

}
