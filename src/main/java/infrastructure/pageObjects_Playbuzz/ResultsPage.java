package infrastructure.pageObjects_Playbuzz;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;


public class ResultsPage
{
    private static By RESULTS = By.name("rc");

	@FindBy(className = "rc")
	private List<WebElement> results;

	public ResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getResultByIndex(int index){
		return //$$(RESULTS).shouldBe(CollectionCondition.sizeGreaterThan(0)).get(index+3);
                results.get(index+3);

	}

	public List<WebElement> getResults(){
		return results;
	}
}
