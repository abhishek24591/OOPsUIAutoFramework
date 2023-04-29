/**
 * 
 */
package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author abhishekdeshmukh
 *
 */
public class HomePage extends BasePage{
	
	private By header = By.xpath("//label[text()='Enter code']");

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getHeader() {
		return getElement(header);
	}

	public String getHomePageTitle() {
		return getPageTitle();
	}

	public String getHomePageHeader() {
		return getPageHeader(header);
	}

}
