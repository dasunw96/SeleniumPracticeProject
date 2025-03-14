package com.automationpractice.testcases;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pageobjects.ButtonPage;
import com.automationpractice.pageobjects.IndexPage;
import com.automationpractice.pageobjects.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ButtonPageTest extends BaseClass {

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
        ButtonPage buttonPage = indexPage.clickButtonMenu();
        indexPage = buttonPage.clickGotoDashboard();
        Assert.assertEquals(indexPage.getTitle(),"Dashboard","Invalid Title");
        buttonPage = indexPage.clickButtonMenu();
        String enabled = String.valueOf(buttonPage.clickDisabledBtn());
        Assert.assertEquals(enabled,"false","This button is not disabled");
        String location = buttonPage.getBtnLocation();
        System.out.println(location);
        String btnColor = buttonPage.getBtnColor();
        System.out.println("Button color is " +btnColor);

        Thread.sleep(4000);

    }
}
