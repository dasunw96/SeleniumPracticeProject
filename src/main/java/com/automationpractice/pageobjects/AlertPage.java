package com.automationpractice.pageobjects;

import com.automationpractice.actiondriver.Action;
import com.automationpractice.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlertPage extends BaseClass {

    Action action = new Action();

    public AlertPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "j_idt88:j_idt91")
    private WebElement simpleAlertBtn;

    @FindBy(xpath = "//span[@id='simple_result']")
    private WebElement simpleAlertResult;

    @FindBy(id = "j_idt88:j_idt93")
    private WebElement confirmAlertBtn;

    @FindBy(xpath = "//span[@id='result']")
    private WebElement confirmAlertResult;

    @FindBy(id = "j_idt88:j_idt104")
    private WebElement promtAlertBtn;

    @FindBy(xpath = "//span[@id='confirm_result']")
    private WebElement promtAlertResult;

    public String clickSimpleAlertBtn(){
        action.click(getDriver(),simpleAlertBtn);
        action.Alert(getDriver());
        return action.getText(simpleAlertResult);

    }

    public WebElement getSimpleAlertBtn() {
        return simpleAlertBtn;
    }

    public String clickConfirmAlertBtn(){
        action.click(getDriver(),confirmAlertBtn);
        action.AlertDismiss(getDriver());
        return action.getText(confirmAlertResult);

    }

    public String clickPromtAlertBtn(String text){
        action.click(getDriver(),promtAlertBtn);
        action.AlertSendKeys(getDriver(),text);
        return action.getText(promtAlertResult);

    }
}
