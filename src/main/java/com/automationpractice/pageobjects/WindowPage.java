package com.automationpractice.pageobjects;

import com.automationpractice.actiondriver.Action;
import com.automationpractice.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowPage extends BaseClass {

    Action action = new Action();

    public WindowPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "j_idt88:new")
    private WebElement openNewWindow;

    @FindBy(id = "j_idt88:j_idt91")
    private WebElement openMultipleWindow;

    @FindBy(id = "j_idt88:j_idt93")
    private WebElement closeAllWindow;

    public String clickNewWindowBtn(){
        action.click(getDriver(),openNewWindow);
        action.switchToNewWindow(getDriver());
        return action.getTitle(getDriver());

    }

    public void siwtchToParentWindow(){
        action.switchToOldWindow(getDriver());
    }

    public int clickMultipleWindowBtn(){
        action.click(getDriver(),openMultipleWindow);
       int count = action.openedWindowsCount(getDriver());
       return count;

    }

    public void closeMultipleWindows(){
        action.closeWindowsExceptParent(getDriver());
    }

    public int clickCloseMultipleWindowBtn(){
        action.click(getDriver(),closeAllWindow);
        action.closeWindowsExceptParent(getDriver());
        int count = action.openedWindowsCount(getDriver());
        return count;

    }

}
