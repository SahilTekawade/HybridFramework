package com.visionit.freecrm.hybridframework.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.visionit.freecrm.com.visionit.freecrm.testbase.BaseClass;
import com.visionit.freecrm.pageobject.LoginPage;
import com.visionit.freecrm.pageobject.SignUpPage;

public class SignUpPageTC extends BaseClass{

	LoginPage login;
	SignUpPage signUp;

	@BeforeMethod
	public void setUp() {

		browserStartUp(configDataProvider.getConfigProperties("chBrowser"),
				configDataProvider.getConfigProperties("url"));
		login = new LoginPage(driver);
		signUp = login.navigateToCreateAnAccountPage();
	}

	/*
	 * @Test public void createAnFreeCrmProAccountTest() {
	 * signUp.createAnFreeCrmProAccount("Mayuri", "Deshmukh",
	 * "mayurimaratha257@gmail.com", "mayurimaratha257@gmail.com", "Mayuri_257",
	 * "mayuri$257", "mayuri$257", "VisionIt","7790775996","Hello Am coming",
	 * "VisionIt Tech");
	 * 
	 * }
	 */
	@Test(dataProvider = "getExcelData")
	public void createAnFreeCrmProAccountTest(String ddValue, String fname, String lname, String email, String confirmEmail,
			String unameField, String upassField, String confirmUserpass, String company, String phone, String desText,
			String addText, String countryDD) {

		signUp.createAnFreeCrmProAccount(ddValue, fname, lname, email, confirmEmail, unameField, upassField, confirmUserpass,
				company, phone, desText, addText, countryDD);
	}
	
	/*@DataProvider
	public Object[][] dataProviderTest() {

		Object[][] testdata = new Object[1][11];

		testdata[0][0] = "Mayuri";
		testdata[0][1] = "Deshmukh";
		testdata[0][2] = "mayurimaratha257@gmail.com";
		testdata[0][3] = "mayurimaratha257@gmail.com";
		testdata[0][4] = "Mayuresh_257";
		testdata[0][5] = "mayuri$257";
		testdata[0][6] = "mayuri$257";
		testdata[0][7] = "VisionIt";
		testdata[0][8] = "9876543210";
		testdata[0][9] = "Hello Am coming";
		testdata[0][10] = "VisionIt Tech";

		return testdata;
	}*/
	@DataProvider
	public Object [][] getExcelData(){
		
		Object[][] data = excelDataProvider.getExcelData("Sheet1");

		return data;
	}
}