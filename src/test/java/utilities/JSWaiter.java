package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSWaiter {
    private static WebDriver jsWaitDriver;
    private static WebDriverWait jsWait;
    private static JavascriptExecutor jsExec;

    protected static void setDriver (WebDriver driver) {
        jsWaitDriver = driver;
        jsWait = new WebDriverWait(jsWaitDriver, 30);
        jsExec = (JavascriptExecutor) jsWaitDriver;
    }
    private static void ajaxComplete() {
        jsExec.executeScript("var callback = arguments[arguments.length - 1];"
                + "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
                + "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {"
                + "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
    }
    //Wait Until JS Ready
     protected static void waitUntilJSReady() {
        //Wait for Javascript to load
       jsWait.until(driver -> ((JavascriptExecutor) jsWaitDriver)
               .executeScript("return document.readyState").toString().equals("complete"));
        //Get JS is Ready
        boolean jsReady =  (Boolean) jsExec.executeScript("return document.readyState").toString().equals("complete");

        if(!jsReady) {
            waitUntilJSReady();
            ajaxComplete();
        }
    }
}
