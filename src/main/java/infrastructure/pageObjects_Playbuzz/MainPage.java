package infrastructure.pageObjects_Playbuzz;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage
{

	private static By SEARCH_BAR = By.name("q");
	private static By GOOGLE_SEARCH = By.name("btnK");

	@FindBy(name = "q")
	public WebElement searchBar;

	@FindBy(name = "btnK")
	public WebElement googleSearch;

	public MainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void searchValue(String value){
		searchBar.sendKeys(value);
		googleSearch.click();
	}
}
