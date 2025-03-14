import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestFunctions {

    WebDriver driver = new ChromeDriver();
    @Test
    public void openWithChromeOptions() throws InterruptedException {

        //ChromeOptions chromeOptions = new ChromeOptions();
       // chromeOptions.setBrowserVersion("");
        //chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--incognito");
        //chromeOptions.addArguments("--headless");
        //WebDriver driver = new ChromeDriver(chromeOptions);


        //**** test item click

        //driver.get("https://www.leafground.com/");
       // driver.findElement(By.id("menuform:j_idt40")).click();

        // **** Date picker input = text

        driver.get("https://jqueryui.com/datepicker/");
        WebElement iframe =driver.findElement(By.xpath("//div[@id='content']/iframe"));
        driver.switchTo().frame(iframe);
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.click();
        //datePicker.sendKeys("01/02/2025");
        selectFutureDate("2025","June","8");
        Thread.sleep(3000);
        driver.quit();
    }

    public void selectFutureDate(String year, String month, String day){

        while (true){
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if(actualYear.equalsIgnoreCase(year) && actualMonth.equalsIgnoreCase(month)){
                List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
                for (WebElement date : dates){
                    if(date.getText().equalsIgnoreCase(day)){
                        date.click();
                        break;
                    }
                }
                break;
            }else{
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }
        }

    }

}
