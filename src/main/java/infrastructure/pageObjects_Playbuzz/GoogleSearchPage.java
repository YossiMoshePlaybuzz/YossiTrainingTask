package infrastructure.pageObjects_Playbuzz;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.fail;

public class GoogleSearchPage extends LoadableComponent <GoogleSearchPage>
{
	WebDriver driver = null;
	public static By SEARCH_BAR = By.name("q");

	@FindBy(name = "q")
	public WebElement searchBar;

	@FindBy(name = "btnK")
	public WebElement googleSearch;

	public GoogleSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void searchValue(String value){
		searchBar.sendKeys(value);
		googleSearch.click();
	}

	@Override
	protected void load() {
		driver.get(System.getProperty("url"));
	}

	@Override
	protected void isLoaded() throws Error {
		try{
			$(SEARCH_BAR).getWrappedElement().isDisplayed();
		}
		 catch (NoSuchElementException e){
			fail("Failed to load");
		 }
	}
}
