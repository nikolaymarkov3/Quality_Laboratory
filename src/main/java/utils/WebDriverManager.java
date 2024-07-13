package utils;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverManager {
    
    private static WebDriverManager INSTANCE;
    
    private WebDriverManager() {
    }
    
    public static WebDriverManager getInst() {
        if (INSTANCE == null) {
            INSTANCE = new WebDriverManager();
        }
        return INSTANCE;
    }
    
    public WebDriver getDriver(String browserName) throws MalformedURLException {
        return switch (browserName.toLowerCase()) {
            case "firefox" -> Driver.getFirefoxDriver();
            case "chrome" -> Driver.getChromeDriver();
            case "edge" -> Driver.getEdgeDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserName);
        };
    }
}