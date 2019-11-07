package restcom.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.client.RestClient1;

public class GetCall1 extends Base{
	public Base base;
	String url;
	String baseUrl;
	String serviceUrl3;
	RestClient1 client;
	
	@BeforeMethod
	public void setUp() {
		base=new Base();
		baseUrl=prop.getProperty("baseUrl");
		serviceUrl3=prop.getProperty("serviceUrl3");
		url=baseUrl+serviceUrl3;
	}

	
	@Test
	public void test() throws ClientProtocolException, IOException {
		 client=new RestClient1();
		 client.get1(url);
	}
}
