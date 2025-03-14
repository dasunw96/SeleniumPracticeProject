package com.automationpractice.pageobjects;

import com.automationpractice.actiondriver.Action;
import com.automationpractice.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseActionPage extends BaseClass {

    Action action = new Action();

    public MouseActionPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "menuform:j_idt37")
    private WebElement homeBtn;

    @FindBy(id = "menuform:j_idt38")
    private WebElement browserBtn;

    @FindBy(id = "menuform:j_idt39")
    private WebElement elementBtn;

    @FindBy(id = "form:drag")
    private WebElement dragItem;

    @FindBy(id = "form:drop")
    private WebElement dropPlace;

    @FindBy(xpath = "//div[@id='form:j_idt125']/span[1]")
    private WebElement sliderPoint1;

    public void mouseHover(){
        action.mouseover(getDriver(),homeBtn);
        action.mouseover(getDriver(),browserBtn);
        action.mouseover(getDriver(),elementBtn);

    }

    public void dragAndDrop(){
        action.draganddrop(getDriver(),dragItem,dropPlace);

    }

    public void moveSliderPoint1(){
        action.slider(getDriver(),sliderPoint1,-50,0);
    }
}
