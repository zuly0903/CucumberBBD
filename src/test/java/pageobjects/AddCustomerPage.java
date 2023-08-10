package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitHelper;

public class AddCustomerPage {

	public WebDriver driver;
	WaitHelper wt;
	
	public AddCustomerPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	private WebElement CustomerMenu;
	
	@FindBy(xpath = "//body/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]")
	private WebElement Customers;
	
	@FindBy(css = "a.btn.btn-primary")
	private WebElement AddNewButton;
	
	@FindBy(id = "Email")
	private WebElement Email;
	
	@FindBy(id = "Password")
	private WebElement Password;
	
	@FindBy(id = "FirstName")
	private WebElement FirstName;
	
	@FindBy(id = "LastName")
	private WebElement LastName;
	
	@FindBy(id = "Gender_Male")
	private WebElement GenderMale;
	
	@FindBy(id = "Gender_Female")
	private WebElement GenderFemale;
	
	@FindBy(id = "DateOfBirth")
	private WebElement DateofBirth;
	
	@FindBy(xpath= "//ul[@id='SelectedCustomerRoleIds_taglist']")
	private WebElement CustomerRoles;
	
	@FindBy(xpath = "//li[contains(text(),'Administrators')]")
	private WebElement Adimin;
	
	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	private WebElement Guest;
	
	@FindBy(xpath = "//li[contains(text(),'Forum Moderators')]")
	private WebElement Forum;
	
	@FindBy(xpath = "//li[contains(text(),'Registered')]")
	private WebElement Registered;
	
	@FindBy(xpath = "//li[contains(text(),'Vendors')]")
	private WebElement Vendor;
	
	@FindBy(id = "VendorId")
	private WebElement ManagerOfVendor;
	
	@FindBy(name = "save")
	private WebElement SaveButton;
	
	@FindBy(id = "Company")
	private WebElement CompanyName;
	
	public void ClickCustomerMenu()
	{
		CustomerMenu.click();
	}
	
	public void ClickSubCustomerMenu()
	{
		Customers.click();
	}
	
	public void ClickAddNew()
	{
		AddNewButton.click();
	}
	
	public void EnterEmail(String email)
	{
		Email.sendKeys(email);
	}
	
	public void EnterPassword(String password)
	{
		Password.sendKeys(password);
	}
	
	public void EnterFName(String fname)
	{
		FirstName.sendKeys(fname);
	}
	
	public void EnterLastName(String lname) 
	{
		LastName.sendKeys(lname);
	}
	
	public void SelectGender(String gender)
	{
		if(gender.equals("Male"))
		{
			GenderMale.click();
		}else
		{
			GenderFemale.click();
		}
	}
	
	public void EnterDOB(String value)
	{
		DateofBirth.sendKeys(value);
	}
	
	public void SetRole(String role) throws InterruptedException
	{
		if(!role.equals("Vendors"))
		{
			driver.findElement(By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/li/span[2]")).click();
		}
		
	    driver.findElement(By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']")).click();
		wt = new WaitHelper(driver);
		wt.WaitForElement(Guest, Duration.ofSeconds(10));
		Guest.click();
//		driver.findElement(By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).click();
//		WebElement listitem = null;
//		Thread.sleep(3000);
//		
//		//Guest.click();
//		
//		if(role.equals("Administrators")) {
//			listitem = Adimin;
//		}else if(role.equals("Guests")) {
//			listitem = Guest;
//		}else if (role.equals("Forum Moderators")) {
//			listitem = Forum;
//		}else if(role.equals("Registered")) {
//			listitem =Registered;
//		}else {
//			listitem =Vendor;
//		}
//		listitem.click();
//		Thread.sleep(3000);
	}
	
	public void SetVendor(String value)
	{
		Select drp = new Select(ManagerOfVendor);
		drp.selectByVisibleText(value);
	}
	
	public void ClickSaveBTN()
	{
		SaveButton.click();
	}
	
	public void setCompanyName(String cname)
	{
		CompanyName.sendKeys(cname);
	}
}
