package com.automationpractice.pageobjects;

import com.automationpractice.actiondriver.Action;
import com.automationpractice.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {

    Action action = new Action();

    public IndexPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "menuform:j_idt40" )
    private WebElement elementMenu;

    @FindBy(id = "menuform:m_input" )
    private WebElement textBoxMenu;

    @FindBy(id = "menuform:m_link" )
    private WebElement linkMenu;

    @FindBy(id = "menuform:m_button" )
    private WebElement buttonMenu;

    @FindBy(id = "menuform:m_dropdown" )
    private WebElement drpDownMenu;

    @FindBy(id = "menuform:m_radio" )
    private WebElement radioMenu;

    @FindBy(id = "menuform:m_checkbox" )
    private WebElement checkBoxMenu;

    @FindBy(id = "menuform:j_idt39" )
    private WebElement browserMenu;

    @FindBy(id = "menuform:m_overlay" )
    private WebElement AlertMenu;

    @FindBy(id = "menuform:m_window" )
    private WebElement windowMenu;

    @FindBy(id = "menuform:m_frame" )
    private WebElement frameMenu;

    @FindBy(id = "menuform:m_drag" )
    private WebElement dragMenu;

    @FindBy(id = "menuform:j_idt42" )
    private WebElement listMenu;

    @FindBy(id = "menuform:m_list" )
    private WebElement listSubMenu;

    @FindBy(id = "menuform:j_idt43" )
    private WebElement miscMenu;

    @FindBy(id = "menuform:m_file" )
    private WebElement fileMenu;

    @FindBy(id = "menuform:m_wait" )
    private WebElement waitMenu;



    public void clickElementMenu(){
        action.click(getDriver(),elementMenu);
    }

    public TextBoxPage clickTextBoxMenu(){

        action.click(getDriver(),elementMenu);
        action.click(getDriver(),textBoxMenu);
        return new TextBoxPage();
    }

    public LinkPage clickLinkMenu(){

        action.click(getDriver(),elementMenu);
        action.click(getDriver(),linkMenu);
        return new LinkPage();
    }

    public ButtonPage clickButtonMenu(){

        action.click(getDriver(),elementMenu);
        action.click(getDriver(),buttonMenu);
        return new ButtonPage();
    }

    public DropdownPage clickDropDownMenu(){

        action.click(getDriver(),elementMenu);
        action.click(getDriver(),drpDownMenu);
        return new DropdownPage();
    }

    public RadioButtonPage clickRadioBtnMenu(){

        action.click(getDriver(),elementMenu);
        action.click(getDriver(),radioMenu);
        return new RadioButtonPage();
    }

    public CheckBoxPage clickCheckBoxMenu(){

        action.click(getDriver(),elementMenu);
        action.click(getDriver(),checkBoxMenu);
        return new CheckBoxPage();
    }

    public AlertPage clickAlertMenu(){

        action.click(getDriver(),browserMenu);
        action.click(getDriver(),AlertMenu);
        return new AlertPage();
    }

    public WindowPage clickWindowMenu(){

        action.click(getDriver(),browserMenu);
        action.click(getDriver(),windowMenu);
        return new WindowPage();
    }
    public FramePage clickFrameMenu(){

        action.click(getDriver(),browserMenu);
        action.click(getDriver(),frameMenu);
        return new FramePage();
    }

    public MouseActionPage clickDragMenu(){

        action.click(getDriver(),browserMenu);
        action.click(getDriver(),dragMenu);
        return new MouseActionPage();
    }

    public KeyboardActionPage clickListSubMenu(){

        action.click(getDriver(),listMenu);
        action.click(getDriver(),listSubMenu);
        return new KeyboardActionPage();
    }

    public FilePage clickFileMenu(){

        action.click(getDriver(),miscMenu);
        action.click(getDriver(),fileMenu);
        return new FilePage();
    }

    public WaitPage clickWaitMenu(){

        action.click(getDriver(),elementMenu);
        action.click(getDriver(),waitMenu);
        return new WaitPage();
    }

    public String getTitle(){

        return action.getTitle(getDriver());
    }







}
