package com.automationpractice.testcases;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pageobjects.IndexPage;
import com.automationpractice.pageobjects.WindowPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WindowPageTest extends BaseClass {

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
    public void FrameOperations() throws InterruptedException {

        indexPage = new IndexPage();
        WindowPage windowPage = indexPage.clickWindowMenu();
        String title = windowPage.clickNewWindowBtn();
        Assert.assertEquals(title,"Dashboard");
        windowPage.closeMultipleWindows();

        windowPage.siwtchToParentWindow();
        int count = windowPage.clickMultipleWindowBtn();
        Assert.assertEquals(count,3);
        windowPage.closeMultipleWindows();

        windowPage.siwtchToParentWindow();
        int openCount = windowPage.clickCloseMultipleWindowBtn();
        windowPage.siwtchToParentWindow();
        Assert.assertEquals(openCount,1);
        Thread.sleep(4000);

    }
}
