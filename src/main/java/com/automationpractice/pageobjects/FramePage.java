package com.automationpractice.pageobjects;

import com.automationpractice.actiondriver.Action;
import com.automationpractice.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FramePage extends BaseClass {

    Action action = new Action();

    public FramePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "Click")
    private WebElement frameBtn;

    @FindBy(tagName = "iframe")
    private List<WebElement> frameCount;

    public String clickFirstBtn(){
        action.switchToFrameByIndex(getDriver(),0);
        action.click(getDriver(),frameBtn);
        return action.getText(frameBtn);

    }

    public void switchToDefaultFrame(){
        action.switchToDefaultFrame(getDriver());
    }

    public String clickNestedFrame(){
        action.switchToFrameByIndex(getDriver(),2);
        action.switchToFrameById(getDriver(),"frame2");
        action.click(getDriver(),frameBtn);
        return action.getText(frameBtn);

    }

    public int countFrame(){
        return action.findElements(getDriver(),frameCount);
    }


}
