package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BasePage;


public class ProductListingPage extends BasePage {
    public ProductListingPage(WebDriver driver) { super(driver); }

    //*********Web Elements*********
    //Product List
    By productImag=By.xpath(".//img[contains(@class,'product-image')]");
    By productListHrefBy=By.xpath(".//div[@class='box product no-hover']//a");


    //*********Page Methods*********
    public  void checkProductImageLoaded() {
        checkImageLoaded(productImag,"Ürün Listesi Görseli Yüklenmemiştir");
    }

    public void clickRandomProduct() throws Exception {
        clickRandomElement(productListHrefBy);
    }

}
