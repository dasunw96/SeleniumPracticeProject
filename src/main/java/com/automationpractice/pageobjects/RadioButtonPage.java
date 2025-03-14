package com.automationpractice.pageobjects;

import com.automationpractice.actiondriver.Action;
import com.automationpractice.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonPage extends BaseClass {

    Action action = new Action();

    public RadioButtonPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//table[@id='j_idt87:console2']//tr/td//input")
    private List <WebElement> defaultSelectedRadioBtn;

    @FindBy(id = "j_idt87:age:0")
    private WebElement ageRadioBtn;

    @FindBy(xpath = "//label[@for='j_idt87:age:0']")
    private WebElement ageRadioBtnLabel;

    public boolean isSelectedDropdown(){
       return action.isSelectedFromList(getDriver(),defaultSelectedRadioBtn);
    }

    public void selectAge(){
        boolean flag = action.isSelected(getDriver(),ageRadioBtn);
        if(!flag){
            action.click(getDriver(),ageRadioBtnLabel);
        }
    }
}
