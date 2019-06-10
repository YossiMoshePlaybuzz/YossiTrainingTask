package infrastructure.pageObjects_Playbuzz;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SighUpPage
{
	private static By FULL_NAME = By.id("register_name");

	@FindBy(id = "register_name")
	public WebElement fullname;

	@FindBy(xpath = "//form[@id='email_registration_form']/div[1]/div")
	public WebElement fullnameError;
	
	@FindBy(id = "register_email_address")
	public WebElement emailAdress;
	
	@FindBy(id = "register_password")
	public WebElement password;
	
	@FindBy(xpath = "//form[@id='email_registration_form']/div[3]/div")
	public WebElement passwordError;
	
	@FindBy(id = "submit-signup")
	public WebElement createAcount;

	public SighUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String user)  
	{
		//$(FULL_NAME).sendKeys(user);
		fullname.sendKeys(user);
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
}
