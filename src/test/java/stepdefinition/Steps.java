package stepdefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AddCustomerPage;
import pageobjects.LoginPage;
import pageobjects.SearchCustomer;

public class Steps extends BaseClass{

	@Before
	public void SetUp() throws IOException
	{
		pt = new Properties();
		FileInputStream ip = new FileInputStream("config.properties");
		pt.load(ip);
		
		logger = Logger.getLogger("CucumberBBD");
		PropertyConfigurator.configure("log4j.properties");
		
		String br = pt.getProperty("browser");
		if(br.equals("chrome"))
		{	
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--disable-notification");
			driver = new ChromeDriver(op);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		else
		{
			driver = new FirefoxDriver();
		}
	}
	
	@After(order = 1)
	public void takeScreenShotOnFailure(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "screenshot");
		}
	}
	
	@After(order = 0)
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Given("User lanuch chrome browser")
	public void user_lanuch_chrome_browser() {
		logger.info("**********Launching Browser**********");
	    lp = new LoginPage(driver);
	}

	@When("User open URL {string}")
	public void user_open_url(String url) {
		logger.info("**********Launching URL**********");
	    driver.get(url);
	}

	@When("User enters email as {string}")
	public void user_enters_email_as(String email) {
		logger.info("**********Entering Email**********");
	    lp.EnterEmail(email);
	}

	@When("User enters password as {string}")
	public void user_enters_password_as(String password) {
	   logger.info("**********Entering Password**********");
	   lp.EnterPassword(password);
	}

	@When("User click login button")
	public void user_click_login_button() {
		logger.info("**********Login**********");
	    lp.ClickLogin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		logger.info("**********Veryfing Title**********");
	    Assert.assertEquals(title, lp.PageTitle());
	}

	@When("user click on logout button")
	public void user_click_on_logout_button() {
		logger.info("**********Logout**********");
	   lp.ClickLogout();
	}

	@Then("Close the browser")
	public void close_the_browser() {
		logger.info("**********Closing Browser**********");
	    driver.quit();
	}
	
	//Add Customer

	@When("User click on customers menu")
	public void user_click_on_customers_menu() {
	    addcust = new AddCustomerPage(driver);
	    logger.info("**********Click Menu**********");
	    addcust.ClickCustomerMenu();
	}
	
	@When("User click on sub customers menu")
	public void user_click_on_sub_customers_menu() {
		logger.info("**********Click Customer Menu**********");
		addcust.ClickSubCustomerMenu();
	}
	
	@When("User click on Add new button")
	public void user_click_on_add_new_button() {
		logger.info("**********Click Add New Button**********");
		addcust.ClickAddNew();
	}
	
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		logger.info("**********Entering Customer Info**********");
		String email = randomstring()+"@gmail.com";
		addcust.EnterEmail(email);
		addcust.EnterPassword("admin123");
		addcust.EnterFName("Zuly");
		addcust.EnterLastName("S");
		addcust.SelectGender("Female");
		addcust.EnterDOB("01/23/2000");
		addcust.setCompanyName("LX");
		addcust.SetRole("Guests");
		addcust.SetVendor("Vendor 1");
	}
	
	@When("User click on save button")
	public void user_click_on_save_button() {
		logger.info("**********Click Save Button**********");
		addcust.ClickSaveBTN();
	}
	
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		logger.info("**********Veryfing Confirmation Message**********");
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
	}
	
	
	// Search Customer
	@When("User enter customer email")
	public void user_enter_customer_email() {
		logger.info("**********Enter Email To Search**********");
	    sc = new SearchCustomer(driver);
	    sc.EnterEmail("victoria_victoria@nopCommerce.com");
	}
	
	@When("User click on search button")
	public void user_click_on_search_button() throws InterruptedException {
		logger.info("**********Click Search Button**********");
	    sc.ClickSearchButton();
	    Thread.sleep(3000);
	}
	
	
	@Then("User should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
		logger.info("**********Veryfing Email Present In The Search Table**********");
	    boolean status = sc.SearchCustByEmail("victoria_victoria@nopCommerce.com");
	    Assert.assertTrue(status);
	}
	
	//Search by name
	@When("User enter customer First Name")
	public void user_enter_customer_first_name() {
		logger.info("**********Enter Name To Search**********");
	   sc = new SearchCustomer(driver);
	   sc.EnterFname("Victoria");
	}
	
	@When("User enter customer Last Name")
	public void user_enter_customer_last_name() {
		logger.info("**********Enter Name To Search**********");
	   sc.EnterLname("Terces");
	}
	
	@Then("User should found name in the search table")
	public void user_should_found_name_in_the_search_table() {
		logger.info("**********Veryfing Name Present In The Search Table**********");
	    boolean status = sc.SearchCustByName("Victoria Terces");
	    Assert.assertTrue(status);
	}


}
