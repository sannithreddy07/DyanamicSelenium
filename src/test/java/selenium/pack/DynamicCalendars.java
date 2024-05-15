package selenium.pack;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicCalendars {

	public WebDriver driver;

	@BeforeTest
	public void lauch()  {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/calendar-practice.html");
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}

	//to select current date directly from a calendar with just 30/31 days

	@Test(priority=1,enabled = false)
	public void dynamicCalendar() throws InterruptedException {
		String day="19";
		driver.findElement(By.id("first_date_picker")).click();
		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(3));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td/a[text()="+day+"]")).click();
		Thread.sleep(2000);
		

	} 
	
	//To get a current date directly from a calendar having previous and next months dates in it which are greyed out
	@Test(priority=2 , enabled = false)
	public void dynamicCaal2() throws InterruptedException {
		String day="1";
	driver.findElement(By.id("second_date_picker")).click();
	WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(3));
	wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
	driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td/a[not(contains(@class,'ui-state-default ui-priority-secondary'))][text()="+day+"]")).click();
	Thread.sleep(2000);

}
	@Test(priority = 3)
	public void dynaCal3() throws Exception {
		Calendar c=Calendar.getInstance();
		try {
		String futuredate="25/Mar/2025";
		SimpleDateFormat sd=new SimpleDateFormat("dd/MMM/yyyy");
		sd.setLenient(false);
		Date d=sd.parse(futuredate);
		
		c.setTime(d);
		}catch(Exception e) {
			throw new Exception("Invalid input date provided");
		}
		int fm=c.get(Calendar.MONTH);
		int fyr=c.get(Calendar.YEAR);
		int fd=c.get(Calendar.DAY_OF_MONTH);
		
		
		driver.findElement(By.id("second_date_picker")).click();
		
		Thread.sleep(2000);
		
		String cm=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
	
		c.setTime(new SimpleDateFormat("MMM yyyy").parse(cm));
		
		int cm1=c.get(Calendar.MONTH);
		int cyr=c.get(Calendar.YEAR);
		
		while(cm1 < fm || cyr < fyr) {
			
			Thread.sleep(1000);
			

			WebElement ele=driver.findElement(By.className("ui-datepicker-next"));
			

			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",ele);
			
			 cm=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			
			c.setTime(new SimpleDateFormat("MMM yyyy").parse(cm));
			
			 cm1=c.get(Calendar.MONTH);
			 cyr=c.get(Calendar.YEAR);
			
		}
		if(cm1==fm && cyr == fyr) {
			driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td/a[not(contains(@class,'ui-state-default ui-priority-secondary'))][text()="+fd+"]")).click();
		}else 
			throw new Exception("unable to select the date");
	
	}
	
	@Test
	public void dynaCal4() throws InterruptedException {

		String day="19";
		driver.findElement(By.id("third_date_picker")).click();
		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(3));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
		Select s=new Select(driver.findElement(By.className("ui-datepicker-month")));
		s.selectByVisibleText("Jul");
		Select s1=new Select(driver.findElement(By.className("ui-datepicker-year")));
		s1.selectByVisibleText("2025");
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td/a[text()="+day+"]")).click();
		Thread.sleep(2000);
		
	}
}
