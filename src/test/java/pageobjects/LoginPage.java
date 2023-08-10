package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "Email")
	private WebElement EmailField;
	
	@FindBy(id = "Password")
	private WebElement PasswordField;
	
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement Loginbtn;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement Logoutbtn;
	
	public void EnterEmail(String email)
	{
		EmailField.clear();
		EmailField.sendKeys(email);
	}
	
	public void EnterPassword(String password)
	{
		PasswordField.clear();
		PasswordField.sendKeys(password);
	}
	
	public void ClickLogin()
	{
		Loginbtn.click();
	}
	
	public void ClickLogout()
	{
		Logoutbtn.click();
	}
	
	public String PageTitle()
	{
		String title = driver.getTitle();
		return title;
	}

}
