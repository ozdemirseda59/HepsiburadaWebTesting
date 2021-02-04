package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SettingBrowser {
    private static WebDriver driver;

    public static WebDriver StartBrowser(String BrowserName)
    {
        if (BrowserName.equals("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (BrowserName.equals("chrome"))
        {
            ChromeOptions option=new ChromeOptions();
            option.setPageLoadStrategy(PageLoadStrategy.EAGER);
            //option.addArguments("--headless");
            option.addArguments("-incognito");
            option.addArguments("--disable-popup-blocking");
            option.addArguments("--window-size=1920,1080");
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver(option);
            JSWaiter.setDriver(driver);
        }
        else if (BrowserName.equals("IE"))
        {
            driver = new InternetExplorerDriver();
        }

        return driver;
    }
}
