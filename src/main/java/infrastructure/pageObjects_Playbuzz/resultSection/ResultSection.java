package infrastructure.pageObjects_Playbuzz.resultSection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultSection {
    public static By TITLE = By.className("LC20lb");
    public static By LINKED_URL = By.className("TbwUpd");
    public static By DESCRIPTION = By.className("st");

    @FindBy(className = "LC20lb")
    private WebElement title;

    @FindBy(className = "TbwUpd")
    private WebElement linkedUrl;

    @FindBy(className = "st")
    private WebElement description;

    public WebElement linkedUrl(){
        return linkedUrl;
    }

    public WebElement getTitle(){
        return title;
    }

    public WebElement description(){
        return description;
    }

    public ResultSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
