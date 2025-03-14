package com.automationpractice.testcases;
import com.automationpractice.base.BaseClass;
import com.automationpractice.pageobjects.FilePage;
import com.automationpractice.pageobjects.IndexPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FilePageTest extends BaseClass {

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
    public void fileOperations() throws InterruptedException {

        indexPage = new IndexPage();
        FilePage filePage = indexPage.clickFileMenu();
        String path = "C:\\Users\\Dasun\\Downloads";
        String fileName = "TestLeaf Logo.png";
        filePage.clickDownload();
        Thread.sleep(4000);
        boolean flag = filePage.verifyDownload(path,fileName);
        Assert.assertTrue(flag);
        Thread.sleep(3000);
        filePage.clickUpload();
        Thread.sleep(3000);
        String uploadFilePath = path+"\\"+fileName;
        //flag = filePage.uploadFileUsingSendKeys(uploadFilePath);
        flag = filePage.uploadFile(uploadFilePath);
        Assert.assertTrue(flag);
        Thread.sleep(3000);

    }
}
