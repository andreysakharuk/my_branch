package consumer.porch;


import consumer.porch.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PorchTests {
    private static final String ZIP_HINT = "Please enter a ZIP code.";
    private static final String SERVICING_HINT = "Please enter a search query.";
    private static final String URL_LEVEL_ONE_PAGE = "http://www.consumerreports.org/home-services";
    private static final String URL_LEVEL_TWO_PAGE_PLUMBERS = "http://www.consumerreports.org/home-services/plumbers";
    private static final String URL_LEVEL_TWO_PAGE_PLUMBER_SERVICES = "http://www.consumerreports.org/home-services/plumbing-services";
    private static final String URL_LEVEL_THREE_PAGE = "http://www.consumerreports.org/home-services/plumbers/yonkers-ny?postalCode=10701";
    private static final String URL_CUSTOMER_CARE_PAGE = "http://www.consumerreports.org/customer-care/";
    private static final String URL_TERMS_OF_SERVICES_PAGE = "https://porch.com/about/terms/";
    private static final String URL_PRIVACY_POLICY_PAGE = "https://porch.com/about/privacy";
    private static final String PLACEHOLDER_SERVICING_FIELD = "What type of pro do you need?";
    private static final String PLACEHOLDER_ZIP_FIELD = "ZIP code";
    private Steps steps;

    @BeforeMethod (description = "open browser with 10sec implicit wait and 20sec load page wait")
    public void setUp(){
        steps = new Steps();
        steps.initializeBrowser();
    }


//Tests start
    @Test
    public void HintAppearsUnderEmptyZipField(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualZipHint(), ZIP_HINT , "actual Hint under empty Zip field doesn't match the example.");
    }

    @Test
    public void HintAppearsUnderEmptyServicingField(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualServicingHint(), SERVICING_HINT, "actual Hints under empty Servicing field doesn't match the example.");
    }

    @Test
    public void HintsAppearUnderEmptyZipAndServicingFields(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualHints(),  ZIP_HINT + SERVICING_HINT, "actual Hints under empty Servicing and Zip fields don't match the example.");
    }

    @Test
    public void ProTypeLinkNavigatesToLevelTwoPage(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualProTypeUrl(), URL_LEVEL_TWO_PAGE_PLUMBERS);
    }

    @Test
        public void ServiceTypeLinkNavigatesToLevelTwoPage(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualServiceTypeUrl(), URL_LEVEL_TWO_PAGE_PLUMBER_SERVICES);
    }

    @Test
    public void CustomerCareLinkNavigatesToCustomerCarePage(){
            steps.openPage(URL_LEVEL_ONE_PAGE);
            Assert.assertEquals(steps.getActualCustomerCareUrl(), URL_CUSTOMER_CARE_PAGE);
    }

    @Test
    public void TermsOfServiceLinkNavigatesToTermsOfServicePage(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualTermsOfServiceUrl(), URL_TERMS_OF_SERVICES_PAGE);
    }

    @Test
    public void PrivacyPolicyLinkNavigatesToPrivacyPolicyPage(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualPrivacyPolicyUrl(), URL_PRIVACY_POLICY_PAGE);
    }

/*
    @Test
    public void WhatIsPorchCustomerCareLinkNavigatesToCustomerCarePage(){
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getWhatIsPorchActualCustomerCareUrl(), URL_CUSTOMER_CARE_PAGE);
    }
*/

    @Test
    public void PlaceholderIsInServicingField() {
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualPlaceholderServicingField(), PLACEHOLDER_SERVICING_FIELD);
    }

    @Test
    public void PlaceholderIsInZipField() {
        steps.openPage(URL_LEVEL_ONE_PAGE);
        Assert.assertEquals(steps.getActualPlaceholderZipField(), PLACEHOLDER_ZIP_FIELD);
    }
//Tests finish


    @AfterMethod (description = "close browser")
    public void tearDown(){
        steps.closeBrowser();
    }



}
