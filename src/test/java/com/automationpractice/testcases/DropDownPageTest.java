package com.automationpractice.testcases;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pageobjects.DropdownPage;
import com.automationpractice.pageobjects.IndexPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DropDownPageTest extends BaseClass {

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
    public void dropDownOperations() throws InterruptedException {

        indexPage = new IndexPage();
        DropdownPage dropdownPage = indexPage.clickDropDownMenu();
        dropdownPage.selectFirstDropDown("Playwright");
        int optionCount = dropdownPage.getDropdownOptionCount();
        Assert.assertEquals(optionCount,5,"Invalid option count");
        dropdownPage.selectBySendKeys("Cypress");
        dropdownPage.selectBootstrapDrpDown("Telugu");

        Thread.sleep(4000);

    }
}
