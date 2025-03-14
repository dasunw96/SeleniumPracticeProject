package com.automationpractice.pageobjects;

import com.automationpractice.actiondriver.Action;
import com.automationpractice.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TextBoxPage extends BaseClass {

    Action action = new Action();

    public TextBoxPage() {
        PageFactory.initElements(getDriver(), this);

    }

    @FindBy(id = "j_idt88:name")
    private WebElement typeNameTxtBx;

    @FindBy(id = "j_idt88:j_idt91")
    private WebElement appendTxtBx;

    @FindBy(id = "j_idt88:j_idt93")
    private WebElement disabledTxtBx;

    @FindBy(id = "j_idt88:j_idt95")
    private WebElement clearTxtBx;

    @FindBy(id = "j_idt88:j_idt99")
    private WebElement emailTxtBx;

    @FindBy(xpath = "//input[@id='j_idt106:auto-complete_input']")
    private WebElement nameTxtBox;

    @FindBy(xpath = "//span[@id='j_idt106:auto-complete_panel']/ul/li")
    private List<WebElement> nameList;

    public String title(){
        return action.getTitle(getDriver());
    }

    public void typeName(String name){
        action.type(typeNameTxtBx,name);
    }

    public void appendTxt(String txt){
        action.AppendText(appendTxtBx,txt);
    }

    public boolean disabledTxt(){
        return action.isEnabled(getDriver(),disabledTxtBx);
    }

    public void clearTxt(){
        action.clearText(clearTxtBx);
    }

    public void typeEmailMoveToNxt(String email,String text){
        action.typeAndMove(emailTxtBx,email,text);
    }

    public void typeNameAndSelect(String name,String text){
        action.scrollByVisibilityOfElement(getDriver(),nameTxtBox);
        action.type(nameTxtBox,name);
        action.selectFromElements(getDriver(),nameList,text);
    }

    public void selectTextAndTypeNew(String name){
        action.selectText(getDriver());
        action.type(typeNameTxtBx,name);
    }




}
