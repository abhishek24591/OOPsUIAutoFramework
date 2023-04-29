/**
 * 
 */
package com.MyTests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypages.HomePage;
import com.mypages.LoginPage;

/**
 * @author abhishekdeshmukh
 *
 */
public class LoginTest extends BaseTest {
	
	@Test(priority = 1,enabled=true)
	public void verifyLoginPageTitleTest() {
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		AssertJUnit.assertEquals(title,"HubSpot Login");
		System.out.println("Test cases 1 ended");
	}

	@Test(priority = 2,enabled=true)
	public void verifyLoginPageHeader() {
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(header);
		AssertJUnit.assertEquals(header,"Don't have an account?");
		System.out.println("Test cases 2 ended");
	}
	
	@Test(priority = 3)
	public void doLoginTest() {
		HomePage homepage = page.getInstance(LoginPage.class).doLogin("abhishek.v.deshmukh24@gmail.com","Srt200go@"); 
		String homePageHeader = homepage.getHomePageHeader();
		System.out.println(homePageHeader);
		AssertJUnit.assertEquals(homePageHeader, "Enter code");
		System.out.println("Test cases 3 ended");
	}
}
