package com.automationpractice.testcases;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pageobjects.DropdownPage;
import com.automationpractice.pageobjects.IndexPage;
import com.automationpractice.pageobjects.RadioButtonPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RadioButtonPageTest extends BaseClass {

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
    public void RadioButtonOperations() throws InterruptedException {

        indexPage = new IndexPage();
        RadioButtonPage radioButtonPage = indexPage.clickRadioBtnMenu();
        boolean flag = radioButtonPage.isSelectedDropdown();
        Assert.assertTrue(flag);
        radioButtonPage.selectAge();

        Thread.sleep(4000);

    }
}
