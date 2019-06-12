package infrastructure.utils.ui;

import org.openqa.selenium.WebDriver;
import java.io.IOException;


public class WebDriverFactory extends BrowserManager {
    public WebDriver CreateInstance(String browserType) throws IOException {
        switch(browserType.toLowerCase())
        {
            case "chrome":
                return initRemoteChromeDriver();
            case "firefox":
                return initRemoteFFDriver();
            case "ie":
                return initIEDriver();
            default:
                throw new IllegalStateException("Unexpected value: " + browserType.toLowerCase());
        }
    }

}
