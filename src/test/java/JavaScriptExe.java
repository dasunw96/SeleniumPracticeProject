import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptExe {

    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeTest
    public void init() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com");
        Thread.sleep(4000);
    }

    @Test
    public void jsExecute(){

        jsExecutor = (JavascriptExecutor) driver;

        WebElement txtBox = driver.findElement(By.id("name"));
        jsExecutor.executeScript("arguments[0].value='Dasun';",txtBox);

        WebElement btn = driver.findElement(By.id("singleFileInput"));
        scroll(btn);


    }

    public void scroll(WebElement btn){

        //jsExecutor.executeScript("window.scrollTo(0,1000);");
       // jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        //jsExecutor.executeScript("window.scrollTo(0,0);");
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",btn);

    }
}
