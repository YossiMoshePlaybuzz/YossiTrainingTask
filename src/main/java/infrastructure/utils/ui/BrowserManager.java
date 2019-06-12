package infrastructure.utils.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static org.awaitility.Awaitility.with;

public class BrowserManager {
    protected WebDriver driver = null;
    protected String url = System.getProperty("url");
    private static int timeout = 30;

    public WebDriver getBrowser(String browserType) throws IOException {
        WebDriverFactory factory = new WebDriverFactory();
        return factory.CreateInstance(browserType);
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

    public WebDriver initRemoteFFDriver() throws IOException {
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

    public void waitForUrlToAppear(String url,WebDriver driver) {
        with()
                .alias("URL was not become = " + url)
                .pollInSameThread()
                .await()
                .atMost(timeout, TimeUnit.SECONDS).until(() -> isUrlAppear(url,driver));
    }

    public boolean isUrlAppear(String url, WebDriver driver){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains(url);
    }


}
