package consumer.porch.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class LevelOnePage {

    private WebDriver driver;

    @FindBy(name = "query")
    private WebElement servicingField;

    @FindBy(xpath = "//div[@class='porchSearchBox-query--error']")
    private WebElement servicingHint;

    @FindBy(name = "postalcode")
    private WebElement zipField;

    @FindBy(xpath = "//div[@class='porchInput-error']")
    private WebElement zipHint;

    @FindBy(xpath = "//button[@class='porchButton']")
    private WebElement searchButton;

    @FindBy(linkText = "Plumbers")
    private WebElement plumbersLink;

    @FindBy(linkText = "Plumbing Services")
    private WebElement plumbersServicesLink;

    @FindBy(xpath = "//p[@class='porchWhatIsPorch-body ']/a[text()='Customer Care']")
    private WebElement customerCareLink;

    @FindBy(xpath = "//p[@class='porchWhatIsPorch-body ']/a[text()='Terms of Service']")
    private WebElement termsOfServiceLink;

    @FindBy(xpath = "//p[@class='porchWhatIsPorch-body ']/a[text()='Privacy Policy']")
    private WebElement privacyPolicyLink;

    @FindBy(xpath = "//span[@class='porchWhatIsPorchTrigger']")
    private WebElement whatIsPorchLink;

    @FindBy(xpath = "//button[@class='porchCloseButton']")
    private WebElement whatIsPorchCloseButton;


    public LevelOnePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getZipHint(){
        servicingField.sendKeys("Plumbers");
        searchButton.click();
        return zipHint.getText();
    }

    public String getServicingHint(){
        zipField.sendKeys("10701");
        searchButton.click();
        return servicingHint.getText();
    }

    public String getTextHints(){
        searchButton.click();
        String textZipHint = zipHint.getText();
        String textServicingHint = servicingHint.getText();
        return  textZipHint + textServicingHint;
    }

    public String getPlumbersUrl(){
        plumbersLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement newyorkLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("New York NY")));
        return driver.getCurrentUrl();
    }

    public String getPlumbersServicesUrl() {
        plumbersServicesLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement newyorkLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New York NY")));
        return driver.getCurrentUrl();
    }

    public String getCustomerCareUrl() {
        customerCareLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement frequentlyAskedQuestionsLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='faqTitle']")));
        return driver.getCurrentUrl();
    }

    public String getTermsOfServiceUrl() {
        termsOfServiceLink.click();
        ArrayList<String> openedTabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(openedTabs.get(1));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement termsOfUseLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-reactid='21']")));
        return driver.getCurrentUrl();
    }

    public String getPrivacyPolicyUrl() {
        privacyPolicyLink.click();
        ArrayList<String> openedTabs= new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(openedTabs.get(1));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement privacyPolicyLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Porch Privacy Policy']")));
        return driver.getCurrentUrl();
    }

/*
    public String getWhatIsPorchCustomerCareUrl() {
        whatIsPorchLink.click();
        driver.switchTo().alert();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement whatIsPorchCloseButton2 = wait.until(ExpectedConditions.elementToBeClickable(whatIsPorchCloseButton));
        customerCareLink.click();
        WebElement privacyPolicyLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Porch Privacy Policy']")));
        return driver.getCurrentUrl();
    }
 */

    public String getPlaceholderServicingField() {
        return servicingField.getAttribute("placeholder");
    }

    public String getPlaceholderZipField() {
        return zipField.getAttribute("placeholder");
    }

}
