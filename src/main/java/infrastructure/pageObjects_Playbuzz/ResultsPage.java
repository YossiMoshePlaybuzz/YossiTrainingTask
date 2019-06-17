package infrastructure.pageObjects_Playbuzz;


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

	public ResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

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
