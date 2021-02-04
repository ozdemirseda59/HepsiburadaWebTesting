package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BasePage;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) { super(driver); }

    //*********Web Elements*********
    //Search Field
    By searchInputBy=By.xpath("//div[@id='SearchBoxOld']//input");
    By searchButtonBy=By.className("SearchBoxOld-buttonContainer");

    public void fileReader(){jsonFileReader();}

    public void goToHepsiburada(String url) throws Exception {
        if(url.equals("")){
            driver.get(baseURL);
        }
        else {
            driver.get(url);
        }
        pageOnLoad();
    }

    public void productSearch(String text) throws Exception {
        sendText(searchInputBy,text);
        waitAndClick(searchButtonBy);
        checkForUrlContains("ara?q=iphone");
    }





  /*  public void clickToTabListAndCheckBoutiqueImageLoaded() throws Exception {
        List<WebElement> tabList = waitVisibilityAndFindElements(tabListBy);
        for (int i=0;i <tabList.size();i++){
            tabList.get(i).click();
            pageOnLoad();
            checkForUrlContains("butik");
            checkImageLoaded(bigBoutiqueImagBy,"Ana sayfa butik görselleri yüklenmemiştir");
            tabList = waitVisibilityAndFindElements(tabListBy);
        }
    }
    //Verify Username Condition
    public void verifyUser(String expectedText) throws Exception {
        assertEquals(verifyUserBy,expectedText);
    }

    public void clickRandomBotique() throws Exception {
        clickRandomElement(boutiqueImagHref);
    }*/

}
