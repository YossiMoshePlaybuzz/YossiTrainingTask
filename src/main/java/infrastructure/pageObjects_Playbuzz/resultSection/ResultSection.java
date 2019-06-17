package infrastructure.pageObjects_Playbuzz.resultSection;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


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
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(SECTION_LOCATOR,1));
        return driver.findElements(SECTION_LOCATOR);
    }

    public WebElement getSectionByIndex(int indexLocation) {
        return getAllSections().get(indexLocation);
    }

    public String getUrl(){
        return sectionElement.findElement(LINKED_URL).getText();
    }

    public void clickOnUrl(){
        sectionElement.findElement(LINKED_URL).click();
    }

    public String getDescription(){
        return sectionElement.findElement(DESCRIPTION).getText();
    }

    public int getResultsSize(){
        return getAllSections().size();
    }


}
