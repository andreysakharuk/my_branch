package com.epam.locators;

import com.epam.locators.steps.StepsLoc;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DemoTest {
    private static final String USER_NAME = "andreysakharuk";
    private static final String USER_PASSWORD = "waq123git";
    private static final String REPO = "porch";
    private static final String REPO_NAME = "new repo";
    private StepsLoc stepsLoc;

    @BeforeMethod(description = "init browser")
    public void setUp(){
        stepsLoc = new StepsLoc();
        stepsLoc.initBrowser();
    }

    @Test
    public void userCanLogin(){
        stepsLoc.loginGitHub(USER_NAME, USER_PASSWORD);
        Assert.assertTrue(stepsLoc.isUserLoggedIn(REPO));
    }

    @Test
    public void userCanCreateNewRepository(){
        stepsLoc.loginGitHub(USER_NAME, USER_PASSWORD);
        stepsLoc.createNewRepo(REPO_NAME);
    }

    @AfterMethod(description = "close browser")
    public void tearDown(){
        stepsLoc.closeBrowser();

    }
}

/*
        WebDriver driver = new FirefoxDriver();
        driver.get("https://github.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("login_field")).sendKeys(USER_NAME);
        driver.findElement(By.id("password")).sendKeys(USER_PASSWORD);
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.xpath("//a[@aria-label='View profile and more']")).click();
        String userName = driver.findElement(By.xpath("//strong[@class='css-truncate-target']")).getText();
        Assert.assertEquals(userName,"andreysakharuk");
*/