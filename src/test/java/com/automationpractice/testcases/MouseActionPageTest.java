package com.automationpractice.testcases;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pageobjects.FramePage;
import com.automationpractice.pageobjects.IndexPage;
import com.automationpractice.pageobjects.MouseActionPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MouseActionPageTest extends BaseClass {

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
    public void MouseOperations() throws InterruptedException {

        indexPage = new IndexPage();
        MouseActionPage mouseActionPage = indexPage.clickDragMenu();
        mouseActionPage.mouseHover();
        mouseActionPage.dragAndDrop();
        mouseActionPage.moveSliderPoint1();
        Thread.sleep(4000);




    }
}
