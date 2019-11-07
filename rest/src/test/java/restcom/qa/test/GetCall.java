package restcom.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.client.RestClient1;

public class GetCall extends Base{
	public Base base;
	RestClient1 client;
	String baseUrl;
	String serviceUrl2;
	String url;
	
	@BeforeMethod
	public void setUp() {
		base=new Base();
		baseUrl=prop.getProperty("baseUrl");
		serviceUrl2=prop.getProperty("serviceUrl2");
		url=baseUrl+serviceUrl2;
	}
	
	@Test
	public void test() throws ClientProtocolException, IOException {
		client=new RestClient1();
		client.get(url);
		
	}

}
