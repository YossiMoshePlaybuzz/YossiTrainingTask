package infrastructure.utils.ui;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory extends BrowserManager {
    public WebDriver CreateInstance(String browserType) {
        switch(browserType.toLowerCase())
        {
            case "chrome":
                return initRemoteChromeDriver();
            case "firefox":
                return initRemoteFFDriver();
            default:
                throw new IllegalStateException("Unexpected value: " + browserType.toLowerCase());
        }
    }

}
