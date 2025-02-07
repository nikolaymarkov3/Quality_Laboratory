package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {

    private static WebDriver firefoxDriver;
    private static WebDriver chromeDriver;
    private static WebDriver edgeDriver;
    private static RemoteWebDriver firefoxDriverR;
    
    private Driver() {
    }
    
    public static RemoteWebDriver getFirefoxDriver() throws MalformedURLException {
        if (firefoxDriverR == null) {
            FirefoxOptions options = new FirefoxOptions();
////            options.setCapability("browserVersion", "125.0");
//            options.setCapability("selenoid:options", new HashMap<String, Object>() {{
//                /* How to add test badge */
//                put("name", "Test badge...");
//
//                /* How to set session timeout */
//                put("sessionTimeout", "15m");
//
//                /* How to set timezone */
//                put("env", new ArrayList<String>() {{
//                    add("TZ=UTC");
//                }});
//
//                /* How to add "trash" button */
//                put("labels", new HashMap<String, Object>() {{
//                    put("manual", "true");
//                }});
//
//                /* How to enable video recording */
//                put("enableVideo", true);
//            }});
            
            
            firefoxDriverR = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
//            firefoxDriver = new FirefoxDriver();
            firefoxDriverR.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return firefoxDriverR;
    }
    
    public static WebDriver getChromeDriver() throws MalformedURLException {
        if (chromeDriver == null) {
//            ChromeOptions options = new ChromeOptions();
////            options.setCapability("browserVersion", "128.0");
//            options.setCapability("selenoid:options", new HashMap<String, Object>() {{
//                /* How to add test badge */
//                put("name", "Test badge...");
//
//                /* How to set session timeout */
//                put("sessionTimeout", "15m");
//
//                /* How to set timezone */
//                put("env", new ArrayList<String>() {{
//                    add("TZ=UTC");
//                }});
//
//                /* How to add "trash" button */
//                put("labels", new HashMap<String, Object>() {{
//                    put("manual", "true");
//                }});
//
//                /* How to enable video recording */
//                put("enableVideo", true);
//            }});
//            RemoteWebDriver remoteChromeDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            chromeDriver = new ChromeDriver();
            chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return chromeDriver;
    }
    
    public static WebDriver getEdgeDriver() {
        if (edgeDriver == null) {
            edgeDriver = new EdgeDriver();
            edgeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return edgeDriver;
    }
    
}