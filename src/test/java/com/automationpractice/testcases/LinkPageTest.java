package com.automationpractice.testcases;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pageobjects.IndexPage;
import com.automationpractice.pageobjects.LinkPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LinkPageTest extends BaseClass {

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
    public void linkOperations() {

        indexPage = new IndexPage();
        LinkPage linkPage = indexPage.clickLinkMenu();
        indexPage = linkPage.goToDashborad();
        linkPage = indexPage.clickLinkMenu();
        Assert.assertEquals(linkPage.findUrl("href"),"/grid.xhtml","Invalid link");
        Assert.assertEquals(linkPage.brokenUrl(),404,"This link is not broken");
        getDriver().navigate().back();
        Assert.assertEquals(linkPage.pageLinkCount(),47,"Invalid page links count");
        Assert.assertEquals(linkPage.layoutLinkCount(),6,"Invalid layout links count");
    }

}
