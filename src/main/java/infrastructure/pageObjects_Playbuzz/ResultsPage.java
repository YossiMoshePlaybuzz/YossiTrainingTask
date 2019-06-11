package infrastructure.pageObjects_Playbuzz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ResultsPage
{
    private static By RESULTS = By.name("rc");

	@FindBy(className = "rc")
	private List<WebElement> results;

	public ResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getResultByIndex(int index){
		return results.get(index+3);
	}

	public List<WebElement> getResults(){
		return results;
	}
}
