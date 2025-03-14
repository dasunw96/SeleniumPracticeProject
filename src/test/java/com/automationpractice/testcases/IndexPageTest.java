package com.automationpractice.testcases;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pageobjects.ButtonPage;
import com.automationpractice.pageobjects.IndexPage;
import com.automationpractice.pageobjects.LinkPage;
import com.automationpractice.pageobjects.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseClass {

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
    public void verifyTextBoxMenu() throws InterruptedException {

        indexPage = new IndexPage();
        TextBoxPage textBoxpage = indexPage.clickTextBoxMenu();
        Assert.assertEquals(textBoxpage.title(),"Input Components","Invalid navigation");
    }

    @Test
    public void verifyLinkMenu() throws InterruptedException {

        indexPage = new IndexPage();
        LinkPage linkPage = indexPage.clickLinkMenu();
        Assert.assertEquals(linkPage.title(),"Link Components","Invalid navigation");
    }

    @Test
    public void verifyButtonMenu() throws InterruptedException {

        indexPage = new IndexPage();
        ButtonPage buttonPage = indexPage.clickButtonMenu();
        Assert.assertEquals(buttonPage.title(),"Button","Invalid navigation");
    }


}
