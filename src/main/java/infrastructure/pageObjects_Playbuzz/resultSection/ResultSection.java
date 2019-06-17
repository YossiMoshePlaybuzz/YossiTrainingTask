package infrastructure.pageObjects_Playbuzz.resultSection;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static com.codeborne.selenide.Selenide.$;


public class ResultSection {
    public static By TITLE = By.className("LC20lb");
    public static By LINKED_URL = By.className("TbwUpd");
    public static By DESCRIPTION = By.className("st");
    public static By SECTION_LOCATOR = By.className("rc");

    private WebDriver driver = null;
    private int sectionIndex = 0;
    private WebElement sectionElement = null;


    public ResultSection(int indexLocation,WebDriver driver) {
        this.driver = driver;
        setSectionIndex(indexLocation);
    }

    public WebElement getSectionElement() {
        return sectionElement;
    }

    public void setSectionIndex(int indexLocation) {
        sectionIndex = indexLocation;
        sectionElement = getSectionByIndex(indexLocation);
    }


    public List<WebElement> getAllSections() {
        $(SECTION_LOCATOR).waitUntil(Condition.appears,10);
        return driver.findElements(SECTION_LOCATOR);
    }

    public WebElement getSectionByIndex(int indexLocation) {
        return getAllSections().get(indexLocation);
    }

    public String getUrl(){
        return $(sectionElement).find(LINKED_URL).getText();
    }

    public void clickOnUrl(){
        $(sectionElement).find(LINKED_URL).click();
    }

    public String getDescription(){
        return $(sectionElement).find(DESCRIPTION).getText();
    }

    public int getResultsSize(){
        return getAllSections().size();
    }






}
