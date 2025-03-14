package com.automationpractice.pageobjects;

import com.automationpractice.actiondriver.Action;
import com.automationpractice.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonPage extends BaseClass {

    Action action = new Action();

    public ButtonPage() {
        PageFactory.initElements(getDriver(), this);

    }

    public String title(){
        return action.getTitle(getDriver());
    }

    @FindBy(id = "j_idt88:j_idt90")
    private WebElement gotoDashboard;

    @FindBy(id = "j_idt88:j_idt92")
    private WebElement disabledBtn;

    @FindBy(id = "j_idt88:j_idt94")
    private WebElement locationBtn;

    @FindBy(id = "j_idt88:j_idt96")
    private WebElement btnColor;

    public IndexPage clickGotoDashboard(){
        action.click(getDriver(),gotoDashboard);
        return new IndexPage();
    }

    public boolean clickDisabledBtn(){
        return action.isEnabled(getDriver(),disabledBtn);
    }

    public String getBtnLocation(){
        return action.getLocation(locationBtn);
    }

    public String getBtnColor(){
        return action.getColor(btnColor,"background-color");
    }





}
