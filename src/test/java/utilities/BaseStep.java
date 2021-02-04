package utilities;

import org.openqa.selenium.WebDriver;
import pages.ProductListingPage;
import pages.HomePage;
import pages.ProductDetailPage;

public class BaseStep {
    // Initialization
    protected static WebDriver driver=null;
    protected static HomePage homePage=null;
    protected static ProductListingPage productListingPage=null;
    protected static ProductDetailPage productDetailPage=null;

    protected void setupCucumber () {
        driver= SettingBrowser.StartBrowser("chrome");
        homePage=new HomePage(driver);
        productListingPage=new ProductListingPage(driver);
        productDetailPage=new ProductDetailPage(driver);
    }
    protected void teardown(){
        driver.quit();
    }
}
