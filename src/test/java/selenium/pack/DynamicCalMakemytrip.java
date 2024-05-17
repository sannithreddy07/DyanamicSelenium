package selenium.pack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicCalMakemytrip {
	
	private WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	@Test
	public void date1() throws InterruptedException {
		String s= "June 2024";
		String day="29";
		driver.navigate().to("https://phptravels.net/tours/vi/india/kirti-nagar/tours/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//*[@id=\"date\"]")).click();
		
		Thread.sleep(2000);
		while(true) {
			String s1=driver.findElement(By.xpath("//*[@id=\"#fadein\"]/div[8]/div[1]/table/thead/tr[1]/th[2]")).getText();
			System.out.println(s1);
			if(s1.equals(s)) {
				break;
			}else {
				driver.findElement(By.cssSelector("div.datepicker.dropdown-menu:nth-child(25) div.datepicker-days table.table-condensed thead:nth-child(1) tr:nth-child(1) th.next > svg:nth-child(1)")).click();
			}
			
		}
		driver.findElement(By.xpath("//div[@class='datepicker-days']//tr//td[not(contains(@class,'day disabled'))][not(contains(@class,'day  new'))][text()="+day+"]")).click();
		
//		 String date = "Wednesday, May 22, 2024";
//	        
//	        // Split the date string into an array of strings
//	        String[] parts = date.split(", ");
//	        
//	        // Display each part
//	        for (String part : parts) {
//	            System.out.println(part);
//	        }
	}

}
//List<WebElement> ls	=driver.findElements(By.xpath("//table[@class=' table-condensed']//tbody//tr//td[not(contains(@class,'day disabled'))][not(contains(@class,'day  new'))]"));
//for(WebElement t:ls) {
//	//div[@class='datepicker-days']//tr//td[not(contains(@class,'day disabled'))][not(contains(@class,'day  new'))]
//}

//div[@role='button'][@aria-label='Move forward to switch to the next month.']
//body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr/td[@aria-disabled='false']







