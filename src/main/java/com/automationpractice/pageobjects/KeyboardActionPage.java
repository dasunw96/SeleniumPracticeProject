package com.automationpractice.pageobjects;

import com.automationpractice.actiondriver.Action;
import com.automationpractice.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KeyboardActionPage extends BaseClass {

    Action action = new Action();

    public KeyboardActionPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//ul[@aria-label='From']/li")
    private List<WebElement> listFrom;

    @FindBy(xpath = "//button[@title='Add all']")
    private WebElement addAllBtn;


    public void selectMultipleItems(){
        action.selectMultipleItems(getDriver(),listFrom);
        action.click(getDriver(),addAllBtn);

    }
}
