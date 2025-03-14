package com.automationpractice.testcases;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pageobjects.IndexPage;
import com.automationpractice.pageobjects.WaitPage;
import com.automationpractice.pageobjects.WindowPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WaitPageTest extends BaseClass {

    private IndexPage indexPage;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){

        launchWeb(browser);
    }
    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

    @Test
    public void implicitWaitOperations(){

        indexPage = new IndexPage();
        WaitPage waitPage = indexPage.clickWaitMenu();
        String text = waitPage.clickBtnOne();
        Assert.assertEquals(text,"I am here");



    }
}
