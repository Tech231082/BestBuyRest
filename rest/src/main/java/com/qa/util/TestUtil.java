package com.qa.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestUtil {
	
	public static String getValueByJsonPath(JSONObject json,String jsonPath) {
		
		Object obj=json;
		
		
			for(String s : jsonPath.split("/")) 
				if(!s.isEmpty()) 
					if(!(s.contains("[") || s.contains("]")))
						obj = ((JSONObject) obj).get(s);
					else if(s.contains("[") || s.contains("]"))
						obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
			return obj.toString();
		}
		
	}

