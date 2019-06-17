package infrastructure.pageObjects_Playbuzz.resultSection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ResultSection {
    public static By TITLE = By.className("LC20lb");
    public static By LINKED_URL = By.className("TbwUpd");
    public static By DESCRIPTION = By.className("st");

    protected int sectionIndex = 0 ;
    protected WebElement SectionElement = null;

    public ResultSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
