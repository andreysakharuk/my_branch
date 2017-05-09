package consumer.porch.steps;


import consumer.porch.pages.LevelOnePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Steps {
    private WebDriver driver;

    public void initializeBrowser(){
        this.driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void openPage(String url){
        driver.get(url);
    }

    public void closeBrowser(){
        driver.close();
    }

    public String getActualZipHint(){
        LevelOnePage page1 = new LevelOnePage(driver);
        return page1.getZipHint();
    }

    public String getActualServicingHint(){
        LevelOnePage page1 = new LevelOnePage(driver);
        return page1.getServicingHint();
    }

    public String getActualHints(){
        LevelOnePage page1 = new LevelOnePage(driver);
        return page1.getTextHints();
    }

    public String getActualProTypeUrl() {
        LevelOnePage page1 = new LevelOnePage(driver);
        return page1.getPlumbersUrl();
    }

    public String getActualServiceTypeUrl() {
        LevelOnePage page1 = new LevelOnePage(driver);
        return page1.getPlumbersServicesUrl();
    }

    public String getActualCustomerCareUrl() {
        LevelOnePage page1 = new LevelOnePage(driver);
        return page1.getCustomerCareUrl();
    }

    public String getActualTermsOfServiceUrl() {
        LevelOnePage page1 = new LevelOnePage(driver);
        return page1.getTermsOfServiceUrl();
    }

    public String getActualPrivacyPolicyUrl() {
        LevelOnePage page1 = new LevelOnePage(driver);
        return page1.getPrivacyPolicyUrl();
    }
/*
    public String getWhatIsPorchActualCustomerCareUrl() {
        LevelOnePage page1 = new LevelOnePage(driver);
        return page1.getWhatIsPorchCustomerCareUrl();
    }
 */

    public String getActualPlaceholderServicingField() {
        LevelOnePage page1 = new LevelOnePage(driver);
        return page1.getPlaceholderServicingField();
    }

    public String getActualPlaceholderZipField() {
        LevelOnePage page1 = new LevelOnePage(driver);
        return page1.getPlaceholderZipField();
    }

}
