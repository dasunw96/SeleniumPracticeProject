import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable {

    WebDriver driver;

    @BeforeTest
    public void init() throws InterruptedException {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com");
        Thread.sleep(4000);
    }

    @Test
    public void webTableTest() throws InterruptedException {

        //row count
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
        int rowCount = rows.size();
        System.out.println("Row count is : "+ rowCount);

        //column count
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th"));
        int columnCount = columns.size();
        System.out.println("Column count is : "+ columnCount);

        //select specific cell
        WebElement cell = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[3]/td[3]"));
        String cellData = cell.getText();
        System.out.println("Cell data is : "+ cellData);

        //Retrieve all values of table
        for(int i=1;i<=rowCount;i++){
            for(int j=1;j<columnCount;j++){
                cell = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]"));
                cellData = cell.getText();
                System.out.print(cellData +"\t");
            }
            System.out.println();
        }

        //Retrieve ID and Name only
        for(int i=1;i<=rowCount;i++){
                String id = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
                String name = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
                System.out.println(id + "\t" + name);
            }

        //retrieve specific value

        for(int i=1;i<=rowCount;i++){
            String name = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();

            if(name.equalsIgnoreCase("Smartwatch")){
                String price = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[3]")).getText();
                System.out.println("Product price is : " + price);

            }
        }

        //select all the checkboxes in all pages

        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']/li"));
        int pageCount = pages.size();
        for(int i=0;i<pageCount;i++){
            pages.get(i).click();
            Thread.sleep(3000);
            for (int j=1;j<rowCount;j++){
                WebElement checkbox = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td[4]/input"));
                boolean selected = checkbox.isSelected();
                if(!selected){
                    checkbox.click();
                    Thread.sleep(2000);
                }
            }
        }
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }



}
