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
	public static By LINKED_URL = By.className("TbwUpd");
	public static By DESCRIPTION = By.className("st");
	@FindBy(className = "rc")
	private List<WebElement> results;
	private WebDriver driver = null;
	ResultSection[] resultSections = new ResultSection[9];


	public ResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public ResultSection getResult(int index){
		if(resultSections[index] != null){
			ResultSection result = new ResultSection(index,driver);
			resultSections[index] = result;
		}
		return resultSections[index];
	}

	public WebElement getResultByIndex(int index){
		return results.get(index);
	}

	public String getUrlByResultIndex(int index){
		return $(getResultByIndex(index)).find(LINKED_URL).getText();
	}

	public void clickOnUrlByResultIndex(int index){
		$(getResultByIndex(index)).find(LINKED_URL).click();
	}

	public String getDescriptionByResultIndex(int index){
		return $(getResultByIndex(index)).find(DESCRIPTION).getText();
	}

	public int getResultsSize(){
		return results.size();
	}
}
