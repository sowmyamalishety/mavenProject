package com.Testscenrios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Objectrepository.Locaters;
import com.Utilities.CommonFunctions;
import com.Utilities.StaticVaraibles;

public class FB_login extends StaticVaraibles {
	// Create an object reference of Class
	// ClassName refrenceName = new Classname();
	CommonFunctions cfn = new CommonFunctions();
	Locaters obj = new Locaters();

	@Test
	public void f() throws Exception {
		// Get the value/input data from properties file create object
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream(".\\testdata\\testData.properties");
		p.load(fi);
 
		// open browser
//		cfn.chromeBrowserLaunch();
		cfn.ieBrowserLaunch();
		// type URL, UN, PWD
		cfn.typeURL(p.getProperty("FB_URL"));
		cfn.sendKeysByAnyLocater(obj.email_Editbox, p.getProperty("Email"));
		cfn.sendKeysByAnyLocater(obj.password_Editbox, p.getProperty("Password"));
		// Click on Login button
		cfn.clickByAnyLocater(obj.login_Button);

	}
}
