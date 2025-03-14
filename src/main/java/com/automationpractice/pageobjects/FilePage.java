package com.automationpractice.pageobjects;

import com.automationpractice.actiondriver.Action;
import com.automationpractice.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilePage extends BaseClass {

    Action action = new Action();

    public FilePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "j_idt93:j_idt95")
    private WebElement downloadButton;

    @FindBy(id = "j_idt88:j_idt89")
    private WebElement uploadButton;

    @FindBy(id = "j_idt88:j_idt89_input")
    private WebElement uploadUsingSendKeys;


    public void clickDownload(){
        action.click(getDriver(),downloadButton);
    }

    public boolean verifyDownload(String path , String fileName){
        return action.findDownloadedFile(path,fileName);
    }

    public void clickUpload(){
        action.click(getDriver(),uploadButton);
    }

    public boolean uploadFile(String path){
        return action.fileUpload(path);
    }

    public boolean uploadFileUsingSendKeys(String path){
        return action.type(uploadUsingSendKeys,path);
    }
}
