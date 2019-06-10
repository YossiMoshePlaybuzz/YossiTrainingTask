package infrastructure.utils.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserManager {
    protected WebDriver driver = null;
    protected String url = "https://www.google.com/";

    public WebDriver getBrowser(String browserType) throws IOException, SAXException, ParserConfigurationException {
        switch(browserType.toLowerCase())
        {
            case "chrome":
                return initRemoteChromeDriver();
                //return initChromeDriver();
            case "firefox":
                return initRemoteFFDriver();
                //return initFFDriver();
            case "ie":
                return initIEDriver();
            default:
                throw new IllegalStateException("Unexpected value: " + browserType.toLowerCase());
        }
    }

    public WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/AutomationTraining/src/main/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public WebDriver initRemoteChromeDriver() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:/AutomationTraining/src/main/java/drivers/chromedriver.exe");
        DesiredCapabilities cap = setChromeCapabilities();
        driver = new RemoteWebDriver(setHubUrl(),cap);
        return driver;
    }

    public DesiredCapabilities setChromeCapabilities()
    {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setBrowserName("chrome");
        return cap;
    }

    public URL setHubUrl() throws MalformedURLException {
        return new URL("http://localhost:4444/wd/hub");
    }
    public WebDriver initIEDriver() {
        System.setProperty("webdriver.ie.driver", "C:/AutomationTraining/src/main/java/drivers/IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        return driver;
    }

    public WebDriver initFFDriver() throws ParserConfigurationException, SAXException, IOException {
        System.setProperty("webdriver.gecko.driver", "C:/AutomationTraining/src/main/java/drivers/geckodriver.exe");
        File pathBinary = new File("C:/AutomationTraining/src/main/java/drivers/geckodriver.exe");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        driver = new FirefoxDriver(firefoxBinary, firefoxProfile);

        return driver;
    }

    public WebDriver initRemoteFFDriver() throws ParserConfigurationException, SAXException, IOException {
        System.setProperty("webdriver.gecko.driver", "C:/AutomationTraining/src/main/java/drivers/geckodriver.exe");
        DesiredCapabilities cap = setFFCapabilities();
        driver = new RemoteWebDriver(setHubUrl(),cap);
        return driver;
    }

    public DesiredCapabilities setFFCapabilities() {
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setBrowserName("firefox");
        return cap;
    }

    public void setBrowserSettings(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


}
