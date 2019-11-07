package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	//get method
	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpGet get=new HttpGet(url);//httpget request
		CloseableHttpResponse response=httpclient.execute(get);
		int code=response.getStatusLine().getStatusCode();
		System.out.println("Status code : "+code);
		
		String respString=EntityUtils.toString(response.getEntity(),"UTF-8");
		JSONObject json=new JSONObject(respString);
		System.out.println("Response in json : "+json);
		
		Header[] headers=response.getAllHeaders();
		
		HashMap<String,String> map=new HashMap<String,String>();
		
		for(Header header:headers) {
			map.put(header.getName(), header.getValue());
		}
		System.out.println("Headers are :  "+map);
		
	}
	
	//post
	public CloseableHttpResponse post(String url,String payload,HashMap<String,String> headerMap) throws ClientProtocolException, IOException {
		//creating the connection
		CloseableHttpClient httpclient=HttpClients.createDefault();
		
		//making a post call
		HttpPost httppost=new HttpPost(url);
		//sending json payload
		httppost.setEntity(new StringEntity(payload));
		
		//sending the headers
		HashMap<String,String> map=new HashMap<String,String>();
		
		for(Entry<String,String> entry: headerMap.entrySet()) {
			httppost.addHeader(entry.getKey(), entry.getValue());
		}
		
		CloseableHttpResponse response=httpclient.execute(httppost);
		
		return response;
		
	}
	public void get1(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpGet=HttpClients.createDefault();
		HttpGet get=new HttpGet(url);
		CloseableHttpResponse respo=httpGet.execute(get);
		
		int code=respo.getStatusLine().getStatusCode();
		
		System.out.println(code);
		
		String responseString=EntityUtils.toString(respo.getEntity(),"UTF-8");
		
		JSONObject jsonR=new JSONObject(responseString);
		
		System.out.println(jsonR);
		
		Header[] header=respo.getAllHeaders();
		HashMap<String,String> headerMap=new HashMap<String,String>();
		
		for(Header headers :header) {
			headerMap.put(headers.getName(), headers.getValue());
		}
		
		System.out.println(headerMap);
		
	}
	
	public void get2(String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpGet get=new HttpGet(url);
		CloseableHttpResponse response=httpclient.execute(get);
		
		System.out.println(response.getStatusLine().getStatusCode());
		
		String stringRespo=EntityUtils.toString(response.getEntity(), "UTF-8");
		JSONObject jsonO=new JSONObject(stringRespo);
		
		Header [] headers=response.getAllHeaders();
		HashMap<String,String> headerMap=new HashMap<String,String>();
		
		for(Header header:headers) {
			headerMap.put(header.getName(), header.getValue());
			
		}
		
		System.out.println("Header Map is  "+headerMap);
		
	}

}
