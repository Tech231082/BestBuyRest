package restcom.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.client.RestClient;

public class GetAPITest extends BaseClass{
	BaseClass base;
	String baseurl;
	String serviceurl;
	String url;
	RestClient cl;
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		base=new BaseClass();
		 baseurl=prop.getProperty("baseUrl");
		 serviceurl=prop.getProperty("serviceUrl");
		url=baseurl+serviceurl;
		
		
	}
	
	@Test
	public void test() throws ClientProtocolException, IOException {
		RestClient cl=new RestClient();
		cl.get(url);
	}

}
