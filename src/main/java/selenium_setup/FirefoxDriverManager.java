package selenium_setup;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {
    @Override
    public void createWebDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckordiver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        driver = new FirefoxDriver(options);
    }
}
