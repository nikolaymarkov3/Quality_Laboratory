package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver firefoxDriver;
    private static WebDriver chromeDriver;
    private static WebDriver edgeDriver;
    
    private Driver() {
    }
    
    public static WebDriver getFirefoxDriver() {
        if (firefoxDriver == null) {
            firefoxDriver = new FirefoxDriver();
            firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return firefoxDriver;
    }
    
    public static WebDriver getChromeDriver() {
        if (chromeDriver == null) {
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