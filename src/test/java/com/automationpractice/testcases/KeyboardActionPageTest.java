package com.automationpractice.testcases;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pageobjects.IndexPage;
import com.automationpractice.pageobjects.KeyboardActionPage;
import com.automationpractice.pageobjects.MouseActionPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class KeyboardActionPageTest extends BaseClass {

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
    public void keyboardOperations() throws InterruptedException {

        indexPage = new IndexPage();
        KeyboardActionPage keyboardActionPage = indexPage.clickListSubMenu();
        keyboardActionPage.selectMultipleItems();
        Thread.sleep(4000);

    }
}
