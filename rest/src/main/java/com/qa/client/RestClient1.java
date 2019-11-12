package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;

import com.qa.base.Base;
import com.qa.data.UserCategories;

public class RestClient1 extends Base{
	//get method
	public void get(String url) throws ClientProtocolException, IOException {
		//creating the httpclient
		CloseableHttpClient httpclient=HttpClients.createDefault();
		//craeting a http request
		HttpGet get=new HttpGet(url);
		//executing the request
		CloseableHttpResponse response=httpclient.execute(get);
		
		int code=response.getStatusLine().getStatusCode();
		System.out.println(code);
		
		Assert.assertEquals(code, Base.status_code_200);
		
		//string response
		String responseString=EntityUtils.toString(response.getEntity());
		//convert to json
		JSONObject json=new JSONObject(responseString);
		
		System.out.println("string response is " +responseString);
		
		//getting headers
		Header []headers=response.getAllHeaders();
		//printing number of headers
		System.out.println("Numbers of headers are : "+headers.length);
		HashMap<String,String> headerMap=new HashMap<String,String>();
		
		//putting the headers in headerMap
		for(Header header:headers) {
			headerMap.put(header.getName(), header.getValue());
			
		}
		System.out.println("Headers are  "+headerMap);
		
	}
	
	public void get1(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient=HttpClients.createDefault(); 
		
		HttpGet get=new HttpGet(url);
		
		CloseableHttpResponse response=httpclient.execute(get);
		System.out.println(response);
		
		
		String stringResponse=EntityUtils.toString(response.getEntity(), "UTF-8");
		
		System.out.println(stringResponse);
		
		boolean resp=response.getEntity().getContent().equals("abcat0010000");
		System.out.println(resp);
		
		
		Header []headers=response.getAllHeaders();
		
		HashMap<String,String> headerMap=new HashMap<String,String>();
		
		for(Header header:headers) {
			headerMap.put(header.getName(), header.getValue());
		}
		
		System.out.println("Headers are :  "+headerMap);
		
	}
	
	public void getStores(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient=HttpClients.createDefault();//create httpclient
		
		HttpGet get=new HttpGet(url);//get request
		
		CloseableHttpResponse response=httpclient.execute(get);//executing get request
		
		System.out.println("API Response is ---  "+response);
		
		int code=response.getStatusLine().getStatusCode();
		System.out.println(code);
		
		Assert.assertEquals(code, Base.status_code_200,"Status code is not 200");
		
		Header []headers=response.getAllHeaders();
		HashMap<String,String> headerMap=new HashMap<String,String>();
		
		for(Header header:headers) {
			headerMap.put(header.getName(), header.getValue());
		}
		
		System.out.println("headers are "+headerMap);
		
		
		String responseString=EntityUtils.toString(response.getEntity(), "UTF-8");
		
		System.out.println("String Response   "+responseString);
		
		JSONObject json=new JSONObject(responseString);
		
		System.out.println("json response is :   "+json);
		
	}
	
	public CloseableHttpResponse getServices(String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		HttpGet get=new HttpGet(url);
		
		CloseableHttpResponse response=httpclient.execute(get);
		
		return response;
	}
	//without headers
	public CloseableHttpResponse getProductsID(String url) throws ClientProtocolException, IOException {
		
       CloseableHttpClient httpclient=HttpClients.createDefault();
       HttpGet  get=new HttpGet(url);
		CloseableHttpResponse response=httpclient.execute(get);
		
		return response;
		
	}
	
	//get call with headers
	public CloseableHttpResponse getProductsIDWithHeaders(String url,HashMap<String,String> headerMap) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpclient=HttpClients.createDefault();
	       HttpGet  get=new HttpGet(url);
	       for(Entry<String, String> entry:headerMap.entrySet()) {
	    	   get.addHeader(entry.getKey(), entry.getValue());
	       }
			CloseableHttpResponse response=httpclient.execute(get);
			
			return response;
		
	}
	
	public CloseableHttpResponse getProducts(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpGet get=new HttpGet(url);
		CloseableHttpResponse response=httpclient.execute(get);
		return response;
	}
	
	public CloseableHttpResponse deleteId(String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		HttpDelete del=new HttpDelete(url);
		
		CloseableHttpResponse response=httpclient.execute(del);
		
		return response;
		
	}
	
	//with headers
	public CloseableHttpResponse deleteStoresID(String url,HashMap<String,String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		
			
		HttpDelete del=new HttpDelete(url);
		
		for(Entry<String,String> entry:headerMap.entrySet()) {
			del.addHeader(entry.getKey(), entry.getValue());
		}
		
		
		
		
		CloseableHttpResponse response=httpclient.execute(del);
		
		return response;
	}
	
	//with headers
	public CloseableHttpResponse deleteCatogoriesIDWithHeaders(String url,HashMap<String,String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		HttpDelete del=new HttpDelete(url);//del request
		
		for(Entry<String,String> entry:headerMap.entrySet()) {
			del.addHeader(entry.getKey(), entry.getValue());
		}
		
		CloseableHttpResponse response=httpclient.execute(del);
		
		return response;
		
	}
	
	public CloseableHttpResponse post(String url,String entityString,HashMap<String,String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		HttpPost post=new HttpPost(url);//post request
		
		post.setEntity(new StringEntity(entityString));//payload
		
		//headers
		for(Entry<String,String> entry:headerMap.entrySet()) {
			post.addHeader(entry.getKey(), entry.getValue());
		}
		
		CloseableHttpResponse response=httpclient.execute(post);
		
		return response;
		
		
	}
	
	public CloseableHttpResponse postServices(String url,String entityString,HashMap<String,String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		HttpPost post=new HttpPost(url);
		
		post.setEntity(new StringEntity(entityString));
		
		for(Entry<String, String> entry:headerMap.entrySet()) {
			post.addHeader(entry.getKey(),entry.getValue());
		}
		
		CloseableHttpResponse response=httpclient.execute(post);
		
		
		return response;
		
	}
	
	public CloseableHttpResponse patchservices(String url,String entityString,HashMap<String,String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		HttpPatch patch=new HttpPatch(url);
		
		patch.setEntity(new StringEntity(entityString));
		
		for(Entry<String,String> entry:headerMap.entrySet()) {
			patch.addHeader(entry.getKey(),entry.getValue());
		}
		
		CloseableHttpResponse response=httpclient.execute(patch);
		return response;
	}
	
	public CloseableHttpResponse patchCategoriesID(String url,String entityString,HashMap<String,String> headerMap) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		HttpPatch patch=new HttpPatch(url);
		
		patch.setEntity(new StringEntity(entityString));
				
		
		//headerMap
		for(Entry<String,String> entry:headerMap.entrySet()) {
			patch.addHeader(entry.getKey(),entry.getValue());
		}
		
		CloseableHttpResponse response=httpclient.execute(patch);
		return response;
		
	}
	
	public CloseableHttpResponse patchCategoriesID1(String url,String entityString,HashMap<String,String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpPatch patch=new HttpPatch(url);
		
		patch.setEntity(new StringEntity(entityString));
		
		for(Entry<String,String> entry:headerMap.entrySet()){
			
			patch.addHeader(entry.getKey(), entry.getValue());
			
		}
		
		CloseableHttpResponse response=httpclient.execute(patch);
		return response;
	}
	

}
