package com.Testscenrios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Objectrepository.Locaters;
import com.Utilities.CommonFunctions;
import com.Utilities.StaticVaraibles;

public class Toyoto_carsTest extends StaticVaraibles{

	CommonFunctions cfn = new CommonFunctions();
	Locaters obj=new Locaters();

	@Test
	public void f() throws IOException {
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream(".\\testdata\\testData.properties");
		p.load(fi);
		//cfn.chromeBrowserLaunch();
		
		
		System.setProperty("webdriver.gecko.driver", "./browserDrivers/geckodriver.exe");
		driver = new FirefoxDriver();
		
		cfn.typeURL("https://www.toyota.co.uk/#/iframe/https%3a%2f%2fforms.toyota.co.uk%2fbrochure");
		cfn.IframeCount();
		//cfn.iFrameByIndex(0);
		cfn.iFrameLoop(obj.Download_RadioButton);
		
		cfn.clickByAnyLocater(obj.Download_RadioButton);

	}
}
