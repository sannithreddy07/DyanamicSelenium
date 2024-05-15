package selenium.pack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicDropdown {
	
	public WebDriver driver;
	
	@Test
	public void dynamicDropdown() throws InterruptedException {
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.makemytrip.com/");
		
		Thread.sleep(2000);
		
		driver.switchTo().frame("notification-frame-~251439651");
		
		driver.findElement(By.xpath("//div[@class='container']//descendant::i[@class='wewidgeticon we_close']")).click();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(1000);
		
		String select="Rajiv Gandhi International Airport";
		
		WebElement from=driver.findElement(By.id("fromCity"));
		
		from.sendKeys("hyd");
		
		Thread.sleep(1500);
		
		boolean flag=false;
		
		List<WebElement> list=driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
		
		for(WebElement templs:list) {
			String ls=templs.getText();
			
			if(ls.contains(select)) {
				Thread.sleep(1500);
				templs.click();
				flag=true;
				break;
			}
		}
		if(flag==true) {
			System.out.println("option selected");
		}else {
			System.out.println("option not selected");
		}
		
		driver.quit();
		
	}
	
	@Test
	public void flipkart() throws InterruptedException {
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.flipkart.com/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("q")).sendKeys("iphone",Keys.ARROW_DOWN,Keys.ENTER);
		
		Thread.sleep(2000);
		
		WebElement ele=driver.findElement(By.xpath("//div[text()='Apple iPhone 13 (Pink, 128 GB)']"));
		
		if(ele.isDisplayed()) {
			Assert.assertTrue(true);
			String iphonename=ele.getText();
			
			System.out.println(iphonename);
		}else {
			Assert.assertTrue(false);
		}
	
		driver.close();

		
		
	}

}
