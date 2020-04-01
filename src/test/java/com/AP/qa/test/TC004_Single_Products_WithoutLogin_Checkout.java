package com.AP.qa.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.AP.qa.base.TestBase;
import com.AP.qa.pages.Login;
import com.AP.qa.pages.Logout;
import com.AP.qa.pages.Payment;
import com.AP.qa.pages.homepage;

public class TC004_Single_Products_WithoutLogin_Checkout extends TestBase{

	Login login;
	homepage home;
	Payment pay;
	Logout logout;
	

	@Parameters("Browser")
	@BeforeTest
	public void init(String Browser) throws Throwable{
		initialization(Browser);
	}
	
	@BeforeClass
	public void Setup() throws Throwable {
		SetUP("Automation_Practice", driver.getTitle());
		login = new Login();
		home = new homepage();
		pay = new Payment();
		logout = new Logout();
	}
	
	
	@Test(priority = 1, enabled = true)
	void BookingTest() throws Throwable{
		home.order_product();
	}
	

	@Test(priority = 2, enabled = true, dependsOnMethods = "BookingTest")
	void PaymentTest() throws Throwable{
		pay.paymentpage();	
		
	}
	
	@AfterClass
	public void Flush() throws Throwable
	{
		logout.LogoutTest();	
	}
	
	@AfterTest
	public void CloseBrowser() {
		closeBrowser();
	}
}