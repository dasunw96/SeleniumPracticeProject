package com.automationpractice.testcases;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pageobjects.CheckBoxPage;
import com.automationpractice.pageobjects.IndexPage;
import com.automationpractice.pageobjects.RadioButtonPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckBoxPageTest extends BaseClass {

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
    public void CheckBoxOperations() throws InterruptedException {

        indexPage = new IndexPage();
        CheckBoxPage checkBoxPage = indexPage.clickCheckBoxMenu();
        checkBoxPage.clickLanguageCheckBoxes();
        Thread.sleep(4000);

    }
}
