package infrastructure.pageObjects_Playbuzz;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class LoginPage
{

	@FindBy(linkText = "Sign Up")
	public WebElement signup;
	
	@FindBy(id = "elogin_email_field")
	public WebElement email;
	
	@FindBy(id = "elogin_pass_field")
	public WebElement password;
	
	@FindBy(id = "submitLogin")
	public WebElement login;
	
	
	@FindBy(xpath = "//input[@id='elogin_email_field']/../label/span[2]")
	public WebElement validEmail;
	
	@FindBy(xpath = "//span[contains(text(), 'Please enter a password')]")
	public List<WebElement> enterPassword;


	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void login(String user, String pass) 
	{
		login.click();
		email.sendKeys(user);
		password.sendKeys(pass);
		login.click();
	}
}
