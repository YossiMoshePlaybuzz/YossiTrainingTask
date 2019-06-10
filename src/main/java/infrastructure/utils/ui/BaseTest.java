package infrastructure.utils.ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class BaseTest extends BrowserManager {
    //protected BrowserManager browserManager = new BrowserManager();

    @BeforeMethod
    @Parameters ({ "browserType" })
    public void DoBeforeMethod(@Optional("chrome") String browserType) throws ParserConfigurationException, SAXException, IOException {
        driver = getBrowser(browserType);
        setBrowserSettings(driver);
    }

    @AfterMethod
    public void DoAfterMethod()
    {
        driver.quit();
    }
}
