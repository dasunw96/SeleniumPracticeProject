package com.automationpractice.testcases;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pageobjects.AlertPage;
import com.automationpractice.pageobjects.CheckBoxPage;
import com.automationpractice.pageobjects.IndexPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AlertPageTest extends BaseClass {

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
    public void AlertOperations() throws InterruptedException {

        indexPage = new IndexPage();
        AlertPage alertPage = indexPage.clickAlertMenu();
        String simpleText = alertPage.clickSimpleAlertBtn();
        Assert.assertEquals(simpleText,"You have successfully clicked an alert");
        String confirmText = alertPage.clickConfirmAlertBtn();
        Assert.assertEquals(confirmText,"User Clicked : Cancel");
        String alertTypeText = "Dasun";
        String promtText = alertPage.clickPromtAlertBtn(alertTypeText);
        Assert.assertEquals(promtText,"User entered name as: " +alertTypeText);
        Thread.sleep(6000);

    }
}
