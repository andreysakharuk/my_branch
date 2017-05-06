package com.epam.locators.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='repo']")
    private WebElement repoLabel;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInUserName() {
        return repoLabel.getText();
    }

}
