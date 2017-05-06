package com.epam.locators.steps;

import com.epam.locators.page.LoginPage;
import com.epam.locators.page.NewRepoPage;
import com.epam.locators.page.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class StepsLoc {
    private WebDriver driver;

    public void loginGitHub(String userName, String userPassword) {
        LoginPage page = new LoginPage(driver);
        page.openPage();
        page.login(userName, userPassword);
    }

    public boolean isUserLoggedIn(String repo) {
        StartPage sPage = new StartPage(driver);
        String actualRepo = sPage.getLoggedInUserName();
        return actualRepo.equals(repo);
    }

    public void closeBrowser() {
        this.driver.close();
    }

    public void initBrowser() {
        this.driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void createNewRepo(String repoName) {
        NewRepoPage page = new NewRepoPage(driver);
        page.openPage();
        page.createRepo(repoName);
    }
}
