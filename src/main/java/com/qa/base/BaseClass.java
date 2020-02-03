package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	public Properties prop;
	public static int status_code_200=200;
	public static int status_code_201=201;
	public static int status_code_400=400;
	public static int status_code_401=401;
	public static int status_code_500=500;
	
	public BaseClass() {
		
		try {
			prop=new Properties();
			FileInputStream fis;
			fis = new FileInputStream("C://Users//parmod.kumar//eclipse-workspace//rest//src//main//java//com//qa//config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
