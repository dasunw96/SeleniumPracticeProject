package com.automationpractice.testcases;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pageobjects.FramePage;
import com.automationpractice.pageobjects.IndexPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FramePageTest extends BaseClass {

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
        FramePage framePage = indexPage.clickFrameMenu();
        String text = framePage.clickFirstBtn();
        Assert.assertEquals(text,"Hurray! You Clicked Me.");

        framePage.switchToDefaultFrame();

        framePage.clickNestedFrame();
        Assert.assertEquals(text,"Hurray! You Clicked Me.");
        Thread.sleep(4000);

        framePage.switchToDefaultFrame();

        int count = framePage.countFrame();
        Assert.assertEquals(count,3);



    }
}
