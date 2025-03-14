package com.automationpractice.pageobjects;

import com.automationpractice.actiondriver.Action;
import com.automationpractice.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPage extends BaseClass {

    Action action = new Action();

    public CheckBoxPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//table[@id='j_idt87:basic']//label")
    private List<WebElement> checkBoxList;

    public void clickLanguageCheckBoxes(){
        action.selectExceptFromElements(getDriver(),checkBoxList,"others");
    }


}
