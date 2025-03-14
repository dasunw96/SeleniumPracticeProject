package com.automationpractice.testcases;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pageobjects.AlertPage;
import com.automationpractice.pageobjects.IndexPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotTest extends BaseClass {

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
    public void takeScreenshot() throws IOException, AWTException {

        indexPage = new IndexPage();
        AlertPage alertPage = indexPage.clickAlertMenu();
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + "\\ScreenShots\\" + "alertFullScreenshot.png");
        FileHandler.copy(source,destination);

        WebElement ele = alertPage.getSimpleAlertBtn();
        File sourceFile = ele.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(System.getProperty("user.dir") + "\\ScreenShots\\" + "SelectedAreaScreenshot.png");
        FileHandler.copy(sourceFile,destinationFile);

        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screenSize);
        BufferedImage source1 = robot.createScreenCapture(rectangle);
        File destination1 = new File(System.getProperty("user.dir") + "\\ScreenShots\\" + "EntireArea_robot.png");
        ImageIO.write(source1,"png",destination1);




    }
}
