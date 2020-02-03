package restcom.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.client.RestClient1;

public class GetAPITestStores extends Base {
	
	String url;
	String baseUrl;
	String serviceUrlStores;
	RestClient1 client;
	Base base;
	
	@BeforeMethod
	public void setUp() {
		base=new Base();
		baseUrl=prop.getProperty("baseUrl");
		serviceUrlStores=prop.getProperty("serviceUrlStores");
		url=baseUrl+serviceUrlStores;
	}
	
	@Test
	public void test() throws ClientProtocolException, IOException {
		client=new RestClient1();
		client.getStores(url);
	}

}
