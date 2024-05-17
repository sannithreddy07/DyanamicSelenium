package selenium.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Makemytrip  {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to chromedriver.exe
       
        
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
       Thread.sleep(2000);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));)
        
        // Open United Airlines website
        driver.navigate().to("https://www.makemytrip.com/");
        
        Thread.sleep(6000);
        
      
        
        driver.switchTo().frame("notification-frame-~10cb51856");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(120));
        WebElement close=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']"))));
        close.click();
        driver.switchTo().defaultContent();
        
       WebElement close2= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@data-cy='closeModal']"))));
        close2.click();
        driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("h");
        Actions ac=new Actions(driver);
        ac.pause(Duration.ofSeconds(5))
      
        .sendKeys(Keys.ARROW_DOWN)
        .sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("m");
        ac.pause(Duration.ofSeconds(5))
        
        .sendKeys(Keys.ARROW_DOWN)
        .sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        WebElement ele1=driver.findElement(By.xpath("//input[@id='departure']"));
        wait.until(ExpectedConditions.visibilityOf(ele1));
        ele1.click();
        String month=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")).getText();
        System.out.println("month");
      //div[@class='DayPicker-Caption']/div[text()='June']/span[text()='2024']
      //span[@aria-label='Next Month']
      //div[contains(@class,'DayPicker-Day--selected')]/div/p[text()='10']
      //div[@class='DayPicker-Day']/div/p[text()='18']
driver.close();
    }
}


	
	


