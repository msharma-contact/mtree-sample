package com.Amazon.qa.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.Amazon.qa.util.HandleEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	

	//Global variables
	public static WebDriver driver; 	
	public static EventFiringWebDriver eDriver;
	public static HandleEvents eListner;
	File file ;
	FileReader fileReader;
	
	public static String url="https://www.amazon.com/";
	
	
	public static void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		eDriver = new EventFiringWebDriver(driver);
		eListner=new HandleEvents();
		eDriver.register(eListner);
		driver=eDriver;
		
		
	}
	
}
