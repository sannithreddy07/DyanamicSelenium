package selenium.pack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DynamicCheckboxRadios {
	
	public WebDriver driver;
	
	@Test
	public void dynamicChckRadio() throws InterruptedException {
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		Actions ac=new Actions(driver);
		
		driver.navigate().to("https://www.flipkart.com/");
		
		Thread.sleep(2000);
		
		String s="SAMSUNG";
		
		List<String> ls1=new ArrayList<String>();
		
		driver.findElement(By.name("q")).sendKeys("mobile",Keys.ARROW_DOWN,Keys.ENTER);
		
		List<WebElement> ls =driver.findElements(By.xpath("//div[@class='_3879cV']"));//input[@type ='checkbox']//following-sibling::div
		
		String totalsamdevices=null;
		
		for(WebElement temp:ls) {
			ls1.add(temp.getText());
		
			
			if(ls1.contains(s)) {
				
				temp.click();
				Thread.sleep(2000);
				totalsamdevices=driver.findElement(By.xpath("//span[@class='_10Ermr']")).getText().split(" ")[5];
				WebElement scrll=driver.findElement(By.xpath("//nav[@class='yFHi8N']//a[@class='ge-49M _2Kfbh8']"));
				WebElement nxt=driver.findElement(By.xpath("//nav[@class='yFHi8N']//a[@class='_1LKTO3']//span[text()='Next']"));
				
					while(true) {
						Thread.sleep(1000);
						ac.scrollToElement(scrll);
						Thread.sleep(2000);
					
				List<WebElement> lst=driver.findElements(By.xpath("//div[@class='_4rR01T']"));
				
				for(WebElement t:lst) {
					ls1.add(t.getText());
				}
					
					try {
						nxt=driver.findElement(By.xpath("//nav[@class='yFHi8N']//a[@class='_1LKTO3']//span[text()='Next']"));
					}catch(Exception e) {
						System.out.println("no more products found");
						break;
					}
					nxt.click();
				
					}
					
				break;
			}
		
		}
		
		System.out.println(ls1.size());
		System.out.println("totalsamdevices are : "+totalsamdevices);
		System.out.println(ls1);
		driver.quit();
	}
	

}
 