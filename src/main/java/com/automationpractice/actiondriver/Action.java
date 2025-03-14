package com.automationpractice.actiondriver;

import com.automationpractice.actioninterface.ActionInterface;
import com.automationpractice.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Action extends BaseClass implements ActionInterface {

    @Override
    public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);

    }

    @Override
    public void click(WebDriver driver, WebElement ele) {

        Actions act = new Actions(driver);
        act.moveToElement(ele).click().build().perform();

    }

    @Override
    public boolean clearText(WebElement ele) {
        boolean flag = false;
        try {
            flag = ele.isDisplayed();
            ele.clear();
            // logger.info("Entered text :"+text);
            flag = true;
        } catch (Exception e) {
            System.out.println("Location Not found");
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully cleared");
            } else {
                System.out.println("Unable to clear value");
            }

        }
        return flag;
    }


    @Override
    public boolean findElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            ele.isDisplayed();
            flag = true;
        } catch (Exception e) {
            // System.out.println("Location not found: "+locatorName);
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully Found element at");

            } else {
                System.out.println("Unable to locate element at");
            }
        }
        return flag;
    }

    @Override
    public int findElements(WebDriver driver, List <WebElement> ele) {
        return ele.size();
    }

    @Override
    public void selectFromElements(WebDriver lDriver,List<WebElement> ele,String text) {
        for(WebElement element :ele){
            String option = element.getText();
            if(option.equalsIgnoreCase(text)){
                element.click();
                break;
            }
        }
    }

    @Override
    public void selectExceptFromElements(WebDriver lDriver,List<WebElement> ele,String text) {
        for(WebElement element :ele){
            String option = element.getText();
            if(!option.equalsIgnoreCase(text)){
                element.click();
            }
        }
    }

    @Override
    public boolean isDisplayed(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isDisplayed();
            if (flag) {
                System.out.println("The element is Displayed");
            } else {
                System.out.println("The element is not Displayed");
            }
        } else {
            System.out.println("Not displayed ");
        }
        return flag;
    }

    @Override
    public boolean isSelected(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isSelected();
            if (flag) {
                System.out.println("The element is Selected");
            } else {
                System.out.println("The element is not Selected");
            }
        } else {
            System.out.println("Not selected ");
        }
        return flag;
    }

    @Override
    public boolean isSelectedFromList(WebDriver driver, List <WebElement> elements) {
        boolean flag = false;
        for(WebElement ele : elements) {
            flag = findElement(driver, ele);
            if (flag) {
                flag = ele.isSelected();
                if (flag) {
                    System.out.println("The element is Selected");
                    break;
                } else {
                    System.out.println("The element is not Selected");
                }
            } else {
                System.out.println("Not selected ");
            }
        }
        return flag;
    }

    @Override
    public boolean isEnabled(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isEnabled();
            if (flag) {
                System.out.println("The element is Enabled");
            } else {
                System.out.println("The element is not Enabled");
            }
        } else {
            System.out.println("Not Enabled ");
        }
        return flag;
    }

    @Override
    public String getLocation(WebElement ele) {

        Point location = ele.getLocation();
        int x = location.getX();
        int y = location.getY();
        return "X position is " + x + " and "+"Y position is " + y;
    }

    @Override
    public String getColor(WebElement ele, String cssValue) {

        return ele.getCssValue(cssValue);
    }

    @Override
    public String getText(WebElement ele) {

        return ele.getText();
    }



    @Override
    public boolean type(WebElement ele, String text) {
        boolean flag = false;
        try {
            flag = ele.isDisplayed();
            ele.clear();
            ele.sendKeys(text);
            // logger.info("Entered text :"+text);
            flag = true;
        } catch (Exception e) {
            System.out.println("Location Not found");
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully entered value");
            } else {
                System.out.println("Unable to enter value");
            }

        }
        return flag;
    }

    @Override
    public boolean typeAndMove(WebElement ele, String text, String nxtFieldText) {
        boolean flag = false;
        try {
            flag = ele.isDisplayed();
            ele.clear();
            ele.sendKeys(text + Keys.TAB + nxtFieldText);
            // logger.info("Entered text :"+text);
            flag = true;
        } catch (Exception e) {
            System.out.println("Location Not found");
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully moved and entered value");
            } else {
                System.out.println("Unable to enter value");
            }

        }
        return flag;
    }

    @Override
    public boolean AppendText(WebElement ele, String text) {
        boolean flag = false;
        try {
            flag = ele.isDisplayed();
            ele.sendKeys(text);
            // logger.info("Entered text :"+text);
            flag = true;
        } catch (Exception e) {
            System.out.println("Location Not found");
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully entered value");
            } else {
                System.out.println("Unable to enter value");
            }

        }
        return flag;
    }

    @Override
    public boolean selectBySendkeys(String value, WebElement ele) {
        boolean flag = false;
        try {
            ele.sendKeys(value);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Select value from the DropDown");
            } else {
                System.out.println("Not Selected value from the DropDown");
                // throw new ElementNotFoundException("", "", "")
            }
        }
    }

    @Override
    public boolean selectByIndex(WebElement element, int index) {
        boolean flag = false;
        try {
            Select s = new Select(element);
            s.selectByIndex(index);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by Index");
            } else {
                System.out.println("Option not selected by Index");
            }
        }
    }


    @Override
    public boolean selectByValue(WebElement element, String value) {
        boolean flag = false;
        try {
            Select s = new Select(element);
            s.selectByValue(value);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by Value");
            } else {
                System.out.println("Option not selected by Value");
            }
        }
    }

    @Override
    public boolean selectByVisibleText(String visibletext, WebElement ele) {
        boolean flag = false;
        try {
            Select s = new Select(ele);
            s.selectByVisibleText(visibletext);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by VisibleText");
            } else {
                System.out.println("Option not selected by VisibleText");
            }
        }
    }

    @Override
    public boolean mouseHoverByJavaScript(WebElement ele) {
        boolean flag = false;
        try {
            WebElement mo = ele;
            String javaScript = "var evObj = document.createEvent('MouseEvents');"
                    + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                    + "arguments[0].dispatchEvent(evObj);";
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(javaScript, mo);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("MouseOver Action is performed");
            } else {
                System.out.println("MouseOver Action is not performed");
            }
        }
    }

    @Override
    public boolean JSClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            // WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);
            // driver.executeAsyncScript("arguments[0].click();", element);

            flag = true;

        } catch (Exception e) {
            throw e;

        } finally {
            if (flag) {
                System.out.println("Click Action is performed");
            } else if (!flag) {
                System.out.println("Click Action is not performed");
            }
        }
        return flag;
    }

    @Override
    public boolean switchToFrameByIndex(WebDriver driver, int index) {
        boolean flag = false;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
            driver.switchTo().frame(index);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Frame with index \"" + index + "\" is selected");
            } else {
                System.out.println("Frame with index \"" + index + "\" is not selected");
            }
        }
    }


    @Override
    public boolean switchToFrameById(WebDriver driver, String idValue) {
        boolean flag = false;
        try {
            driver.switchTo().frame(idValue);
            flag = true;
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        } finally {
            if (flag) {
                System.out.println("Frame with Id \"" + idValue + "\" is selected");
            } else {
                System.out.println("Frame with Id \"" + idValue + "\" is not selected");
            }
        }
    }

    /**
     * This method switch the to frame using frame Name.
     *
     * @param nameValue : Frame Name wish to switch
     */
    @Override
    public boolean switchToFrameByName(WebDriver driver, String nameValue) {
        boolean flag = false;
        try {
            driver.switchTo().frame(nameValue);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Frame with Name \"" + nameValue + "\" is selected");
            } else if (!flag) {
                System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
            }
        }
    }

    @Override
    public boolean switchToDefaultFrame(WebDriver driver) {
        boolean flag = false;
        try {
            driver.switchTo().defaultContent();
            flag = true;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (flag) {
                // SuccessReport("SelectFrame ","Frame with Name is selected");
            } else if (!flag) {
                // failureReport("SelectFrame ","The Frame is not selected");
            }
        }
    }

    @Override
    public void mouseOverElement(WebDriver driver, WebElement element) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(element).build().perform();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                System.out.println(" MouserOver Action is performed on ");
            } else {
                System.out.println("MouseOver action is not performed on");
            }
        }
    }

    @Override
    public boolean moveToElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            // WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", ele);
            Actions actions = new Actions(driver);
            // actions.moveToElement(driver.findElement(locator)).build().perform();
            actions.moveToElement(ele).perform();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean mouseover(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(ele).perform();
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            /*
             * if (flag) {
             * SuccessReport("MouseOver ","MouserOver Action is performed on \""+locatorName
             * +"\""); } else {
             * failureReport("MouseOver","MouseOver action is not performed on \""
             * +locatorName+"\""); }
             */
        }
    }

    @Override
    public boolean draggable(WebDriver driver, WebElement source, int x, int y) {
        boolean flag = false;
        try {
            new Actions(driver).dragAndDropBy(source, x, y).perform();
            Thread.sleep(5000);
            flag = true;
            return true;

        } catch (Exception e) {

            return false;

        } finally {
            if (flag) {
                System.out.println("Draggable Action is performed on \"" + source + "\"");
            } else if (!flag) {
                System.out.println("Draggable action is not performed on \"" + source + "\"");
            }
        }
    }

    @Override
    public boolean draganddrop(WebDriver driver, WebElement source, WebElement target) {
        boolean flag = false;
        try {
            new Actions(driver).dragAndDrop(source, target).perform();
            //new Actions(driver).clickAndHold(source).release(target).build().perform();
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("DragAndDrop Action is performed");
            } else if (!flag) {
                System.out.println("DragAndDrop Action is not performed");
            }
        }
    }

    @Override
    public boolean slider(WebDriver driver, WebElement ele, int x, int y) {
        boolean flag = false;
        try {
            // new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
            // .perform();
            new Actions(driver).dragAndDropBy(ele, x, y).build().perform();
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Slider Action is performed");
            } else {
                System.out.println("Slider Action is not performed");
            }
        }
    }

    @Override
    public boolean selectText(WebDriver driver) {
        boolean flag = false;
        try {
            new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Text selected");
            } else if (!flag) {
                System.out.println("Not selected");
            }
        }
    }

    @Override
    public boolean selectMultipleItems(WebDriver driver , List <WebElement> ele) {
        boolean flag = false;
        try {
            new Actions(driver).keyDown(Keys.CONTROL);
            for(WebElement element :ele){
                new Actions(driver).click(element).perform();
            }
            new Actions(driver).keyUp(Keys.CONTROL).perform();
            return flag = true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Text selected");
            } else if (!flag) {
                System.out.println("Not selected");
            }
        }
    }

    @Override
    public boolean findDownloadedFile(String path , String fileName) {
        boolean flag = false;
        try {
            File file = new File(path);
            File[] totalFiles = file.listFiles();
            for(File findFile :totalFiles){
                if(findFile.getName().equalsIgnoreCase(fileName)){
                    flag = true;
                    break;
                }
            }
            return flag;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("File downloaded");
            } else if (!flag) {
                System.out.println("File not downloaded");
            }
        }
    }

    @Override
    public boolean fileUpload(String path) {
        boolean flag = false;
        try {
            StringSelection selection = new StringSelection(path);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            flag = true;
            return flag;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Successful");
            } else if (!flag) {
                System.out.println("File not found");
            }
        }
    }

    @Override
    public boolean rightclick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            Actions clicker = new Actions(driver);
            clicker.contextClick(ele).perform();
            flag = true;
            return true;
            // driver.findElement(by1).sendKeys(Keys.DOWN);
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("RightClick Action is performed");
            } else {
                System.out.println("RightClick Action is not performed");
            }
        }
    }

    @Override
    public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
        boolean flag = false;
        try {
            Set<String> windowList = driver.getWindowHandles();

            String[] array = windowList.toArray(new String[0]);

            driver.switchTo().window(array[count - 1]);

            if (driver.getTitle().contains(windowTitle)) {
                flag = true;
            } else {
                flag = false;
            }
            return flag;
        } catch (Exception e) {
            //flag = true;
            return false;
        } finally {
            if (flag) {
                System.out.println("Navigated to the window with title");
            } else {
                System.out.println("The Window with title is not Selected");
            }
        }
    }

    @Override
    public boolean switchToNewWindow(WebDriver driver) {
        boolean flag = false;
        try {

            Set<String> s = driver.getWindowHandles();
            Object[] popup = s.toArray();
            driver.switchTo().window(popup[1].toString());
            flag = true;
            return flag;
        } catch (Exception e) {
            flag = false;
            return flag;
        } finally {
            if (flag) {
                System.out.println("Window is Navigated with title");
            } else {
                System.out.println("The Window with title: is not Selected");
            }
        }
    }

    @Override
    public int openedWindowsCount(WebDriver driver) {

     Set<String> s = driver.getWindowHandles();
     return s.size();
    }

    @Override
    public boolean switchToOldWindow(WebDriver driver) {
        boolean flag = false;
        try {

            Set<String> s = driver.getWindowHandles();
            Object[] popup = s.toArray();
            driver.switchTo().window(popup[0].toString());
            flag = true;
            return flag;
        } catch (Exception e) {
            flag = false;
            return flag;
        } finally {
            if (flag) {
                System.out.println("Focus navigated to the window with title");
            } else {
                System.out.println("The Window with title: is not Selected");
            }
        }
    }

    @Override
    public void closeWindowsExceptParent(WebDriver driver) {

            Set<String> s = driver.getWindowHandles();
            Object[] popup = s.toArray();
            String oldWindow = popup[0].toString();
            for (String allWindows : s){
                if(!allWindows.equals(oldWindow)){
                    driver.switchTo().window(allWindows);
                    driver.close();
                }
            }

    }

    @Override
    public int getColumncount(WebElement row) {
        List<WebElement> columns = row.findElements(By.tagName("td"));
        int a = columns.size();
        System.out.println(columns.size());
        for (WebElement column : columns) {
            System.out.print(column.getText());
            System.out.print("|");
        }
        return a;
    }

    @Override
    public int getRowCount(WebElement table) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int a = rows.size() - 1;
        return a;
    }


    /**
     * Verify alert present or not
     *
     * @return: Boolean (True: If alert preset, False: If no alert)
     */
    @Override
    public boolean Alert(WebDriver driver) {
        boolean presentFlag = false;
        Alert alert = null;

        try {
            // Check the presence of alert
            alert = driver.switchTo().alert();
            // if present consume the alert
            alert.accept();
            presentFlag = true;
        } catch (NoAlertPresentException ex) {
            // Alert present; set the flag

            // Alert not present
            ex.printStackTrace();
        } finally {
            if (presentFlag) {
                System.out.println("The Alert is handled successfully");
            } else {
                System.out.println("There was no alert to handle");
            }
        }

        return presentFlag;
    }

    @Override
    public boolean AlertDismiss(WebDriver driver) {
        boolean presentFlag = false;
        Alert alert = null;

        try {
            // Check the presence of alert
            alert = driver.switchTo().alert();
            // if present consume the alert
            alert.dismiss();
            presentFlag = true;
        } catch (NoAlertPresentException ex) {
            // Alert present; set the flag

            // Alert not present
            ex.printStackTrace();
        } finally {
            if (presentFlag) {
                System.out.println("The Alert is handled successfully");
            } else {
                System.out.println("There was no alert to handle");
            }
        }

        return presentFlag;
    }

    @Override
    public boolean AlertSendKeys(WebDriver driver, String text) {
        boolean presentFlag = false;
        Alert alert = null;

        try {
            // Check the presence of alert
            alert = driver.switchTo().alert();
            // if present consume the alert
            alert.sendKeys(text);
            alert.accept();
            presentFlag = true;
        } catch (NoAlertPresentException ex) {
            // Alert present; set the flag

            // Alert not present
            ex.printStackTrace();
        } finally {
            if (presentFlag) {
                System.out.println("The Alert is handled successfully");
            } else {
                System.out.println("There was no alert to handle");
            }
        }

        return presentFlag;
    }

    @Override
    public boolean launchUrl(WebDriver driver, String url) {
        boolean flag = false;
        try {
            driver.navigate().to(url);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Successfully launched \"" + url + "\"");
            } else {
                System.out.println("Failed to launch \"" + url + "\"");
            }
        }
    }

    @Override
    public boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex) {
            return false;
        }   // catch
    }

    @Override
    public String getTitle(WebDriver driver) {
        boolean flag = false;

        String text = driver.getTitle();
        if (flag) {
            System.out.println("Title of the page is: \"" + text + "\"");
        }
        return text;
    }

    @Override
    public String getattribute(WebElement ele, String attribute) {
        return ele.getDomAttribute(attribute);
    }

    @Override
    public int validateBrokenLink(String url) {

        int respCode = 200;

        try {
            HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());

            huc.setRequestMethod("HEAD");

            huc.connect();

            respCode = huc.getResponseCode();

            if (respCode >= 400) {
                System.out.println(url + " is a broken link");
            } else {
                System.out.println(url + " is a valid link");
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return respCode;
    }


        @Override
        public String getCurrentURL(WebDriver driver)  {
            boolean flag = false;

            String text = driver.getCurrentUrl();
            if (flag) {
                System.out.println("Current URL is: \""+text+"\"");
            }
            return text;
        }

        @Override
        public boolean click1(WebElement locator, String locatorName) {
            boolean flag = false;
            try {
                locator.click();
                flag = true;
                return true;
            } catch (Exception e) {
                return false;
            } finally {
                if (flag) {
                    System.out.println("Able to click on \""+locatorName+"\"");
                } else {
                    System.out.println("Click Unable to click on \""+locatorName+"\"");
                }
            }

        }

        @Override
        public void fluentWait(WebDriver driver,WebElement element, int timeOut) {
            Wait<WebDriver> wait = null;
            try {
                wait = new FluentWait<WebDriver>((WebDriver) driver)
                        .withTimeout(Duration.ofSeconds(timeOut))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(Exception.class);
                wait.until(ExpectedConditions.visibilityOf(element));
                element.click();
            }catch(Exception e) {
            }
        }
        @Override
        public void implicitWait(WebDriver driver, int timeOut) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
        }
        @Override
        public void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        @Override
        public void pageLoadTimeOut(WebDriver driver, int timeOut) {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
        }
        @Override
        public String screenShot(WebDriver driver, String filename) {
            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

            try {
                FileUtils.copyFile(source, new File(destination));
            } catch (Exception e) {
                e.getMessage();
            }
            // This new path for jenkins
            String newImageString = "http://localhost:8080/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
                    + dateName + ".png";
            return newImageString;
        }
        @Override
        public String getCurrentTime() {
            String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
            return currentDate;
        }
}
