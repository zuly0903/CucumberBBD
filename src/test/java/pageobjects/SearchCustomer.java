package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomer {

	public WebDriver driver;
	WaitHelper wh;
	
	public SearchCustomer(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='SearchEmail']")
	private WebElement Searchemail;
	
	@FindBy(xpath = "//input[@id='SearchFirstName']")
	private WebElement Searchfirstname;
	
	@FindBy(xpath = "//input[@id='SearchLastName']")
	private WebElement Searchlastname;
	
	@FindBy(id = "SearchMonthOfBirth")
	private WebElement Month;
	
	@FindBy(id = "SearchDayOfBirth")
	private WebElement Day;
	
	@FindBy(xpath = "//button[@id='search-customers']")
	private WebElement SearchBtn;
	
	@FindBy(xpath = "//table[@id='customers-grid']")
	private WebElement Table;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	private List<WebElement> TableRows;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
	private List<WebElement> TableColumns;
	
	public void EnterEmail(String email)
	{
		wh = new WaitHelper(driver);
		wh.WaitForElement(Searchemail, Duration.ofSeconds(10));
		Searchemail.sendKeys(email);
	}
	
	public void EnterFname(String fname)
	{
		wh.WaitForElement(Searchfirstname, Duration.ofSeconds(10));
		Searchfirstname.sendKeys(fname);
	}
	
	public void EnterLname(String lname)
	{
		wh.WaitForElement(Searchlastname, Duration.ofSeconds(10));
		Searchlastname.sendKeys(lname);
	}
	
	public void ClickSearchButton()
	{
		SearchBtn.click();
	}
	
	public int GetNoOfRows()
	{
		return(TableRows.size());
	}
	
	public int GetNoOfColums()
	{
		return(TableColumns.size());
	}
	
	public boolean SearchCustByEmail(String email)
	{
		boolean flag = false;
		for(int i = 1; i <= GetNoOfRows(); i++)
		{
			String emailid = Table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailid);
			
			if(emailid.equals("victoria_victoria@nopCommerce.com"))
			{
				flag = true;
			}
		}
		
		return flag;
	}
	
	public boolean SearchCustByName(String name)
	{
		boolean flag = false;
		for(int i = 1; i <= GetNoOfRows(); i++)
		{
			String fullname = Table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
			String names[] = fullname.split(" ");
			if(names[0].equals("Victoria") && names[1].equals("Terces"))
			{
				flag = true;
			}
		}
		return flag;
	}
}
