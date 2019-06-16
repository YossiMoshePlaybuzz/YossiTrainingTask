package infrastructure.pageObjects_Playbuzz;

import infrastructure.pageObjects_Playbuzz.resultSection.ResultSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class ResultsPage
{
    private static By RESULTS = By.name("rc");
	ResultSection GoogleResultSection;

	@FindBy(className = "rc")
	private List<WebElement> results;

	public ResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		GoogleResultSection = new ResultSection(driver);
	}

	public WebElement getResultByIndex(int index){
		return results.get(index);
	}

	public String getUrlByResultIndex(int index){
		return $(getResultByIndex(index)).find(GoogleResultSection.LINKED_URL).getText();
	}

	public List<WebElement> getResults(){
		return results;
	}
}
