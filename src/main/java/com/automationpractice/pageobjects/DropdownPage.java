package com.automationpractice.pageobjects;

import com.automationpractice.actiondriver.Action;
import com.automationpractice.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DropdownPage extends BaseClass {

    Action action = new Action();

    public DropdownPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String title(){
        return action.getTitle(getDriver());
    }

    @FindBy(xpath = "//select[@class='ui-selectonemenu']")
    private WebElement toolDrpDown;

    @FindBy(xpath = "//select[@id='j_idt87:country_input']/option")
    private List <WebElement> countOptionsDrpDown;

    @FindBy(xpath = "//div[@id='j_idt87:lang']")
    private WebElement languageDrpDown;

    @FindBy(xpath = "//ul[@id='j_idt87:lang_items']/li")
    private List <WebElement> languageDrpDownOptions;


    public void selectFirstDropDown(String text){
        action.selectByVisibleText(text,toolDrpDown);
    }

    public int getDropdownOptionCount(){
        return action.findElements(getDriver(),countOptionsDrpDown);
    }

    public void selectBySendKeys(String text){
        action.selectBySendkeys(text,toolDrpDown);
    }

    public void selectBootstrapDrpDown(String text){
        action.click(getDriver(),languageDrpDown);
        action.selectFromElements(getDriver(),languageDrpDownOptions,text);
    }

}
