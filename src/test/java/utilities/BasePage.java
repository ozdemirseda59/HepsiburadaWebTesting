package utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    //Json File
    protected static String baseURL="";
    JSONObject model;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    protected void jsonFileReader(){
        JSONParser jsonParser = new JSONParser();
        String config_env = System.getProperty("env");
        config_env = config_env == null ? "test" : config_env;

        try (FileReader reader = new FileReader("config." + config_env + ".json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONObject url = (JSONObject) obj;

            model = (JSONObject) url.get("URL");
            baseURL = (String) model.get("BaseURL");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected  void pageOnLoad() {
        JSWaiter.waitUntilJSReady();
    }

    protected void waitAndClick (By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
        pageOnLoad();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    //Move Method
    protected void move(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(waitVisibilityAndFindElement(by));
        actions.build().perform();
    }

    protected List<WebElement> waitVisibilityAndFindElements (By by) { return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));}

    protected List<WebElement> waitPresenceAndFindElements(By by ) {return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));}

    protected WebElement waitVisibilityAndFindElement (By by) { return wait.until(ExpectedConditions.visibilityOfElementLocated(by)); }


    protected String waitVisibilityText(By by) { return waitVisibilityAndFindElement(by).getText(); }

    protected void sendText (By by, String text) { waitVisibilityAndFindElement(by).sendKeys(text); }

    //Verify Page’s Url Condition
    protected  void checkForUrlContains (String expected) throws Exception { wait.until(ExpectedConditions.urlContains(expected)); }

    protected  static String xpat="";
    protected void clickRandomElement(By elementBy){
        List<WebElement> elementByList=waitVisibilityAndFindElements(elementBy);
        if(elementByList.size()>0) {
            Random rnd=new Random();
            int index =rnd.nextInt(elementByList.size());
            WebElement element= elementByList.get(index);
            xpat= element.getAttribute("xpath");
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().perform();
            pageOnLoad();
        }
    }

    protected  void checkImageLoaded(By imagElementBy, String errorMessage){
        pageOnLoad();
        List<WebElement> imagElementByList=waitPresenceAndFindElements(imagElementBy);
        for (int i=0; i<imagElementByList.size();i++){
            Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", imagElementByList.get(i));
            if (!ImagePresent) {
                //Assert.fail(errorMessage);
                System.out.println(i+ ". görsel "+errorMessage);
            }

        }

    }
}
