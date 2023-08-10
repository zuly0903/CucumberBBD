package stepdefinition;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageobjects.AddCustomerPage;
import pageobjects.LoginPage;
import pageobjects.SearchCustomer;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addcust;
	public SearchCustomer sc;
	public static Logger logger;
	public Properties pt;
	
	
	public static String randomstring()
	{
		String st = RandomStringUtils.randomAlphabetic(5);
		return st;
	}

}
