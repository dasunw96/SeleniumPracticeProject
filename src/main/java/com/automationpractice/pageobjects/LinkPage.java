package com.automationpractice.pageobjects;

import com.automationpractice.actiondriver.Action;
import com.automationpractice.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LinkPage extends BaseClass {

    Action action = new Action();

    public LinkPage() {
        PageFactory.initElements(getDriver(), this);

    }

    @FindBy(linkText = "Go to Dashboard")
    private WebElement gotoDashboard;

    @FindBy(partialLinkText = "Find the URL without")
    private WebElement withoutClick;

    @FindBy(partialLinkText = "Broken?")
    private WebElement brokenLink;

    @FindBy(tagName = "a")
    private List<WebElement> allPageLinks;

    @FindBy(xpath = "//div[@class='layout-main-content']//a")
    private List<WebElement> layoutLinks;

    public String title(){
        return action.getTitle(getDriver());
    }

    public IndexPage goToDashborad(){
        action.click(getDriver(),gotoDashboard);
        return new IndexPage();
    }

    public String findUrl(String attribute){
        return action.getattribute(withoutClick,attribute);
    }

    public int brokenUrl(){
        action.click(getDriver(),brokenLink);
        return action.validateBrokenLink(action.getCurrentURL(getDriver()));
    }

    public int pageLinkCount(){
        return(action.findElements(getDriver(),allPageLinks));
    }

    public int layoutLinkCount(){
        return(action.findElements(getDriver(),layoutLinks));
    }

}
