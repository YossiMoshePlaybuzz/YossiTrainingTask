package infrastructure.pageObjects_Playbuzz;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage
{

	@FindBy(id = "pb-navbar-login-btn")
	public WebElement login;
	
	
	@FindBy(xpath = "//input[@aria-label='search input']")
	public WebElement search;
	
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[1]/div/ul/li[1]")
	public WebElement searchResult;
	
	@FindBy(xpath = "//a[contains(text(), 'Create')]")
	public WebElement create;
	
	@FindBy(linkText = "CAREERS")
	public WebElement careers;

	public MainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void goToSignIn() 
	{
		login.click();
	}
}
