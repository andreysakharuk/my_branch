package com.epam.locators.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewRepoPage extends AbstractPage{
    private static final String URL2 = "https://github.com/new";

    @FindBy(id = "repository_name")
    private WebElement repoNameField;

    @FindBy(xpath = "//button[@class='btn btn-primary first-in-line']")
    private WebElement createButton;

    public NewRepoPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL2);
    }

    public void createRepo(String repoName) {
        repoNameField.sendKeys(repoName);
        createButton.click();
    }
}
