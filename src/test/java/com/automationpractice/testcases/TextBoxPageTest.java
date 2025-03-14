package com.automationpractice.testcases;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pageobjects.IndexPage;
import com.automationpractice.pageobjects.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TextBoxPageTest extends BaseClass {

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
    public void textFieldOperations() throws InterruptedException {

        indexPage = new IndexPage();
        TextBoxPage textBoxpage = indexPage.clickTextBoxMenu();
        textBoxpage.typeName("dasun Lahiru");
        textBoxpage.selectTextAndTypeNew("Hellooo");
        textBoxpage.appendTxt(" Sri Lanka");
        Assert.assertEquals(textBoxpage.disabledTxt(),false);
        textBoxpage.clearTxt();
        textBoxpage.typeEmailMoveToNxt("dasun@gmail.com","Moved to next Element");
        textBoxpage.typeNameAndSelect("dasun","dasun2");
        Thread.sleep(4000);

    }
}
