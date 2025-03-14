package com.automationpractice.pageobjects;

import com.automationpractice.actiondriver.Action;
import com.automationpractice.base.BaseClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitPage extends BaseClass {

    Action action = new Action();

    public WaitPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "j_idt87:j_idt89")
    private WebElement btnOne;

    @FindBy(xpath = "//button[@id='j_idt87:j_idt90']/span")
    private WebElement btnTwoText;


    public String clickBtnOne(){

        action.click(getDriver(),btnOne);
//        WebDriverWait wait  = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(btnTwoText));

//        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
//                .withTimeout(Duration.ofSeconds(30))
//                .pollingEvery(Duration.ofSeconds(5))
//                .ignoring(NoSuchElementException.class);
//
//        WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
//            @Override
//            public WebElement apply(WebDriver webDriver) {
//                return btnTwoText;
//            }
//        });
        return action.getText(btnTwoText);

    }
}
