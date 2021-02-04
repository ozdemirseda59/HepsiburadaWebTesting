package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BasePage;

public class ProductDetailPage extends BasePage {
    public ProductDetailPage(WebDriver driver) { super(driver); }

    //Reviews Tab
    By reviewsTabBy=By.id("reviewsTabTrigger");
    By yesButtonBy=By.xpath(".//div[@class='hermes-ReviewCard-module-tAGUS'][1]");
    By thanksTextBy=By.xpath("//span[contains(@class, 'hermes-ReviewCard-module') and contains(text(), 'Teşekkür')]");

    public void verifyProductDetailPage() throws Exception {
        checkForUrlContains("p-");
    }

    public void clickToReviewsTab(){
        waitAndClick(reviewsTabBy);
    }
    public void likeToReview(){
        if(isElementPresent(yesButtonBy)){
            waitAndClick(yesButtonBy);
            move(thanksTextBy);
            waitVisibilityText(thanksTextBy);
        }
    }

}
