package infrastructure.utils.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static org.awaitility.Awaitility.with;

public class BrowserManager {
    protected WebDriver driver = null;
    protected String url = System.getProperty("url");
    private static int timeout = 30;

    public WebDriver getBrowser(String browserType) {
        WebDriverFactory factory = new WebDriverFactory();
        return factory.CreateInstance(browserType);
    }

    public WebDriver initRemoteChromeDriver() {
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

    public URL setHubUrl() {
        URL hubUrl = null;
        try {
            hubUrl = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return hubUrl;
    }


    public WebDriver initRemoteFFDriver() {
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
