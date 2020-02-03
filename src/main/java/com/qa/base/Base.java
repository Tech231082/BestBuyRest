package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
	
     public Properties prop;
     
     public static int status_code_200=200;
     public static int status_code_201=201;
     public static int status_code_400=400;
     public static int status_code_500=500;
     public static int status_code_404=404;
     
     public Base() {
    	 FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//qa//config//config.properties");
			prop=new Properties();
	    	 prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
     }

}
